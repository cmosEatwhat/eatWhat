package com.eatwhat.controller;

import com.eatwhat.entity.Foods;
import com.eatwhat.entity.comment.ServerResponse;
import com.eatwhat.service.FoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * 描述：控制层
 * @author xin_anzhang
 * @email xin_anzhang
 * @date 2018/08/13
 */
@Controller
@RequestMapping("/foods")
public class FoodsController {

    @Resource
    private FoodsService foodsService;

    /**
     * @param foods
     * @des 创建
     */
    @RequestMapping("/save")
    @ResponseBody
    public ServerResponse<Foods> save(@RequestBody Foods foods) {
        return new ServerResponse<Foods>().createBySuccess(foodsService.saveFoods(foods));
    }

    /**
     * @des 根据id删除
     * @param recordId id
     */
    @RequestMapping(value = "/del")
    @ResponseBody
    public ServerResponse deleteById(@RequestParam("recordId") String recordId) {
        return new ServerResponse<Integer>().createBySuccess(foodsService.deleteById(recordId));
    }

    /**
     * @des 根据id集合删除
     * @param recordIdArr id
     */
    @RequestMapping(value = "/del/list")
    @ResponseBody
    public ServerResponse deleteById(@RequestParam("recordIdArr") Long[] recordIdArr) {
        return new ServerResponse<Integer>().createBySuccess(foodsService.deleteByIdArr(recordIdArr));
    }

    /**
     * @des 修改
     * @param foods
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public ServerResponse updateFoods(@RequestBody Foods foods) {
        return new ServerResponse<Foods>().createBySuccess(foodsService.updateFoods(foods));
    }

    /**
     * @des 根据id查询
     * @param recordId
     */
    @RequestMapping(value = "/find")
    @ResponseBody
    public ServerResponse findFoodsById(@RequestParam("recordId") String recordId)  {
        return new ServerResponse<Foods>().createBySuccess(foodsService.findById(recordId));
    }

    /**
     * @des 根据id集合查询
     * @param recordIdArr
     */
    @RequestMapping(value = "/find/list")
    @ResponseBody
    public ServerResponse findFoodsByIdList(@RequestParam("recordIdArr") Long[] recordIdArr)  {
        return new ServerResponse<List<Foods>>().createBySuccess(foodsService.findByIdArr(recordIdArr));
    }

}