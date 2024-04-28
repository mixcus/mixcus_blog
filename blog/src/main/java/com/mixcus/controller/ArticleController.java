package com.mixcus.controller;


import com.mixcus.pojo.Article;
import com.mixcus.service.ArticleService;
import com.mixcus.utils.PageResult;
import com.mixcus.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/editArticle")
    public Result editArticle(@RequestBody Article article){
        return articleService.editArticle(article);
    }

    @PostMapping("/deleteArticleById")
    public Result deleteArticle(@RequestParam("articleId") int id){
        return articleService.deleteArticleById(id);
    }

}

