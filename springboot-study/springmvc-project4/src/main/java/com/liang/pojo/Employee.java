package com.liang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @description:
 * @author:Lenovo
 * @date:2020-11-02 2020/11/2
 */
//员工表
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private Integer id;
    private String lastName;
    private String email;
    private Integer gender;//0:女   1:男
    private Department department;
    private Date birth;
}
