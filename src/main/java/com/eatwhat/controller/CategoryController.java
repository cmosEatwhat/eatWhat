package com.eatwhat.controller;


import com.eatwhat.entity.Conment;
import com.eatwhat.entity.comment.ServerResponse;
import com.eatwhat.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;


@Controller
@RequestMapping("/category")
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    /**
     * @des 根据id查询
     * @param shopId
     */
    @ResponseBody
    @RequestMapping(value = "/listCategoryByShopId/{shopId}",method = RequestMethod.GET)
    public ServerResponse listCategoryByShopId(@PathVariable String shopId)  {
        return new ServerResponse<Conment>().createBySuccess(categoryService.findAllById(shopId));
    }
}
