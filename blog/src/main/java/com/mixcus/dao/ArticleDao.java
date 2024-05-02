package com.mixcus.dao;

import com.mixcus.pojo.Article;
import com.mixcus.entity.Pagination;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ArticleDao {
    List<Article> getArticleList();

    void editArticle(@Param("article") Article article);

    void deleteArticleById(@Param("id") int id);

    void addArticle(@Param("article") Article article);

    List<Article> queryArticle(@Param("pagination") Pagination pagination);
}

