package com.aduiduidui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan //开启了对servlet组件的支持，springboot会自动扫描@WebServlet注解并将该类实例化
@SpringBootApplication
public class SpringbootTrailApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootTrailApplication.class, args);
    }

}
