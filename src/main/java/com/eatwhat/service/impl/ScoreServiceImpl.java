package com.eatwhat.service.impl;

import com.alibaba.druid.support.json.JSONUtils;
import com.eatwhat.dao.ScoreMapper;
import com.eatwhat.entity.Score;
import com.eatwhat.entity.comment.ErrorCode;
import com.eatwhat.entity.comment.PageModel;
import com.eatwhat.entity.comment.ServerResponse;
import com.eatwhat.service.ScoreService;
import com.github.pagehelper.PageHelper;
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

    @Override
    public List<Long> getFoodIdsByShopId(String shopId, PageModel pageModel) {
        //设置分页
        PageHelper.startPage(pageModel);

        List<Long> foodIdList = scoreMapper.getFoodIdsByShopId(shopId);

        return foodIdList;
    }


    /**
     * @param score
     * @des 添加 Score
     */
    @Override
    @Transactional
    public Score saveScore(Score score) {
        log.info("添加score -> score={}", JSONUtils.toJSONString(score));
//        score.setCreateTime(System.currentTimeMillis());
        int saveResult = scoreMapper.saveScore(score);
        if (saveResult < 1) {
            ServerResponse.createDefaultErrorMessage(ErrorCode.SAVE_FAIL);
        }
        return findById(String.valueOf(score.getId()));
    }

    /**
     * @param score
     * @des 修改 Score
     */
    @Override
    @Transactional
    public Score updateScore(Score score) {
        log.info("修改score-> score={}", JSONUtils.toJSONString(score));
        if (null == score.getId()) {
            ServerResponse.createDefaultErrorMessage(ErrorCode.UPDATE_FAIL);
        }
        int updateResult = scoreMapper.updateScore(score);
        if (updateResult < 1) {
            ServerResponse.createDefaultErrorMessage(ErrorCode.UPDATE_FAIL);
        }
        return findById(String.valueOf(score.getId()));
    }

    /**
     * @param recordId
     * @des 根据主键删除信息
     */
    @Override
    @Transactional
    public int deleteById(String recordId) {
        log.info("删除score -> recordId={}", recordId);
        if (StringUtils.isEmpty(recordId)) {
            ServerResponse.createDefaultErrorMessage(ErrorCode.DELETE_FAIL);
        }
        int delResult = scoreMapper.deleteById(recordId);
        if (delResult < 1) {
            ServerResponse.createDefaultErrorMessage(ErrorCode.DELETE_FAIL);
        }
        return delResult;
    }

    /**
     * @param idArr
     * @des 根据主键集合删除信息
     */
    @Override
    @Transactional
    public int deleteByIdArr(Long[] idArr) {
        log.info("批量删除score -> idArr={}", JSONUtils.toJSONString(idArr));
        if (null == idArr || 0 == idArr.length) {
            ServerResponse.createDefaultErrorMessage(ErrorCode.REQUEST_PARAMS_ERROR);
        }
        return scoreMapper.deleteByIdArr(idArr);
    }

    /**
     * @param recordId
     * @des 根据id 查询信息
     */
    @Override
    @Transactional
    public Score findById(String recordId) {
        log.info("根据主键查询score -> recordId={}", recordId);
        return StringUtils.isEmpty(recordId) ? null : scoreMapper.findById(recordId);
    }

    /**
     * @param idArr id集合
     * @des 根据id 集合查询信息
     */
    @Override
    @Transactional(readOnly = true)
    public List<Score> findByIdArr(Long[] idArr) {
        log.info("根据主键集合查询score -> idArr={}", JSONUtils.toJSONString(idArr));
        return scoreMapper.findByIdArr(idArr);
    }


    /**
     * @param score
     * @des 根据条件统计信息
     */
    @Override
    @Transactional(readOnly = true)
    public int count(Score score) {
        log.info("根据条件计数 -> score={}", JSONUtils.toJSONString(score));
        return scoreMapper.count(score);
    }

}