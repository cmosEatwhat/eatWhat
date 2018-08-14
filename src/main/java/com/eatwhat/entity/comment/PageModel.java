package com.eatwhat.entity.comment;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Description:
 * @Author: zhangxin_an
 * @CreateDate: 2018/8/14 17:08
 */
@Data
public class PageModel implements Serializable {

    //第几页
    @NotNull(message = "分页参数错误(limit不能为空)")
    @Min(0)
    @ApiModelProperty(value = "每页多少条", required = true)
    private int pageSize;

    //每页多少条
    @NotNull(message = "分页参数错误(limit不能为空)")
    @Min(1)
    @ApiModelProperty(value = "每页多少条", required = true)
    private Integer pageNum;

    //排序规则
    @ApiModelProperty(value = "排序参数(格式为：'create_time desc' 或者 'create_time asc' 注意前面的是数据库的字段名，不传默认按时间倒序)")
    private String orderBy = "create_time desc";

}
