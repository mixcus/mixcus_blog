package com.mixcus.service;

import com.mixcus.pojo.Article;
import com.mixcus.utils.PageResult;
import com.mixcus.utils.Pagination;
import com.mixcus.utils.Result;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleService {
    PageResult getArticleList();

    Result editArticle(Article article);

    Result deleteArticleById(int id);

    PageResult queryArticle(Pagination pagination);
}
