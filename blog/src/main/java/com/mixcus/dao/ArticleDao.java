package com.mixcus.dao;

import com.github.pagehelper.Page;
import com.mixcus.dto.ArticleDto;
import com.mixcus.pojo.Article;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ArticleDao {
    List<Article> getArticleList();

    void editArticle(@Param("article") Article article);

    void deleteArticleById(@Param("id") int id);

    void addArticle(@Param("articleDto")ArticleDto articleDto);

    Page<Article> queryArticle(@Param("map") Map<String,Object> map);
}

