package com.eatwhat.controller;

import com.eatwhat.entity.Foods;
import com.eatwhat.entity.comment.ServerResponse;
import com.eatwhat.service.FoodsService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 描述：控制层
 * @author xin_anzhang
 * @email xin_anzhang
 * @date 2018/08/13
 */
@Controller
@Api(tags = "食品模块")
@RequestMapping("/foods")
public class FoodsController {

    @Resource
    private FoodsService foodsService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());



    /**
     * @des 查询所有
     *
     */

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse findFoodsList()  {
        logger.info("enter method findFoodsList :");
        return new ServerResponse<Foods>().createBySuccess("zxa");
    }

    /**
     * @param foods
     * @des 创建
     */
    @RequestMapping(value = "/save",method = RequestMethod.PUT)
    @ResponseBody
    public ServerResponse<Foods> save(@RequestBody Foods foods) {
        return new ServerResponse<Foods>().createBySuccess(foodsService.saveFoods(foods));
    }

    /**
     * @des 根据id删除
     * @param recordId id
     */
    @RequestMapping(value = "/del",method = RequestMethod.DELETE)
    @ResponseBody
    public ServerResponse deleteById(@RequestParam("recordId") String recordId) {
        return new ServerResponse<Integer>().createBySuccess(foodsService.deleteById(recordId));
    }

    /**
     * @des 根据id集合删除
     * @param recordIdArr id
     */
    @RequestMapping(value = "/del/list",method = RequestMethod.DELETE)
    @ResponseBody
    public ServerResponse deleteById(@RequestParam("recordIdArr") Long[] recordIdArr) {
        return new ServerResponse<Integer>().createBySuccess(foodsService.deleteByIdArr(recordIdArr));
    }

    /**
     * @des 修改
     * @param foods
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse updateFoods(@RequestBody Foods foods) {
        return new ServerResponse<Foods>().createBySuccess(foodsService.updateFoods(foods));
    }

    /**
     * @des 根据id查询
     * @param recordId
     */
    @RequestMapping(value = "/find",method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse findFoodsById(@RequestParam("recordId") String recordId)  {
        return new ServerResponse<Foods>().createBySuccess(foodsService.findById(recordId));
    }

    /**
     * @des 根据id集合查询
     * @param recordIdArr
     */
    @RequestMapping(value = "/find/list",method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse findFoodsByIdList(@RequestParam("recordIdArr") Long[] recordIdArr)  {
        return new ServerResponse<List<Foods>>().createBySuccess(foodsService.findByIdArr(recordIdArr));
    }

}