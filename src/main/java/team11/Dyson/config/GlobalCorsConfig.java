package team11.Dyson.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Chengyu Peng
 * @student ID:230045675
 */
public class GlobalCorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        //adding a mapping path, /** indicates that the global cross-domain access permission is set for all paths
                        .allowedOriginPatterns("*")
                        //Which ip addresses, ports, and domain names are allowed to access
                        .allowCredentials(true)
                        //Whether to allow cookies to be sent
                        .allowedMethods("GET", "POST", "PUT", "DELETE")
                        //Which Http methods are open to allow cross-domain access
                        .allowedHeaders("*")
                        //What headers are allowed in HTTP requests
                        .exposedHeaders("*");
                        //Which header information is exposed (because cross-domain access does not capture all header information by default)
            }
        };
    }
}
