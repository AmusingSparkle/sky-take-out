package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Employee;
import com.sky.enumeration.OperationType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface EmployeeMapper {

    /**
     * 根据用户名查询员工
     * @param username
     * @return
     */
    @Select("select * from employee where username = #{username}")
    Employee getByUsername(String username);

    /**
     * 新增员工
     * @param employee
     */
    @AutoFill(OperationType.INSERT)
    @Insert("insert into employee(name, username, password, phone, sex, id_number, create_time, update_time, create_user, update_user) VALUES " +
            "(#{name}, #{username}, #{password}, #{phone}, #{sex}, #{idNumber}, #{createTime}, #{updateTime}, #{createUser}, #{updateUser})")
    void insert(Employee employee);

    /**
     * 分页查询员工
     * @param employeePageQueryDTO 前端DTO
     * @return 包含数据的Page对象
     */
    Page<Employee> pageQuery(EmployeePageQueryDTO employeePageQueryDTO);

    /**
     * 更新员工数据库
     * @param employee 被修改的员工
     */
    @AutoFill(OperationType.UPDATE)
    void update(Employee employee);

    /**
     * 根据id查询员工
     * @param id 查询的id
     * @return 员工信息
     */
    @Select("select * from employee where id = #{id}")
    Employee getById(long id);
}
