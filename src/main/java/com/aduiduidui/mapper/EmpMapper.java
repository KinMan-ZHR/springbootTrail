package com.aduiduidui.mapper;

import com.aduiduidui.pojo.Emp;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
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
    //@Select("select * from emp")

    /**
     * 动态sql处理，推荐使用xml映射配置文件
     * @param name
     * @param gender
     * @param begin
     * @param end
     * @return
     */
    List<Emp> list(String name, Integer gender, LocalDate begin, LocalDate end);

    /**
     * 批量删除，使用动态sql配置语句
     * @param ids 要删除的id集合
     */
    void deleteBat(List<Integer> ids);

    /**
     * 添加员工
     * @param emp 员工对象
     */
    @Insert("insert into emp (username, name, gender, image, job, entrydate, dept_id, create_time, update_time)" +
            "values(#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime})")
    void addEmp(Emp emp);
@Select("select * from emp where id = #{id}")
    Emp getById(Integer id);
    /**
     * 更新员工
     * @param emp 员工对象
     */
    void update(Emp emp);
}
