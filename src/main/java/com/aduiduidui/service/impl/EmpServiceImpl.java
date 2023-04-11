package com.aduiduidui.service.impl;

import com.aduiduidui.mapper.EmpMapper;
import com.aduiduidui.pojo.Emp;
import com.aduiduidui.pojo.PageBean;
import com.aduiduidui.service.EmpService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
    @Override
    public PageBean findByPage(Integer page, Integer rows) {

        //1.获取总记录数
        long total = empMapper.count();
        //2.获取分页查询的数据
        Integer start = (page - 1) * rows;
        List<Emp> emps = empMapper.findByPage(start, rows);
        //3.创建PageBean对象
        PageBean pageBean = new PageBean(total, emps);
        //4.返回PageBean对象
        return pageBean;
    }
    /**
     * 条件查询
     * 使用mybatis的分页插件
     */
    @Override
    public PageBean findByPage2(Integer page, Integer rows, String name, Integer gender, LocalDate begin, LocalDate end)
    {

        //1.设置分页参数
        PageHelper.startPage(page, rows);
        //执行分页查询
        List<Emp> emps = empMapper.list(name,gender,begin,end);
        //装载
        Page<Emp> empPage= (Page<Emp>) emps;
        //封装PageBean

        //4.返回PageBean对象
        return new PageBean(empPage.getTotal(), empPage.getResult());
    }

    /**
     * @param ids
     */
    @Override
    public void deleteBat(List<Integer> ids) {
        empMapper.deleteBat(ids);
    }

    /**
     * 添加员工
     *
     * @param emp 员工对象
     */
    @Override
    public void addEmp(Emp emp) {
        emp.setCreateTime(Timestamp.valueOf(LocalDateTime.now()));
        emp.setUpdateTime(Timestamp.valueOf(LocalDateTime.now()));
        empMapper.addEmp(emp);
    }

    /**
     * 根据id查询员工
     *
     * @param id 员工id
     * @return 员工对象
     */
    @Override
    public Emp getById(Integer id) {
        return empMapper.getById(id);
    }

    /**
     * 修改员工
     *
     * @param emp 员工对象
     */
    @Override
    public void update(Emp emp) {
        emp.setUpdateTime(Timestamp.valueOf(LocalDateTime.now()));
        empMapper.update(emp);
    }
}
