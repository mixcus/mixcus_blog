package com.mixcus.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Repository
public class ArticleCategory {
    private Integer articleId;

    private Integer categoryId;
}
