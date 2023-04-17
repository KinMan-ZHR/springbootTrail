package com.aduiduidui.service;

import com.aduiduidui.pojo.Emp;
import com.aduiduidui.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;


public interface EmpService {
    /**
     * 传统分页查询
     */
    PageBean findByPage(Integer page, Integer rows);

    /**
     * 使用mybatis的分页插件
     */
    PageBean findByPage2(Integer page, Integer rows, String name, Short gender, LocalDate begin, LocalDate end);

    void deleteBat(List<Integer> ids);

    /**
     * 添加员工
     *
     * @param emp 员工对象
     */
    void addEmp(Emp emp);

    /**
     * 根据id查询员工
     *
     * @param id 员工id
     * @return 员工对象
     */
    Emp getById(Integer id);

    /**
     * 修改员工
     *
     * @param emp 员工对象
     */
    void update(Emp emp);

    /**
     * 员工登录
     *
     * @param emp 员工对象
     * @return 员工对象
     */
    Emp login(Emp emp);

}
