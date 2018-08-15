package com.eatwhat.service.impl;

import com.eatwhat.dao.CategoryMapper;
import com.eatwhat.entity.Category;
import com.eatwhat.service.CategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> findAllById(String recordId) {
        return categoryMapper.findAllById(recordId);
    }
}
