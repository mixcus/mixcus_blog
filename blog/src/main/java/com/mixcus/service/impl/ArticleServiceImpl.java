package com.mixcus.service.impl;

import com.mixcus.dao.ArticleDao;
import com.mixcus.exception.CustomException;
import com.mixcus.exception.ErrorCode;
import com.mixcus.pojo.Article;
import com.mixcus.service.ArticleService;
import com.mixcus.utils.PageResult;
import com.mixcus.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    //返回文章列表
    @Override
    public PageResult getArticleList() {

        List<Article> res = articleDao.getArticleList();

        return new PageResult(res.size(),res);
    }

    //编辑文章

    @Override
    public Result editArticle(Article article) {

        try{

            articleDao.editArticle(article);

            return new Result(true,"编辑成功",null);

        }catch (Exception e){

            e.printStackTrace();
            return new Result(false,"编辑失败",null);
        }
    }

    @Override
    public Result deleteArticleById(int id) {

        try {

            articleDao.deleteArticleById(id);

            return new Result(true,"删除成功",null);

        }catch (Exception e){

            return new Result(false,"删除失败",null);
        }
    }
}

