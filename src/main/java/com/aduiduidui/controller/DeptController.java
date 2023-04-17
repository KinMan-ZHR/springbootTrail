package com.aduiduidui.controller;

import com.aduiduidui.pojo.Dept;
import com.aduiduidui.pojo.Result;
import com.aduiduidui.service.DeptService;
import com.aduiduidui.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j //lombok的注解，自动创建日志对象
@RestController//相当于@ResponseBody ＋ @Controller合在一起的作用
@RequestMapping("/depts")//类级别的RequestMapping,api接口为/depts
//一个完整的URL为：类级别的RequestMapping+方法级别的RequestMapping
public class DeptController {
    //面向接口编程
    @Autowired
    private DeptService deptService;
    //无法自动装配。找不到 'DeptService' 类型的 Bean。请检查配置类。
    //private static Logger logger = Logger.getLogger("DeptController");
    //Restful风格的URL
    //RequestMapping
    //@RequestMapping(value = "/depts",method = GET)
    @GetMapping//简化版的RequestMapping;只能处理get请求
    public Result depts() {
        log.info("查询全部部门数据");
        //调用service层的方法
        List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }
      //路径变量 需要增加@PathVariable来接收
    //由于两个表的关系，所以删除某一个部门底下的所有的员工也应删除
    //要保证事务的一致性，所以要在service层进行处理
    /**
     * 删除部门
     * @param id 部门id
     * @return Result
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {

        log.info("删除部门数据");
        deptService.delete(id);
        return Result.success();

    }

    /**
     * 添加部门
     * @param dept 部门对象
     * @return Result
     */
    @PostMapping
    public Result add(@RequestBody Dept dept) {
        log.info("添加部门数据:{}",dept);//{}的意思是占位符，后面的dept会替换掉占位符。
        deptService.add(dept);
        return Result.success();
    }
    /**
     * 根据id查询部门
     * @param id 部门id
     * @return Result
     */
    @GetMapping("/{id}")
    public Result get(@PathVariable Integer id) {
        log.info("查询部门数据:{}",id);//占位符
        Dept dept = deptService.getInfoById(id);
        return Result.success(dept);
    }
    /**
     * 修改部门
     * @param dept 部门对象
     * @return Result
     */
    @PutMapping
    public Result update(@RequestBody Dept dept) {
        log.info("修改部门数据:{}",dept);//占位符
        deptService.update(dept);
        return Result.success();
    }
}
