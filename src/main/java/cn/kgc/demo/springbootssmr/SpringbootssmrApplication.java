package cn.kgc.demo.springbootssmr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("cn.kgc.demo.springboot.mybatis.mapper")
@ComponentScan(basePackages = {"cn.kgc.demo.springboot.userservice","cn.kgc.demo.springboot.usercontroller"})
@EnableTransactionManagement
public class SpringbootssmrApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootssmrApplication.class, args);
    }

}
