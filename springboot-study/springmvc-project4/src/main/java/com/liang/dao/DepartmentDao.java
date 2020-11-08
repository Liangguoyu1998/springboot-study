package com.liang.dao;

import com.liang.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author:Lenovo
 * @date:2020-11-02 2020/11/2
 */
//部门dao
@Repository
public class DepartmentDao {
    //模拟数据库中的数据
    private static Map<Integer, Department> departments = null;
    static {
        departments = new HashMap<>();
        departments.put(101,new Department(101,"教学部"));
        departments.put(102,new Department(102,"市场部"));
        departments.put(103,new Department(103,"教研部"));
        departments.put(104,new Department(104,"运营部"));
        departments.put(105,new Department(105,"后勤部"));
    }
    public Department getDepartmentById(Integer id){
        return departments.get(id);
    }
}
