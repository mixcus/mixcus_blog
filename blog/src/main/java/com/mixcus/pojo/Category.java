package com.mixcus.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Repository
public class Category {

    private Integer categoryId;


    private Integer categoryFId;


    private String categoryDescription;

    private String categoryName;

}
