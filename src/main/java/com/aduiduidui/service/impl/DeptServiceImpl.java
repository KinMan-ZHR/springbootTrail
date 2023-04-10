package com.aduiduidui.service.impl;


import com.aduiduidui.mapper.DeptMapper;
import com.aduiduidui.pojo.Dept;
import com.aduiduidui.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }

    @Override
    public void delete(Integer id) {
        deptMapper.deleteById(id);
    }

    @Override
    public void add(Dept dept) {
        //传入当前本地时间
        dept.setCreateTime(Timestamp.valueOf(LocalDateTime.now()));
        dept.setUpdateTime(Timestamp.valueOf(LocalDateTime.now()));
        deptMapper.insert(dept);
    }

    /**
     * 根据id查询部门
     *
     * @param id 部门id
     * @return 部门对象
     */
    @Override
    public Dept getInfoById(Integer id) {
        return deptMapper.getInfoById(id);
    }

    /**
     * 修改部门信息
     *
     * @param dept 部门对象
     */
    @Override
    public void update(Dept dept) {
        dept.setUpdateTime(Timestamp.valueOf(LocalDateTime.now()));
        deptMapper.update(dept);
    }


}
