package cn.newtouch.mohaijiang.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 启动类
 * @author mohaijiang
 * @since  17-7-5
 */
@SpringBootApplication
@RestController
public class DemoApplication {

    private int count = 0;

    @GetMapping
    public String hello(){
        return "hello " + count++ + "times";
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
