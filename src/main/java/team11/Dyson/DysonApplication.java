package team11.Dyson;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "team11.Dyson.repository")  // JPA 仓库的新位置
@ServletComponentScan  // 开启Spring对过滤器filter的支持
@MapperScan({"team11.Dyson.mapper"})
public class DysonApplication{

    public static void main(String[] args) {
        SpringApplication.run(DysonApplication.class, args);
    }

}
