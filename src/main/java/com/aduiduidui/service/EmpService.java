package com.aduiduidui.service;

import com.aduiduidui.pojo.PageBean;



public interface EmpService {
    /**
     * 传统分页查询
     */

   // PageBean findByPage(Integer page, Integer rows);
    /**
     * 使用mybatis的分页插件
     */

    PageBean findByPage(Integer page, Integer rows);
}
