package com.mixcus.controller;


import com.mixcus.pojo.User;
import com.mixcus.service.UserService;
import com.mixcus.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    //登入
    @PostMapping("/login")
    public Result login(@RequestBody User user){

        int flag = userService.hasUserName(user.getUsername());

        if(user.getUsername()==null){
            return new Result(false,"账号不能为空");
        }
        if(user.getPassword()==null){
            return new Result(false,"密码不能为空");
        }

        if(flag==0){
            //表示账号不存在
            return new Result(false,"账号不存在");
        }else {

            String userName = user.getUsername();

            int id = userService.getUserId(userName);

            String token = userService.getToken(userName,id);

            //账号存在则判断密码是否相等
            String pwd = userService.getPassword(user.getUsername());

            if(pwd.equals(user.getPassword())){

                return new Result(true,"登入成功",token);
            }else{

                return new Result(false,"账号或密码错误");
            }
        }
    }

    @RequestMapping("/register")
    public Result register(@RequestBody User user){

        int flag = userService.hasUserName(user.getUsername());

        if(flag!=0){
            return new Result(false,"账号已存在,请重新输入");
        }

        userService.addUser(user.getUsername(),user.getPassword());

        return new Result(true,"注册成功");
    }

}

