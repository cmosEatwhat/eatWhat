package com.eatwhat.controller;

import com.eatwhat.entity.Shops;
import com.eatwhat.entity.comment.ServerResponse;
import com.eatwhat.service.ShopsService;
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
@RequestMapping("/shops")
public class ShopsController {

    @Resource
    private ShopsService shopsService;

    /**
     * @param shops
     * @des 注册店铺
     */
    @RequestMapping("/save")
    @ResponseBody
    public ServerResponse save(@RequestBody Shops shops) {
        return new ServerResponse<Shops>().createBySuccess(shopsService.saveShops(shops));
    }

    /**
     * @des 根据id删除
     * @param recordId id
     */
    @RequestMapping(value = "/del")
    @ResponseBody
    public ServerResponse deleteById(@RequestParam("recordId") String recordId) {
        return new ServerResponse<Integer>().createBySuccess(shopsService.deleteById(recordId));
    }

    /**
     * @des 根据id集合删除
     * @param recordIdArr id
     */
    @RequestMapping(value = "/del/list")
    @ResponseBody
    public ServerResponse deleteById(@RequestParam("recordIdArr") Long[] recordIdArr) {
        return new ServerResponse<Integer>().createBySuccess(shopsService.deleteByIdArr(recordIdArr));
    }

    /**
     * @des 修改
     * @param shops
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public ServerResponse updateShops(@RequestBody Shops shops) {
        return new ServerResponse<Shops>().createBySuccess(shopsService.updateShops(shops));
    }

    /**
     * @des 根据id查询
     * @param recordId
     */
    @RequestMapping(value = "/find")
    @ResponseBody
    public ServerResponse findShopsById(@RequestParam("recordId") String recordId)  {
        return new ServerResponse<Shops>().createBySuccess(shopsService.findById(recordId));
    }

    /**
     * @des 根据id集合查询
     * @param recordIdArr
     */
    @RequestMapping(value = "/find/list")
    @ResponseBody
    public ServerResponse findShopsByIdList(@RequestParam("recordIdArr") Long[] recordIdArr)  {
        return new ServerResponse<List<Shops>>().createBySuccess(shopsService.findByIdArr(recordIdArr));
    }


}