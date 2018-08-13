package com.eatwhat.controller;

import com.eatwhat.entity.Score;
import com.eatwhat.entity.comment.ServerResponse;
import com.eatwhat.service.ScoreService;
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
@RequestMapping("/score")
public class ScoreController {

    @Resource
    private ScoreService scoreService;

    /**
     * @param score
     * @des 创建
     */
    @RequestMapping("/save")
    @ResponseBody
    public ServerResponse save(@RequestBody Score score) {
        return new ServerResponse<Score>().createBySuccess(scoreService.saveScore(score));
    }

    /**
     * @des 根据id删除
     * @param recordId id
     */
    @RequestMapping(value = "/del")
    @ResponseBody
    public ServerResponse deleteById(@RequestParam("recordId") String recordId) {
        return new ServerResponse<Integer>().createBySuccess(scoreService.deleteById(recordId));
    }

    /**
     * @des 根据id集合删除
     * @param recordIdArr id
     */
    @RequestMapping(value = "/del/list")
    @ResponseBody
    public ServerResponse deleteById(@RequestParam("recordIdArr") Long[] recordIdArr) {
        return new ServerResponse<Integer>().createBySuccess(scoreService.deleteByIdArr(recordIdArr));
    }

    /**
     * @des 修改
     * @param score
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public ServerResponse updateScore(@RequestBody Score score) {
        return new ServerResponse<Score>().createBySuccess(scoreService.updateScore(score));
    }

    /**
     * @des 根据id查询
     * @param recordId
     */
    @RequestMapping(value = "/find")
    @ResponseBody
    public ServerResponse findScoreById(@RequestParam("recordId") String recordId)  {
        return new ServerResponse<Score>().createBySuccess(scoreService.findById(recordId));
    }

    /**
     * @des 根据id集合查询
     * @param recordIdArr
     */
    @RequestMapping(value = "/find/list")
    @ResponseBody
    public ServerResponse findScoreByIdList(@RequestParam("recordIdArr") Long[] recordIdArr)  {
        return new ServerResponse<List<Score>>().createBySuccess(scoreService.findByIdArr(recordIdArr));
    }

}