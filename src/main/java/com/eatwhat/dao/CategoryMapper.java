package com.eatwhat.dao;


import com.eatwhat.entity.Category;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CategoryMapper {

    /**
     * @des 根据店铺id 集合查询信息
     * @param recordId
     */
    List<Category> findAllById(String recordId);
}
