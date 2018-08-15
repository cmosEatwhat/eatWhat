package com.eatwhat.entity.bo;

import lombok.Data;

/**
 * @Description:
 * @Author: zhangxin_an
 * @CreateDate: 2018/8/15 8:11
 */
@Data
public class FoodIdAndScore {

    private Long foodId;

    private Double avgScore;
}
