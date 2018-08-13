package com.eatwhat.controller;

import com.eatwhat.entity.Conment;
import com.eatwhat.entity.comment.ServerResponse;
import com.eatwhat.service.ConmentService;
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
@RequestMapping("/conment")
public class ConmentController {




    @Resource
    private ConmentService conmentService;

    /**
     * @param conment
     * @des 创建
     */
    @RequestMapping(value = "/save")
    @ResponseBody
    public ServerResponse save(@RequestBody Conment conment) {
        return new ServerResponse<Conment>().createBySuccess(conmentService.saveConment(conment));
    }

    /**
     * @des 根据id删除
     * @param recordId id
     */
    @RequestMapping(value = "/del")
    @ResponseBody
    public ServerResponse deleteById(@RequestParam("recordId") String recordId) {
        return new ServerResponse<Integer>().createBySuccess(conmentService.deleteById(recordId));
    }

    /**
     * @des 根据id集合删除
     * @param recordIdArr id
     */
    @RequestMapping(value = "/del/list")
    @ResponseBody
    public ServerResponse deleteById(@RequestParam("recordIdArr") Long[] recordIdArr) {
        return new ServerResponse<Integer>().createBySuccess(conmentService.deleteByIdArr(recordIdArr));
    }

    /**
     * @des 修改
     * @param conment
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public ServerResponse updateConment(@RequestBody Conment conment) {
        return new ServerResponse<Conment>().createBySuccess(conmentService.updateConment(conment));
    }

    /**
     * @des 根据id查询
     * @param recordId
     */
    @RequestMapping(value = "/find")
    @ResponseBody
    public ServerResponse findConmentById(@RequestParam("recordId") String recordId)  {
        return new ServerResponse<Conment>().createBySuccess(conmentService.findById(recordId));
    }

    /**
     * @des 根据id集合查询
     * @param recordIdArr
     */
    @RequestMapping(value = "/find/list")
    @ResponseBody
    public ServerResponse findConmentByIdList(@RequestParam("recordIdArr") Long[] recordIdArr)  {
        return new ServerResponse<List<Conment>>().createBySuccess(conmentService.findByIdArr(recordIdArr));
    }


}