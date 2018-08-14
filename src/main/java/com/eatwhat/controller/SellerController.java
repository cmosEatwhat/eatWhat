package com.eatwhat.controller;

import com.eatwhat.entity.Seller;
import com.eatwhat.entity.comment.ServerResponse;
import com.eatwhat.service.SellerService;
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
@RequestMapping("/seller")
public class SellerController {

    @Resource
    private SellerService sellerService;

    /**
     * @param seller
     * @des 注册商家
     */
    @RequestMapping("/save")
    @ResponseBody
    public ServerResponse save(@RequestBody Seller seller) {
        return new ServerResponse<Seller>().createBySuccess(sellerService.saveSeller(seller));
    }

    /**
     * @des 根据id删除
     * @param recordId id
     */
    @RequestMapping(value = "/del")
    @ResponseBody
    public ServerResponse deleteById(@RequestParam("recordId") String recordId) {
        return new ServerResponse<Integer>().createBySuccess(sellerService.deleteById(recordId));
    }

    /**
     * @des 根据id集合删除
     * @param recordIdArr id
     */
    @RequestMapping(value = "/del/list")
    @ResponseBody
    public ServerResponse deleteById(@RequestParam("recordIdArr") Long[] recordIdArr) {
        return new ServerResponse<Integer>().createBySuccess(sellerService.deleteByIdArr(recordIdArr));
    }

    /**
     * @des 修改
     * @param seller
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public ServerResponse updateSeller(@RequestBody Seller seller) {
        return new ServerResponse<Seller>().createBySuccess(sellerService.updateSeller(seller));
    }

    /**
     * @des 根据id查询
     * @param recordId
     */
    @RequestMapping(value = "/find")
    @ResponseBody
    public ServerResponse findSellerById(@RequestParam("recordId") String recordId)  {
        return new ServerResponse<Seller>().createBySuccess(sellerService.findById(recordId));
    }

    /**
     * @des 根据id集合查询
     * @param recordIdArr
     */
    @RequestMapping(value = "/find/list")
    @ResponseBody
    public ServerResponse findSellerByIdList(@RequestParam("recordIdArr") Long[] recordIdArr) {
        return new ServerResponse<List<Seller>>().createBySuccess(sellerService.findByIdArr(recordIdArr));
    }
}