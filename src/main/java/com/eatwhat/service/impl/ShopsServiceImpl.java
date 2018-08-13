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
import java.util.List;

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
//        shops.setCreateTime(System.currentTimeMillis());
        int saveResult = shopsMapper.saveShops(shops);
        if (saveResult < 1) {
            ServerResponse.createDefaultErrorMessage(ErrorCode.SAVE_FAIL);
        }
        return findById(String.valueOf(shops.getId()));
    }

    /**
     * @des 修改 Shops
     * @param shops
     */
    @Override
    @Transactional
    public Shops updateShops(Shops shops){
        log.info("修改shops-> shops={}",JSONUtils.toJSONString(shops));
        if(null == shops.getId()){
            ServerResponse.createDefaultErrorMessage(ErrorCode.UPDATE_FAIL);
        }
        int updateResult = shopsMapper.updateShops(shops);
        if (updateResult < 1) {
            ServerResponse.createDefaultErrorMessage(ErrorCode.UPDATE_FAIL);
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
     * @des 根据主键集合删除信息
     * @param idArr
     */
    @Override
    @Transactional
    public int deleteByIdArr(Long[] idArr){
        log.info("批量删除shops -> idArr={}",JSONUtils.toJSONString(idArr));
        if(null == idArr || 0 == idArr.length){
            ServerResponse.createDefaultErrorMessage(ErrorCode.REQUEST_PARAMS_ERROR);
        }
        return shopsMapper.deleteByIdArr(idArr);
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

    /**
     * @des 根据id 集合查询信息
     * @param idArr id集合
     */
    @Override
    @Transactional(readOnly = true)
    public List<Shops> findByIdArr(Long[] idArr){
        log.info("根据主键集合查询shops -> idArr={}",JSONUtils.toJSONString(idArr));
        return shopsMapper.findByIdArr(idArr);
    }

    

    /**
     * @des 根据条件统计信息
     * @param shops
     */
    @Override
    @Transactional(readOnly = true)
    public int count(Shops shops) {
        log.info("根据条件计数 -> shops={}", JSONUtils.toJSONString(shops));
        return shopsMapper.count(shops);
    }

}