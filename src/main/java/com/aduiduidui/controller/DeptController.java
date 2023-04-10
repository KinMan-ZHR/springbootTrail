package com.aduiduidui.controller;

import com.aduiduidui.pojo.Dept;
import com.aduiduidui.pojo.Result;
import com.aduiduidui.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Slf4j //lombok的注解，自动创建日志对象
@RestController//相当于@ResponseBody ＋ @Controller合在一起的作用
public class DeptController {
//面向接口编程
    @Autowired
    private DeptService deptService;
    //无法自动装配。找不到 'DeptService' 类型的 Bean。请检查配置类。
    //private static Logger logger = Logger.getLogger("DeptController");
    //Restful风格的URL
    //RequestMapping
    //@RequestMapping(value = "/depts",method = GET)
    @GetMapping("/depts")//简化版的RequestMapping;只能处理get请求
    public Result depts(){
        log.info("查询全部部门数据");
        //调用service层的方法
       List<Dept>deptList= deptService.list();
        return Result.success(deptList);
    }
}
