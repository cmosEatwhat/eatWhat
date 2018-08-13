package com.eatwhat.service.impl;

import com.alibaba.fastjson.JSON;
import com.eatwhat.entity.enums.ErrorCode;
import com.eatwhat.entity.exception.MyException;
import com.eatwhat.entity.utils.PageInfo;
import com.eatwhat.entity.utils.PageRequestParams;
import com.eatwhat.dao.ConmentMapper;
import com.eatwhat.entity.Conment;
import com.eatwhat.service.ConmentService;
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
public class ConmentServiceImpl implements ConmentService {

    @Resource
    private ConmentMapper conmentMapper;

    private static final Logger log = LoggerFactory.getLogger(ConmentService.class);

    /**
     * @des 添加 Conment
     * @param conment
     */
    @Override
    @Transactional
    public Conment saveConment(Conment conment){
        log.info("添加conment -> conment={}",JSON.toJSONString(conment));
        conment.setCreateTime(System.currentTimeMillis());
        int saveResult = conmentMapper.saveConment(conment);
        if (saveResult < 1) {
            throw new MyException(ErrorCode.SAVE_FAIL);
        }
        return findById(String.valueOf(conment.getId()));
    }

    /**
     * @des 修改 Conment
     * @param conment
     */
    @Override
    @Transactional
    public Conment updateConment(Conment conment){
        log.info("修改conment-> conment={}",JSON.toJSONString(conment));
        if(null == conment.getId()){
            throw new MyException(ErrorCode.UPDATE_FAIL);
        }
        int updateResult = conmentMapper.updateConment(conment);
        if (updateResult < 1) {
            throw new MyException(ErrorCode.UPDATE_FAIL);
        }
        return findById(String.valueOf(conment.getId()));
    }

    /**
     * @des 根据主键删除信息
     * @param recordId
     */
    @Override
    @Transactional
    public int deleteById(String recordId){
        log.info("删除conment -> recordId={}",recordId);
        if(StringUtils.isEmpty(recordId)){
            throw new MyException(ErrorCode.DELETE_FAIL);
        }
        int delResult = conmentMapper.deleteById(recordId);
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
        log.info("批量删除conment -> idArr={}",JSON.toJSONString(idArr));
        if(null == idArr || 0 == idArr.length){
            throw new MyException(ErrorCode.REQUEST_ERROR);
        }
        return conmentMapper.deleteByIdArr(idArr);
    }

    /**
     * @des 根据id 查询信息
     * @param recordId
     */
    @Override
    @Transactional
    public Conment findById(String recordId){
        log.info("根据主键查询conment -> recordId={}",recordId);
        return StringUtils.isEmpty(recordId ) ? null : conmentMapper.findById(recordId) ;
    }

    /**
     * @des 根据id 集合查询信息
     * @param idArr id集合
     */
    @Override
    @Transactional(readOnly = true)
    public List<Conment> findByIdArr(Long[] idArr){
        log.info("根据主键集合查询conment -> idArr={}",JSON.toJSONString(idArr));
        return conmentMapper.findByIdArr(idArr);
    }

    /**
     * @des 根据条件分页查询信息
     * @param pageRequest
     */
    @Override
    @Transactional(readOnly = true)
    public PageInfo findByParams(PageRequestParams<Conment> pageRequest) {
        log.info("分页查询conment -> pageRequest={}",JSON.toJSONString(pageRequest));
        Conment conment = pageRequest.getParams();
        List<Conment> conmentList = conmentMapper.findByParams(conment, pageRequest);
        int count = count(conment);

        PageInfo pageInfo = new PageInfo();
        pageInfo.setTotalElements(count);
        pageInfo.setNumber(pageRequest.getPageIndex());
        pageInfo.setSize(pageRequest.getPageSize());
        pageInfo.setContent(conmentList);

        return pageInfo;
    }

    /**
     * @des 根据条件统计信息
     * @param conment
     */
    @Override
    @Transactional(readOnly = true)
    public int count(Conment conment) {
        log.info("根据条件计数 -> conment={}", JSON.toJSONString(conment));
        return conmentMapper.count(conment);
    }

}