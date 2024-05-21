package com.mixcus.controller;


import com.mixcus.pojo.Article;
import com.mixcus.service.ArticleService;
import com.mixcus.entity.PageResult;
import com.mixcus.entity.Pagination;
import com.mixcus.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/article")
@CrossOrigin("*")
public class ArticleController {

    @Autowired
    private ArticleService articleService;
    @PostMapping("/getArticleList")
    public Result getArticleList(){
        return new Result(true,articleService.getArticleList());
    }

    @PostMapping("/editArticle")
    public Result editArticle(@RequestBody Article article){
        return articleService.editArticle(article);
    }

    @DeleteMapping("/{id}")
    public Result deleteArticle(@PathVariable int id){
        System.out.println(id);
        return articleService.deleteArticleById(id);
    }
    @PostMapping("/queryArticle")
    public Result queryArticle(@RequestBody Pagination pagination){
        return new Result(true,"查询成功",articleService.queryArticle(pagination));
    }

}



