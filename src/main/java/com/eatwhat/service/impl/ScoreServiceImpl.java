package com.eatwhat.service.impl;

import com.alibaba.fastjson.JSON;
import com.eatwhat.entity.enums.ErrorCode;
import com.eatwhat.entity.exception.MyException;
import com.eatwhat.entity.utils.PageInfo;
import com.eatwhat.entity.utils.PageRequestParams;
import com.eatwhat.dao.ScoreMapper;
import com.eatwhat.entity.Score;
import com.eatwhat.service.ScoreService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 描述： 服务实现层
 *
 * @author xin_anzhang
 * @date 2018/08/13
 */
@Service
public class ScoreServiceImpl implements ScoreService {

    @Resource
    private ScoreMapper scoreMapper;

    private static final Logger log = LoggerFactory.getLogger(ScoreService.class);

    /**
     * @des 添加 Score
     * @param score
     */
    @Override
    @Transactional
    public Score saveScore(Score score){
        log.info("添加score -> score={}",JSON.toJSONString(score));
        score.setCreateTime(System.currentTimeMillis());
        int saveResult = scoreMapper.saveScore(score);
        if (saveResult < 1) {
            throw new MyException(ErrorCode.SAVE_FAIL);
        }
        return findById(String.valueOf(score.getId()));
    }

    /**
     * @des 修改 Score
     * @param score
     */
    @Override
    @Transactional
    public Score updateScore(Score score){
        log.info("修改score-> score={}",JSON.toJSONString(score));
        if(null == score.getId()){
            throw new MyException(ErrorCode.UPDATE_FAIL);
        }
        int updateResult = scoreMapper.updateScore(score);
        if (updateResult < 1) {
            throw new MyException(ErrorCode.UPDATE_FAIL);
        }
        return findById(String.valueOf(score.getId()));
    }

    /**
     * @des 根据主键删除信息
     * @param recordId
     */
    @Override
    @Transactional
    public int deleteById(String recordId){
        log.info("删除score -> recordId={}",recordId);
        if(StringUtils.isEmpty(recordId)){
            throw new MyException(ErrorCode.DELETE_FAIL);
        }
        int delResult = scoreMapper.deleteById(recordId);
        if (delResult < 1) {
            throw new MyException(ErrorCode.DELETE_FAIL);
        }
        return delResult;
    }

    /**
     * @des 根据主键集合删除信息
     * @param idArr
     */
    @Override
    @Transactional
    public int deleteByIdArr(Long[] idArr){
        log.info("批量删除score -> idArr={}",JSON.toJSONString(idArr));
        if(null == idArr || 0 == idArr.length){
            throw new MyException(ErrorCode.REQUEST_ERROR);
        }
        return scoreMapper.deleteByIdArr(idArr);
    }

    /**
     * @des 根据id 查询信息
     * @param recordId
     */
    @Override
    @Transactional
    public Score findById(String recordId){
        log.info("根据主键查询score -> recordId={}",recordId);
        return StringUtils.isEmpty(recordId ) ? null : scoreMapper.findById(recordId) ;
    }

    /**
     * @des 根据id 集合查询信息
     * @param idArr id集合
     */
    @Override
    @Transactional(readOnly = true)
    public List<Score> findByIdArr(Long[] idArr){
        log.info("根据主键集合查询score -> idArr={}",JSON.toJSONString(idArr));
        return scoreMapper.findByIdArr(idArr);
    }



    /**
     * @des 根据条件统计信息
     * @param score
     */
    @Override
    @Transactional(readOnly = true)
    public int count(Score score) {
        log.info("根据条件计数 -> score={}", JSON.toJSONString(score));
        return scoreMapper.count(score);
    }

}