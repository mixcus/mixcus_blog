package com.mixcus.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Repository
public class Comment {

    private Integer commentId;

    private java.sql.Timestamp commentDate;

    private Integer userId;

    private String commentContent;

    private Integer articleId;

    private Integer CommentFId;

    private Integer likeCount;

}
