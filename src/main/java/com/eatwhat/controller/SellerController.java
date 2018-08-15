package com.eatwhat.controller;

import com.eatwhat.entity.Seller;
import com.eatwhat.entity.comment.ServerResponse;
import com.eatwhat.service.SellerService;
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
@RequestMapping("/seller")
public class SellerController {

    @Resource
    private SellerService sellerService;

    /**
     * @param seller
     * @des 注册商家
     */
    @RequestMapping(value = "/save",method = RequestMethod.PUT)
    @ResponseBody
    public ServerResponse save(@RequestBody Seller seller) {
        return new ServerResponse<Seller>().createBySuccess(sellerService.saveSeller(seller));
    }

    /**
     * @des 根据id删除
     * @param recordId id
     */
    @RequestMapping(value = "/del",method = RequestMethod.DELETE)
    @ResponseBody
    public ServerResponse deleteById(@RequestParam("recordId") String recordId) {
        return new ServerResponse<Integer>().createBySuccess(sellerService.deleteById(recordId));
    }



    /**
     * @des 修改
     * @param seller
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse updateSeller(@RequestBody Seller seller) {
        return new ServerResponse<Seller>().createBySuccess(sellerService.updateSeller(seller));
    }

    /**
     * @des 根据id查询
     * @param recordId
     */
    @RequestMapping(value = "/find",method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse findSellerById(@RequestParam("recordId") String recordId)  {
        return new ServerResponse<Seller>().createBySuccess(sellerService.findById(recordId));
    }


}