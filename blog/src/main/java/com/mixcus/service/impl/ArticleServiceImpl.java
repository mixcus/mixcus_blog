package com.mixcus.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mixcus.dao.ArticleDao;
import com.mixcus.pojo.Article;
import com.mixcus.service.ArticleService;
import com.mixcus.entity.PageResult;
import com.mixcus.entity.Pagination;
import com.mixcus.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    //返回文章列表
    @Override
    public PageResult getArticleList() {

        List<Article> res = articleDao.getArticleList();

        return new PageResult((long)res.size(),res);
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

    @Override
    public PageResult queryArticle(Pagination pagination) {

        Map<String,Object> map = new HashMap<>();

        //查询条件
        map.put("queryString",pagination.getQueryString());

        PageHelper.startPage(pagination.getCurrentPage(),pagination.getPageSize());
        //页面起始行
        Page<Article> page = articleDao.queryArticle(map);

        return new PageResult(page.getTotal(),page.getResult());
    }

}

