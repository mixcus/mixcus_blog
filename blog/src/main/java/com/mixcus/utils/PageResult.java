package com.mixcus.utils;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PageResult implements Serializable {
    //总记录数
    private Integer totals;
    //数据集合
    private List list;

}

