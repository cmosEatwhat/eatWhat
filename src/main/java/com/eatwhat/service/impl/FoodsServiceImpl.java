package com.eatwhat.service.impl;

import com.alibaba.druid.support.json.JSONUtils;
import com.eatwhat.dao.FoodsMapper;
import com.eatwhat.entity.Foods;
import com.eatwhat.entity.comment.ErrorCode;
import com.eatwhat.entity.comment.ServerResponse;
import com.eatwhat.service.FoodsService;
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
public class FoodsServiceImpl implements FoodsService {

    @Resource
    private FoodsMapper foodsMapper;

    private static final Logger log = LoggerFactory.getLogger(FoodsService.class);

    /**
     * @des 添加 Foods
     * @param foods
     */
    @Override
    @Transactional
    public Foods saveFoods(Foods foods){
        log.info("添加foods -> foods={}",JSONUtils.toJSONString(foods));
//        foods.setCreateTime(System.currentTimeMillis());
        int saveResult = foodsMapper.saveFoods(foods);
        if (saveResult < 1) {
            ServerResponse.createDefaultErrorMessage(ErrorCode.SAVE_FAIL);
        }
        return findById(String.valueOf(foods.getId()));
    }

    /**
     * @des 修改 Foods
     * @param foods
     */
    @Override
    @Transactional
    public Foods updateFoods(Foods foods){
        log.info("修改foods-> foods={}",JSONUtils.toJSONString(foods));
        if(null == foods.getId()){
            ServerResponse.createDefaultErrorMessage(ErrorCode.UPDATE_FAIL);
        }
        int updateResult = foodsMapper.updateFoods(foods);
        if (updateResult < 1) {
            ServerResponse.createDefaultErrorMessage(ErrorCode.UPDATE_FAIL);
        }
        return findById(String.valueOf(foods.getId()));
    }

    /**
     * @des 根据主键删除信息
     * @param recordId
     */
    @Override
    @Transactional
    public int deleteById(String recordId){
        log.info("删除foods -> recordId={}",recordId);
        if(StringUtils.isEmpty(recordId)){
            ServerResponse.createDefaultErrorMessage(ErrorCode.DELETE_FAIL);
        }
        int delResult = foodsMapper.deleteById(recordId);
        if (delResult < 1) {
            ServerResponse.createDefaultErrorMessage(ErrorCode.DELETE_FAIL);
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
        log.info("批量删除foods -> idArr={}",JSONUtils.toJSONString(idArr));
        if(null == idArr || 0 == idArr.length){
            ServerResponse.createDefaultErrorMessage(ErrorCode.REQUEST_PARAMS_ERROR);
        }
        return foodsMapper.deleteByIdArr(idArr);
    }

    /**
     * @des 根据id 查询信息
     * @param recordId
     */
    @Override
    @Transactional
    public Foods findById(String recordId){
        log.info("根据主键查询foods -> recordId={}",recordId);
        return StringUtils.isEmpty(recordId ) ? null : foodsMapper.findById(recordId) ;
    }

    /**
     * @des 根据id 集合查询信息
     * @param idArr id集合
     */
    @Override
    @Transactional(readOnly = true)
    public List<Foods> findByIdArr(Long[] idArr){
        log.info("根据主键集合查询foods -> idArr={}",JSONUtils.toJSONString(idArr));
        return foodsMapper.findByIdArr(idArr);
    }


    /**
     * @des 根据条件统计信息
     * @param foods
     */
    @Override
    @Transactional(readOnly = true)
    public int count(Foods foods) {
        log.info("根据条件计数 -> foods={}", JSONUtils.toJSONString(foods));
        return foodsMapper.count(foods);
    }

}