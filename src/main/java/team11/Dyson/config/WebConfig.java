package team11.Dyson.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import team11.Dyson.interceptor.LoginCheckInterceptor;

/**
 * ClassName: WebConfig
 * Package: team11.Dyson.config
 * Description: Interceptor 拦截器配置类
 *
 * @Author Alina Hu
 * @Create 2024/5/10 2:22
 * @Version 1.0
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    //设定拦截器要拦截的请求路径

    @Autowired
    private LoginCheckInterceptor loginCheckInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginCheckInterceptor)
                .addPathPatterns("/**")          // 拦截所有：/**
                .excludePathPatterns("/login");  // 不拦截 login登录界面

    }
}
