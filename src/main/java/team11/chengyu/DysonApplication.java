package team11.chengyu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("team11.domian")
@EnableJpaRepositories(basePackages = "team11.repository")
@MapperScan({"team11.mapper"})
public class DysonApplication{

    public static void main(String[] args) {
        SpringApplication.run(DysonApplication.class, args);
    }

}
