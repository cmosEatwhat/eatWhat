package com.eatwhat.controller;

import com.eatwhat.entity.Foods;
import com.eatwhat.entity.comment.PageModel;
import com.eatwhat.entity.comment.ServerResponse;
import com.eatwhat.entity.food.FoodsVo;
import com.eatwhat.service.FoodsService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * 描述：控制层
 *
 * @author xin_anzhang
 * @email xin_anzhang
 * @date 2018/08/13
 */
@Controller
@RequestMapping("/foods")
public class FoodsController {

    @Resource
    private FoodsService foodsService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * @des 查询所有
     */

    @ApiOperation(value = "查店铺（分类）所有菜品")
    @RequestMapping(value = "/listByShopIdAndCategoryId", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<List<FoodsVo>> findAllByShopsIdAndCategoryId( String shopId, String categoryId) {

        List<FoodsVo> foodsVoList = foodsService.findAllByShopsIdAndCategoryId(shopId,categoryId,new PageModel());

        return ServerResponse.createBySuccess(foodsVoList);
    }

    /**
     * @des 查询所有
     */

    @ApiOperation(value = "查店铺所有菜品")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<PageInfo<FoodsVo>> findFoodsList(String shopsId, @Valid PageModel pageModel) {

        logger.info("enter method findFoodsList :");

        PageInfo<FoodsVo> foodsList = foodsService.findByShopsId(shopsId, pageModel);


        return new ServerResponse<Foods>().createBySuccess(foodsList);
    }

    /**
     * @param foods
     * @des 创建
     */
    @RequestMapping(value = "/save", method = RequestMethod.PUT)
    @ResponseBody
    public ServerResponse<Foods> save(@RequestBody Foods foods) {
        return new ServerResponse<Foods>().createBySuccess(foodsService.saveFoods(foods));
    }

    /**
     * @param recordId id
     * @des 根据id删除
     */
    @RequestMapping(value = "/del", method = RequestMethod.DELETE)
    @ResponseBody
    public ServerResponse deleteById(@RequestParam("recordId") String recordId) {
        return new ServerResponse<Integer>().createBySuccess(foodsService.deleteById(recordId));
    }


    /**
     * @param id
     * @des 根据id查询
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse findFoodsById(@PathVariable String id) {
        return new ServerResponse<Foods>().createBySuccess(foodsService.findById(id));
    }


}