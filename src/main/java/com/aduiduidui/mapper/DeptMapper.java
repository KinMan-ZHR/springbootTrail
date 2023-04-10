package com.aduiduidui.mapper;

import com.aduiduidui.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DeptMapper {
    /**
     * 查询全部部门
     * @return 部门列表
     */
    @Select("select * from dept")
    List<Dept> list();
}
