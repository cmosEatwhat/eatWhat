package com.eatwhat.controller;

import com.eatwhat.entity.Conment;
import com.eatwhat.entity.comment.PageModel;
import com.eatwhat.entity.comment.ServerResponse;
import com.eatwhat.service.ConmentService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

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
     * @param foodId
     * @des 查商品评论
     */
    @ApiOperation("查商品评论")
    @RequestMapping(value = "/byFood",method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<PageInfo<Conment>> findConmentByid(String foodId,@Valid PageModel pageModel) {

        PageInfo<Conment> conmentPageInfo =  conmentService.getConmentListByfoodId(foodId,pageModel);

        return ServerResponse.createBySuccess(conmentPageInfo);
    }



    /**
     * @param conment
     * @des 创建
     */

    @ApiOperation("添加商品评论")
    @ResponseBody
    @RequestMapping(value = "/save",method = RequestMethod.GET)
    public ServerResponse save(Conment conment) {
        return new ServerResponse<Conment>().createBySuccess(conmentService.saveConment(conment));
    }




    /**
     * @des 根据id查询
     * @param id
     */
    @ApiOperation("查单个评论")
    @RequestMapping(value = "/find/{id}",method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse findConmentById( @PathVariable String id)  {
        return new ServerResponse<Conment>().createBySuccess(conmentService.findById(id));
    }


}