package team11;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "team11.chengyu.repository")  // JPA 仓库的新位置
@MapperScan({"team11.chengyu.mapper"})
public class DysonApplication{

    public static void main(String[] args) {
        SpringApplication.run(DysonApplication.class, args);
    }

}
