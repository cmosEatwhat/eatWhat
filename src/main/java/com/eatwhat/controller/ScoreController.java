package com.eatwhat.controller;

import com.eatwhat.entity.Score;
import com.eatwhat.entity.comment.PageModel;
import com.eatwhat.entity.comment.ServerResponse;
import com.eatwhat.service.ScoreService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 描述：控制层
 * @author xin_anzhang
 * @email xin_anzhang
 * @date 2018/08/13
 */
@Controller
@RequestMapping("/score")
public class ScoreController {

    @Resource
    private ScoreService scoreService;

    /**
     * @param score
     * @des 创建
     */
    @RequestMapping(value = "/save",method = RequestMethod.PUT)
    @ResponseBody
    public ServerResponse save(Score score) {
        return new ServerResponse<Score>().createBySuccess(scoreService.saveScore(score));
    }

    /**
     * @des 根据id查询
     * @param recordId
     */
    @RequestMapping(value = "/findBy",method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse findScoreById(@RequestParam("recordId") String recordId)  {
        return new ServerResponse<Score>().createBySuccess(scoreService.findById(recordId));
    }
    /**
     * @des 热度
     * @param pageModel
     */
    @RequestMapping(value = "/hot",method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse findScoreHot(PageModel pageModel)  {
        return new ServerResponse<Score>().createBySuccess(scoreService.getFoodIdsByShopId("1",pageModel));
    }






}