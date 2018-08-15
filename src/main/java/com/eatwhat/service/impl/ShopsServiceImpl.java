package com.eatwhat.service.impl;

import com.alibaba.druid.support.json.JSONUtils;
import com.eatwhat.dao.ShopsMapper;
import com.eatwhat.entity.Shops;
import com.eatwhat.entity.comment.ErrorCode;
import com.eatwhat.entity.comment.ServerResponse;
import com.eatwhat.service.ShopsService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 描述： 服务实现层
 *
 * @author xin_anzhang
 * @date 2018/08/13
 */
@Service
public class ShopsServiceImpl implements ShopsService {

    @Resource
    private ShopsMapper shopsMapper;

    private static final Logger log = LoggerFactory.getLogger(ShopsService.class);

    /**
     * @des 添加 Shops
     * @param shops
     */
    @Override
    @Transactional
    public Shops saveShops(Shops shops){
        log.info("添加shops -> shops={}",JSONUtils.toJSONString(shops));
        int saveResult = shopsMapper.saveShops(shops);
        if (saveResult < 1) {
            ServerResponse.createDefaultErrorMessage(ErrorCode.SAVE_FAIL);
        }
        return findById(String.valueOf(shops.getId()));
    }


    /**
     * @des 根据主键删除信息
     * @param recordId
     */
    @Override
    @Transactional
    public int deleteById(String recordId){
        log.info("删除shops -> recordId={}",recordId);
        if(StringUtils.isEmpty(recordId)){
            ServerResponse.createDefaultErrorMessage(ErrorCode.DELETE_FAIL);
        }
        int delResult = shopsMapper.deleteById(recordId);
        if (delResult < 1) {
            ServerResponse.createDefaultErrorMessage(ErrorCode.DELETE_FAIL);
        }
        return delResult;
    }


    /**
     * @des 根据id 查询信息
     * @param recordId
     */
    @Override
    @Transactional
    public Shops findById(String recordId){
        log.info("根据主键查询shops -> recordId={}",recordId);
        return StringUtils.isEmpty(recordId ) ? null : shopsMapper.findById(recordId) ;
    }



}