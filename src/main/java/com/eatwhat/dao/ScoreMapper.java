package com.eatwhat.dao;

import com.eatwhat.entity.Score;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
* 描述：
* @author xin_anzhang
* @date 2018/08/13
*/
@Component
public interface ScoreMapper {

    /**
    * @des 添加Score
    * @param score
    */
    int saveScore(Score score);

    /**
    * @des 根据id删除
    * @param recordId
    */
    int deleteById(@Param("recordId") String recordId);

    /**
    * @des 根据id集合删除
    * @param idArr
    */
    int deleteByIdArr(@Param("idArr") Long[] idArr);

    /**
    * @des 修改Score
    * @param score
    */
    int updateScore(Score score);

    /**
    * @des 根据Id获取
    * @param recordId
    */
    Score findById(String recordId);

    /**
    * @des 根据id 集合查询信息
    * @param idArr
    */
    List<Score> findByIdArr(@Param("idArr") Long[] idArr);


    /**
    * @des 根据条件计数
    * @param pageRequest
    */
    int count(Score score);

}