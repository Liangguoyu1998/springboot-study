package com.liang.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author:Lenovo
 * @date:2020-11-05 2020/11/5
 */
@ApiModel("User实体类")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @ApiModelProperty("id编号")
    private int id;
    @ApiModelProperty("姓名")
    private String name;
    @ApiModelProperty("年龄")
    private int age;
}
