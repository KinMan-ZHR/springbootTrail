package com.aduiduidui.controller;

import com.aduiduidui.annotation.Log;
import com.aduiduidui.pojo.Emp;
import com.aduiduidui.pojo.PageBean;
import com.aduiduidui.pojo.Result;
import com.aduiduidui.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/emps")
public class EmpController {
    @Autowired
    private EmpService empService;
    /**
     * 分页查询实现,前端未提供请求路径，/page所以无法访问
     */
    @GetMapping("/page")
    public Result pageIf(@RequestParam(defaultValue = "1") Integer page,
                         @RequestParam(defaultValue = "10") Integer pageSize) {
        // 1.接收前端传递的参数,前端传递的参数是page和pageSize，这里接收的参数名要和前端传递的参数名一致
        // 2.调用service查询分页数据
        // 3.将分页数据返回给前端
        log.info("page = {},pageSize = {}", page, pageSize);
        PageBean pageBean = empService.findByPage(page, pageSize);
        return Result.success(pageBean);

    }

    /**
     * 新版分页查询(使用了分页插件)允许条件动态sql
     * @param page  当前页
     * @param pageSize  每页显示的条数
     * @param name 员工姓名
     * @param gender 员工性别
     * @param begin 入职时间
     * @param end 入职时间
     * @return 分页查询的数据
     */
    @GetMapping()
    public Result pageIf(@RequestParam(defaultValue = "1") Integer page,
                         @RequestParam(defaultValue = "10") Integer pageSize,
                         String name, Short gender,
                         @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate begin,
                         @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate end) {
        // 1.接收前端传递的参数,前端传递的参数是page和pageSize，这里接收的参数名要和前端传递的参数名一致
        // 2.调用service查询分页数据
        // 3.将分页数据返回给前端
        log.info("page = {},pageSize = {},{},{},{},{}", page, pageSize,name,gender,begin,end);
        PageBean pageBean = empService.findByPage2(page, pageSize,name,gender,begin,end);
        return Result.success(pageBean);

    }
    /**
     * 批量删除员工信息
     * @param ids 员工id
     * @return 删除结果
     */
    @Log
    @DeleteMapping("/{ids}")
    public Result deleteBat(@PathVariable List<Integer> ids){
        log.info("批量删除员工信息{}",ids);
        empService.deleteBat(ids);
        return Result.success();
    }
    /**
     * 新增员工
     * @param emp 员工信息
     * @return 新增结果
     */
    @Log
    @PostMapping
    public Result addEmp(@RequestBody Emp emp){
        log.info("新增员工{}",emp);
        empService.addEmp(emp);
        return Result.success();
    }

    /**
     * 根据id查询员工信息
     * @param id 员工id
     * @return 员工信息
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        log.info("根据ID查询员工信息, id: {}",id);
        Emp emp = empService.getById(id);
        return Result.success(emp);
    }
    /**
     * 更新员工信息
     * @param emp 员工信息
     * @return 更新结果
     */
    @Log
    @PutMapping
    public Result update(@RequestBody Emp emp){
        log.info("更新员工信息 : {}", emp);
        empService.update(emp);
        return Result.success();
    }

}
