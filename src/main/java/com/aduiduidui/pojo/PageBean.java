package com.aduiduidui.pojo;

/**
 * 分页查询实体类
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data// 生成get、set、toString方法
@NoArgsConstructor// 无参构造
@AllArgsConstructor// 全参构造
public class PageBean {
    private Long total; // 总记录数,名字必须为total，需要和easyui的datagrid组件的total属性对应
    private List rows; // 每页显示的数据集合，名字必须为rows，需要和easyui的datagrid组件的rows属性对应

}
