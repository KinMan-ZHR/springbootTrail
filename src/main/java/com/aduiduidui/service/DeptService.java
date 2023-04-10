package com.aduiduidui.service;

import com.aduiduidui.pojo.Dept;

import java.util.List;
public interface DeptService {
    /**
     * 查询全部部门
     * @return 部门列表
     */
    List<Dept> list();

    void delete(Integer id);

    /**
     * 添加部门
     * @param dept 部门对象
     */

    void add(Dept dept);

    /**
     * 根据id查询部门
     * @param id 部门id
     * @return 部门对象
     */
    Dept getInfoById(Integer id);

    /**
     * 修改部门信息
     * @param dept 部门对象
     */
    void update(Dept dept);
}
