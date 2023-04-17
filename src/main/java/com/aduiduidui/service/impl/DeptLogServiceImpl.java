package com.aduiduidui.service.impl;

import com.aduiduidui.mapper.DeptLogMapper;
import com.aduiduidui.pojo.DeptLog;
import com.aduiduidui.service.DeptLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeptLogServiceImpl implements DeptLogService {

    @Autowired
    private DeptLogMapper deptLogMapper;
//开启新的事务，如果当前存在事务，则把当前事务挂起
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void insert(DeptLog deptLog) {
        deptLogMapper.insert(deptLog);
    }
}