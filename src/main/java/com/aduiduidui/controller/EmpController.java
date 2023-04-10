package com.aduiduidui.controller;

import com.aduiduidui.pojo.PageBean;
import com.aduiduidui.pojo.Result;
import com.aduiduidui.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/emps")
public class EmpController {
    @Autowired
    private EmpService empService;
    /**
     * 分页查询实现
     */
    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize) {
        // 1.接收前端传递的参数,前端传递的参数是page和pageSize，这里接收的参数名要和前端传递的参数名一致
        // 2.调用service查询分页数据
        // 3.将分页数据返回给前端
        log.info("page = {},pageSize = {}", page, pageSize);
        PageBean pageBean = empService.findByPage(page, pageSize);
        return Result.success(pageBean);

    }
}
