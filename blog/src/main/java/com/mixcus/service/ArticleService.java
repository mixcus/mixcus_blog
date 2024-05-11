package com.mixcus.service;

import com.mixcus.pojo.Article;
import com.mixcus.entity.PageResult;
import com.mixcus.entity.Pagination;
import com.mixcus.entity.Result;

public interface ArticleService {
    PageResult getArticleList();

    Result editArticle(Article article);

    Result deleteArticleById(int id);

    PageResult queryArticle(Pagination pagination);

}
