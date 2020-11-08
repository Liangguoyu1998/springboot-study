package com.liang.dao;

import com.liang.pojo.Department;
import com.liang.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author:Lenovo
 * @date:2020-11-02 2020/11/2
 */
//员工dao
@Repository
public class EmployeeDao {
    //模拟数据库中的数据
    private static Map<Integer, Employee> employees = null;
    @Autowired
    private DepartmentDao departmentDao;
    static {
        employees = new HashMap<>();
        employees.put(1001,new Employee(1001,"小明","3083614562@qq.com",1,new Department(101,"教学部"),new Date()));
        employees.put(1002,new Employee(1002,"小红","5883614562@qq.com",0,new Department(102,"市场部"),new Date()));
        employees.put(1003,new Employee(1003,"小谢","3018614562@qq.com",0,new Department(103,"教研部"),new Date()));
        employees.put(1004,new Employee(1004,"小张","3083658562@qq.com",1,new Department(104,"运营部"),new Date()));
        employees.put(1005,new Employee(1005,"小巧","3079614562@qq.com",0,new Department(105,"后勤部"),new Date()));
    }
    //主键自增
    private static Integer initId = 1006;
    //增加一个员工
    public void save(Employee employee){
        if(employee.getId() == null){
            employee.setId(initId);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(),employee);
    }
    //查询全部员工
    public Collection<Employee> getAll(){
        return employees.values();
    }
    //通过id查询员工
    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }
    //删除员工，通过id
    public void delete(Integer id){
        employees.remove(id);
    }
    //更新员工
    public void update(Employee employee){
        save(employee);
    }
}
