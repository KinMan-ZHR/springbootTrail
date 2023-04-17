package com.aduiduidui.service.impl;


import com.aduiduidui.mapper.DeptMapper;
import com.aduiduidui.mapper.EmpMapper;
import com.aduiduidui.pojo.Dept;
import com.aduiduidui.pojo.DeptLog;
import com.aduiduidui.service.DeptLogService;
import com.aduiduidui.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private EmpMapper empMapper;
    //注入部门日志的service,理解为部门日志的service是部门service的一个子服务
    @Autowired
    private DeptLogService deptLogService;
    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }
    //propagation = Propagation.REQUIRED用于指定事务的传播行为，
    // REQUIRED表示如果当前存在事务(本身处在一个事务中)，则加入该事务；如果当前没有事务，则创建一个新的事务
    //一个事务中的所有操作都是一个整体，要么全部成功，要么全部失败
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    @Override
    public void delete(Integer id) {
        try{
            deptMapper.deleteById(id);
            if(true)
                throw new RuntimeException("测试事务,而故意抛出异常");
            empMapper.deleteByDeptId(id);
        }finally {
            DeptLog deptLog = new DeptLog();
            deptLog.setCreateTime(LocalDateTime.now());
            deptLog.setDescription("执行了解散部门的操作,此次解散的是"+id+"号部门");
            deptLogService.insert(deptLog);
        }


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
