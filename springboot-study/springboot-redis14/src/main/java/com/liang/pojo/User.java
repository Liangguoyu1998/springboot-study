package com.liang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @description:
 * @author:Lenovo
 * @date:2020-11-05 2020/11/5
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
//在企业中，我们的所有pojo都会序列化！SpringBoot
public class User implements Serializable {
    private String name;
    private int age;
}
