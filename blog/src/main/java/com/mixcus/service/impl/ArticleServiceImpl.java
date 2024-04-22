package com.mixcus.service.impl;

import com.mixcus.dao.ArticleDao;
import com.mixcus.pojo.Article;
import com.mixcus.service.ArticleService;
import com.mixcus.utils.PageResult;
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
}

