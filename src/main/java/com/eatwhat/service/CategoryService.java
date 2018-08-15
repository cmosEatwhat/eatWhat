package com.eatwhat.service;

import com.eatwhat.entity.Category;

import java.util.List;

public interface CategoryService {
    /**
     * @des 根据id 集合查询信息
     * @param recordId
     */
    List<Category> findAllById(String recordId);
}
