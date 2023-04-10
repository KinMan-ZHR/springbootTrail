package com.aduiduidui.service.impl;

import com.aduiduidui.mapper.EmpMapper;
import com.aduiduidui.pojo.Emp;
import com.aduiduidui.pojo.PageBean;
import com.aduiduidui.service.EmpService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
@Autowired
private EmpMapper empMapper;
    /**
     * @param page 当前页
     * @param rows 每页显示的记录数
     * @return 分页查询的数据
     */
//    @Override
//    public PageBean findByPage(Integer page, Integer rows) {
//
//        //1.获取总记录数
//        long total = empMapper.count();
//        //2.获取分页查询的数据
//        Integer start = (page - 1) * rows;
//        List<Emp> emps = empMapper.findByPage(start, rows);
//        //3.创建PageBean对象
//        PageBean pageBean = new PageBean(total, emps);
//        //4.返回PageBean对象
//        return pageBean;
//    }
    /**
     * 使用mybatis的分页插件
     */
    @Override
    public PageBean findByPage(Integer page, Integer rows) {
        //1.设置分页参数
        PageHelper.startPage(page, rows);
        //执行分页查询
        List<Emp> emps = empMapper.list();
        //装载
        Page<Emp> empPage= (Page<Emp>) emps;
        //封装PageBean

        //4.返回PageBean对象
        return new PageBean(empPage.getTotal(), empPage.getResult());
    }
}
