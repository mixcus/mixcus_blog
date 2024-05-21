package com.mixcus.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Repository
public class ArticleDto implements Serializable {

    private String title;

    private String content;

    private String tag;

    private String category;

    private String userId;
}

