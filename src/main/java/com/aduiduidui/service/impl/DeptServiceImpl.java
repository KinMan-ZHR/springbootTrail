package com.aduiduidui.service.impl;


import com.aduiduidui.mapper.DeptMapper;
import com.aduiduidui.pojo.Dept;
import com.aduiduidui.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }
}
