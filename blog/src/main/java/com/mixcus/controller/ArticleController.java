package com.mixcus.controller;


import com.mixcus.service.ArticleService;
import com.mixcus.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/article")
@CrossOrigin(origins = "*")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/getArticleList")
    public PageResult getArticleList(){
        return articleService.getArticleList();
    }


}

