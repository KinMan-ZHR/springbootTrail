package com.aduiduidui.mapper;

import com.aduiduidui.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmpMapper {
    /**
     * 查询总记录数
     */
    @Select("select count(*) from emp")
    long count();
 /**
   *分页查询员工，传统方法
  * @param start 开始记录数
  * @param rows 每页显示的记录数
  * @return 员工集合
   */
    @Select("select * from emp limit #{rows} offset #{start}")
    List<Emp> findByPage(@Param("start") int start, @Param("rows") int rows);

    /**
     * 使用mybatis的分页插件
     * 本体是员工集合，但是在PageBean中，我们需要的是总记录数和员工集合
     * @return 员工集合
     */
    @Select("select * from emp")
    List<Emp> list();
}
