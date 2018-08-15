package com.eatwhat.controller;

import com.eatwhat.entity.Shops;
import com.eatwhat.entity.comment.ServerResponse;
import com.eatwhat.service.ShopsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 描述：控制层
 * @author xin_anzhang
 * @email xin_anzhang
 * @date 2018/08/13
 */
@Controller
@RequestMapping("/shops")
public class ShopsController {

    @Resource
    private ShopsService shopsService;

    /**
     * @param shops
     * @des 注册店铺
     */
    @RequestMapping(value = "/save",method = RequestMethod.PUT)
    @ResponseBody
    public ServerResponse save(@RequestBody Shops shops) {
        return new ServerResponse<Shops>().createBySuccess(shopsService.saveShops(shops));
    }

    /**
     * @des 根据id删除
     * @param recordId id
     */
    @RequestMapping(value = "/del",method = RequestMethod.DELETE)
    @ResponseBody
    public ServerResponse deleteById(@RequestParam("recordId") String recordId) {
        return new ServerResponse<Integer>().createBySuccess(shopsService.deleteById(recordId));
    }


    /**
     * @des 根据id查询
     * @param recordId
     */
    @RequestMapping(value = "/find",method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse findShopsById(@RequestParam("recordId") String recordId)  {
        return new ServerResponse<Shops>().createBySuccess(shopsService.findById(recordId));
    }




}