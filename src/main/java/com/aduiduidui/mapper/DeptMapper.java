package com.aduiduidui.mapper;

import com.aduiduidui.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {
    /**
     * 查询全部部门
     * @return 部门列表
     */
    @Select("select * from dept")
    List<Dept> list();

    /**
     * 根据id删除部门
     * @param id 部门id
     */
    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);

    /**
     * 添加部门
     * 因为我自己设置了主键自增，所以不需要传入id
     * 反而会由于显示设置id传入，导致报错(显示设置id，未传入id时会默认为0)
     * @param dept 部门对象
     */
    @Insert("insert into dept(name,create_time,update_time) values(#{name},#{createTime},#{updateTime})")
    void insert(Dept dept);
    /**
     * 根据id查询部门
     * @param id 部门id
     * @return 部门对象
     */
@Select("select * from dept where id = #{id}")
    Dept getInfoById(Integer id);

    /**
     * 修改部门信息
     * @param dept  部门对象
     */
    @Update("update dept set name = #{name},update_time = #{updateTime} where id = #{id}")
    void update(Dept dept);
}
