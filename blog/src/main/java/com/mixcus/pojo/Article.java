package com.mixcus.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Repository
public class Article {

    private Integer articleId;

    private String title;

    private String content;

    private Integer userId;

    private String tag;

    private String category;

    private Integer likeCount;

    private Integer viewCount;

    private Instant createTime;

    private Instant modifyTime;
}
