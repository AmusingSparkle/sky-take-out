package com.sky.service;

import com.sky.dto.EmployeeDTO;
import com.sky.dto.EmployeeLoginDTO;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Employee;
import com.sky.result.PageResult;

public interface EmployeeService {

    /**
     * 员工登录
     */
    Employee login(EmployeeLoginDTO employeeLoginDTO);

    /**
     * 新增员工
     */
    void save(EmployeeDTO employeeDTO);

    /**
     * 分页查询员工
     */
    PageResult pageQuery(EmployeePageQueryDTO employeePageQueryDTO);

    /**
     * 启用或禁用员工
     * @param status 更改后的状态
     * @param id 被修改员工的id
     */
    void startOrStop(int status, long id);

    /**
     根据id查询员工
     * @param id 查询的id
     * @return 员工信息
     */
    Employee getById(long id);

    /**
     * 编辑员工信息
     * @param employeeDTO 编辑前信息
     * @return 说明是否成功
     */
    void update(EmployeeDTO employeeDTO);
}
