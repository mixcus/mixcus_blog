package com.mixcus.service.impl;

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

    @Override
    public PageResult queryArticle(Pagination pagination) {

        Map<String,Object> map = new HashMap<>();

        int pageSize = pagination.getPageSize();

        int currentPage = (pagination.getCurrentPage()-1)*pageSize;
        //查询条件
        map.put("queryString",pagination.getQueryString());
        System.out.println(map.get("queryString"));
        //页面起始行
        map.put("currentPage",currentPage);
        //页面大小
        map.put("pageSize",pageSize);

        List<Article> res = articleDao.queryArticle(map);

        System.out.println(res);

        return new PageResult(res.size(),res);
    }

}

