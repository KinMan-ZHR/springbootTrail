package com.aduiduidui.filter;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter(urlPatterns = "/*") //拦截所有请求，拦截该路径下的所有资源,如此相应的servlet也会被拦截
//需要在启动类上添加注解 @ServletComponentScan，才能扫描到该过滤器，因为该注解是用来扫描servlet和filter的，而springboot默认是不扫描的
//如果不想使用注解，可以在启动类中添加如下代码
//public class SpringbootDemoApplication {
//    public static void main(String[] args) {
//        SpringApplication.run(SpringbootDemoApplication.class, args);
//        //添加如下代码
//        ServletRegistrationBean bean = new ServletRegistrationBean(new Servlet01());
//        bean.addUrlMappings("/servlet01");
//        FilterRegistrationBean bean1 = new FilterRegistrationBean(new DemoFilter());
//        bean1.addUrlPatterns("/*");
//    }
//}
public class DemoFilter implements Filter {
    @Override //初始化方法, 只调用一次
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init 初始化方法执行了");
    }

    @Override //拦截到请求之后调用, 调用多次
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Demo 拦截到了请求...放行前逻辑");
        //放行，正常访问目标资源
        chain.doFilter(request,response);

        System.out.println("Demo 拦截到了请求...放行后逻辑");
    }

    @Override //销毁方法, 只调用一次
    public void destroy() {
        System.out.println("destroy 销毁方法执行了");
    }
}
