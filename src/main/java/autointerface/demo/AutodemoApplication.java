package autointerface.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication(scanBasePackages = {"autointerface.demo.*"})
@ComponentScan(basePackages = {"autointerface.demo.mybatis.*"})
@MapperScan("autointerface.demo.mybatis.mapper")
public class AutodemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutodemoApplication.class, args);
    }

}
