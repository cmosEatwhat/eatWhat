package com.eatwhat.service.impl;

import com.alibaba.druid.support.json.JSONUtils;
import com.eatwhat.dao.FoodsMapper;
import com.eatwhat.entity.Foods;
import com.eatwhat.entity.bo.FoodIdAndScore;
import com.eatwhat.entity.comment.ErrorCode;
import com.eatwhat.entity.comment.PageModel;
import com.eatwhat.entity.comment.ServerResponse;
import com.eatwhat.entity.food.FoodWithScoreBo;
import com.eatwhat.entity.food.FoodsVo;
import com.eatwhat.service.FoodsService;
import com.eatwhat.service.ScoreService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
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

    @Resource
    private ScoreService scoreService;

    private static final Logger log = LoggerFactory.getLogger(FoodsService.class);

    /**
     * @param foods
     * @des 添加 Foods
     */
    @Override
    @Transactional
    public Foods saveFoods(Foods foods) {
        log.info("添加foods -> foods={}", JSONUtils.toJSONString(foods));
//        foods.setCreateTime(System.currentTimeMillis());
        int saveResult = foodsMapper.saveFoods(foods);
        if (saveResult < 1) {
            ServerResponse.createDefaultErrorMessage(ErrorCode.SAVE_FAIL);
        }
        return findFoodById(String.valueOf(foods.getId()));
    }

    /**
     * @param foods
     * @des 修改 Foods
     */
    @Override
    @Transactional
    public Foods updateFoods(Foods foods) {
        log.info("修改foods-> foods={}", JSONUtils.toJSONString(foods));
        if (null == foods.getId()) {
            ServerResponse.createDefaultErrorMessage(ErrorCode.UPDATE_FAIL);
        }
        int updateResult = foodsMapper.updateFoods(foods);
        if (updateResult < 1) {
            ServerResponse.createDefaultErrorMessage(ErrorCode.UPDATE_FAIL);
        }
        return findFoodById(String.valueOf(foods.getId()));
    }

    private Foods findFoodById(String s) {
        return foodsMapper.findById(s);
    }

    /**
     * @param recordId
     * @des 根据主键删除信息
     */
    @Override
    @Transactional
    public int deleteById(String recordId) {
        log.info("删除foods -> recordId={}", recordId);
        if (StringUtils.isEmpty(recordId)) {
            ServerResponse.createDefaultErrorMessage(ErrorCode.DELETE_FAIL);
        }
        int delResult = foodsMapper.deleteById(recordId);
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
        log.info("批量删除foods -> idArr={}", JSONUtils.toJSONString(idArr));
        if (null == idArr || 0 == idArr.length) {
            ServerResponse.createDefaultErrorMessage(ErrorCode.REQUEST_PARAMS_ERROR);
        }
        return foodsMapper.deleteByIdArr(idArr);
    }

    /**
     * @param recordId
     * @des 查看菜品详情
     */
    @Override
    @Transactional
    public Foods findById(String recordId) {
        log.info("根据主键查询foods -> recordId={}", recordId);

        Foods food = foodsMapper.findById(recordId);

        return food;
    }

    /**
     * @param idArr id集合
     * @des 根据id 集合查询信息
     */
    @Override
    @Transactional(readOnly = true)
    public List<FoodsVo> findByIdArr(Long[] idArr) {
        log.info("根据主键集合查询foods -> idArr={}", JSONUtils.toJSONString(idArr));
        return foodsMapper.findByIdArr(idArr);
    }


    /**
     * @param foods
     * @des 根据条件统计信息
     */
    @Override
    @Transactional(readOnly = true)
    public int count(Foods foods) {
        log.info("根据条件计数 -> foods={}", JSONUtils.toJSONString(foods));
        return foodsMapper.count(foods);
    }


    /*
    *根据分类和店铺查所有商品ID
     */
    @Override
    public List<Long> findByShopsIdAndCategoryId(String shopsId, String CategoryId, PageModel pageModel) {
        List<Long> foodIdList = foodsMapper.findByShopsIdAndCategoryId(shopsId,CategoryId);
        return foodIdList;
    }

    /*
     *店铺和分类查菜品
     */
    public List<FoodsVo> findAllByShopsIdAndCategoryId(String shopsId, String categoryId, PageModel pageModel) {

        log.info("enter method findAllByShopsIdAndCategoryId shopsId{}" + shopsId);
        //设置分页
//        PageHelper.startPage(pageModel);

        List<Long> foodIdList = findByShopsIdAndCategoryId(shopsId,categoryId,pageModel);

        List<FoodIdAndScore> foodIdAndScoreList = scoreService.getScoreByFoodIdArrys(foodIdList);

        List<FoodsVo> foodsVoList = new ArrayList<>();

        for(FoodIdAndScore foodIdAndScore : foodIdAndScoreList){
            FoodsVo foodsVo = new FoodsVo();
            foodsVo = foodsMapper.findFoodById(foodIdAndScore.getFoodId());
            foodsVo.setAvgScore(foodIdAndScore.getAvgScore());
            foodsVoList.add(foodsVo);
        }

        return foodsVoList;
    }


    /*
     *店铺查菜品
     */
    public PageInfo<FoodsVo> findByShopsId(String shopsId, PageModel pageModel) {

        log.info("enter method findByShopsId shopsId{}" + shopsId);
        //设置分页
        PageHelper.startPage(pageModel);

        List<FoodsVo> foodsList = foodsMapper.findByShopsId(shopsId);
//取分页信息
        PageInfo<FoodsVo> pageInfo = new PageInfo<>(foodsList);

        return pageInfo;
    }

    /*
     *店铺查菜品
     */
    public List<FoodsVo> findByShopsId1(final String shopsId, PageModel pageModel) {

        log.info("enter method findByShopsId shopsId{}" + shopsId);

        List<FoodWithScoreBo> foodIdList = scoreService.getFoodIdsByShopId(shopsId,pageModel);

        List<Foods> foodsList = new ArrayList<>(10);
//        foodIdList.forEach( id ->{
//                Foods food = new Foods();
//                food = findById(id.toString());
//                foodsList.add(food);
//        });


        //取分页信息

        return null;
    }


}