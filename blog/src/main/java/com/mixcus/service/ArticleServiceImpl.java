package com.mixcus.service;

import com.mixcus.dao.ArticleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    private ArticleDao articleDao;

    //返回文章列表
    @Override
    public List getArticleList() {
        return articleDao.getArticleList();
    }
}

