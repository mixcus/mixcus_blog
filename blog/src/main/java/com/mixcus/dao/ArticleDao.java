package com.mixcus.dao;

import com.mixcus.pojo.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleDao {
    List<Article> getArticleList();
}

