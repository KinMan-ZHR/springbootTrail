package com.aduiduidui.service;

import com.aduiduidui.pojo.Dept;

import java.util.List;
public interface DeptService {
    /**
     * 查询全部部门
     * @return 部门列表
     */
    List<Dept> list();
}
