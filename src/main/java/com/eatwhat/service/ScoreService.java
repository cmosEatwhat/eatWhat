package com.eatwhat.service;

import com.eatwhat.entity.Score;
import com.eatwhat.entity.comment.PageModel;

import java.util.List;

/**
* 描述： 服务实现层接口
* @author xin_anzhang
* @date 2018/08/13
*/
public interface ScoreService {
    /**
     * @des 评分获取菜品
     * @param shopId
     */
    List<Long> getFoodIdsByShopId (String shopId, PageModel pageModel);

    /**
    * @des 添加Score
    * @param score
    */
    Score saveScore(Score score);

    /**
    * @des 根据id删除
    * @param recordId
    */
    int deleteById(String recordId);

    /**
    * @des 根据id集合删除
    * @param idArr
    */
    int deleteByIdArr(Long[] idArr);

    /**
    * @des 修改Score
    * @param score
    */
    Score updateScore(Score score);

    /**
    * @des 根据Id获取
    * @param recordId
    */
    Score findById(String recordId);

    /**
    * @des 根据id 集合查询信息
    * @param idArr
    */
    List<Score> findByIdArr(Long[] idArr);


    /**
    * @des 根据条件计数
    * @param score
    */
    int count(Score score);

}