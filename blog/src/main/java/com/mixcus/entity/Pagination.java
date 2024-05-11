package com.mixcus.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pagination implements Serializable {

    private String queryString;//查询条件

    private Integer pageSize;//页面大小

    private Integer currentPage;//当前页
}

