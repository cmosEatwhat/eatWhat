package com.eatwhat.service.impl;

import com.alibaba.druid.support.json.JSONUtils;
import com.eatwhat.dao.SellerMapper;
import com.eatwhat.entity.Seller;
import com.eatwhat.entity.comment.ErrorCode;
import com.eatwhat.entity.comment.ServerResponse;
import com.eatwhat.service.SellerService;
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
public class SellerServiceImpl implements SellerService {

    @Resource
    private SellerMapper sellerMapper;

    private static final Logger log = LoggerFactory.getLogger(SellerService.class);

    /**
     * @des 添加 Seller
     * @param seller
     */
    @Override
    @Transactional
    public Seller saveSeller(Seller seller){
        log.info("添加seller -> seller={}",JSONUtils.toJSONString(seller));
        int saveResult = sellerMapper.saveSeller(seller);
        if (saveResult < 1) {
            ServerResponse.createDefaultErrorMessage(ErrorCode.SAVE_FAIL);
        }
        return findById(String.valueOf(seller.getId()));
    }

    /**
     * @des 修改 Seller
     * @param seller
     */
    @Override
    @Transactional
    public Seller updateSeller(Seller seller){
        log.info("修改seller-> seller={}",JSONUtils.toJSONString(seller));
        if(null == seller.getId()){
            ServerResponse.createDefaultErrorMessage(ErrorCode.UPDATE_FAIL);
        }
        int updateResult = sellerMapper.updateSeller(seller);
        if (updateResult < 1) {
            ServerResponse.createDefaultErrorMessage(ErrorCode.UPDATE_FAIL);
        }
        return findById(String.valueOf(seller.getId()));
    }

    /**
     * @des 根据主键删除信息
     * @param recordId
     */
    @Override
    @Transactional
    public int deleteById(String recordId){
        log.info("删除seller -> recordId={}",recordId);
        if(StringUtils.isEmpty(recordId)){
            ServerResponse.createDefaultErrorMessage(ErrorCode.DELETE_FAIL);
        }
        int delResult = sellerMapper.deleteById(recordId);
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
        log.info("批量删除seller -> idArr={}",JSONUtils.toJSONString(idArr));
        if(null == idArr || 0 == idArr.length){
            ServerResponse.createDefaultErrorMessage(ErrorCode.REQUEST_PARAMS_ERROR);
        }
        return sellerMapper.deleteByIdArr(idArr);
    }

    /**
     * @des 根据id 查询信息
     * @param recordId
     */
    @Override
    @Transactional
    public Seller findById(String recordId){
        log.info("根据主键查询seller -> recordId={}",recordId);
        return StringUtils.isEmpty(recordId ) ? null : sellerMapper.findById(recordId) ;
    }

    /**
     * @des 根据id 集合查询信息
     * @param idArr id集合
     */
    @Override
    @Transactional(readOnly = true)
    public List<Seller> findByIdArr(Long[] idArr){
        log.info("根据主键集合查询seller -> idArr={}",JSONUtils.toJSONString(idArr));
        return sellerMapper.findByIdArr(idArr);
    }

   
    /**
     * @des 根据条件统计信息
     * @param seller
     */
    @Override
    @Transactional(readOnly = true)
    public int count(Seller seller) {
        log.info("根据条件计数 -> seller={}", JSONUtils.toJSONString(seller));
        return sellerMapper.count(seller);
    }

}