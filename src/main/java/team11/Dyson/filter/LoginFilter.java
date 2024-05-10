package team11.Dyson.filter;

import com.alibaba.fastjson.JSON;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import team11.Dyson.pojo.Result;
import team11.Dyson.utils.JwtUtils;

import java.io.IOException;

/**
 * ClassName: LoginFilter
 * Package: team11.Dyson.interceptor
 * Description:
 *
 * @Author Alina Hu
 * @Create 2024/5/9 1:43
 * @Version 1.0
 */
/*
WebFilter方法：定义拦截资源的范围
      @WebFilter("/*")  拦截所有的请求
      @WebFilter("/aaa/*")  拦截aaa下面所有的请求
      @WebFilter("/findEmp")  只拦截指定请求findEmp
过滤器链：一个web应用中，可以配置多个过滤器，形成过滤器链，优先级按照过滤器类名的自然排序（包名下的文件名顺序）
*/
@WebFilter("/*")
public class LoginFilter implements Filter {

    //过滤拦截方法
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException {

        System.out.println("Java Filter executing! 过滤器执行中~ ");

        //1. 强转request和response
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //2. 获取用户请求的url地址和token令牌
        String url = request.getRequestURI();
        String token = request.getHeader("token");

        //3. 对请求的url地址做判断

        //3.1 如果地址包含登录：放行，让用户正常登录
        if(url.contains("/index")){
            filterChain.doFilter(request,response);
            return;//结束之后的代码
        }

        //3.2 地址是其他：判断用户是否登录（token令牌）
        if (token==null){
            //没令牌：拒绝放行，让浏览器直接跳转到登录页面
            Result result = Result.error("NOT_LOGIN");
            //手动将对象转成json
            String json = JSON.toJSONString(result);
            //手动响应json给浏览器（因为过滤器返回值为空）
            response.getWriter().print(json);
            return;//结束之后的代码
        }

        //3.3 有令牌,但是解析失败：拒绝放行 让浏览器直接跳到登录界面
        try{
            JwtUtils.parseJWT(token);
        }catch (Exception e){
            //没令牌：拒绝放行，让浏览器直接跳转到登录页面
            Result result = Result.error("NOT_LOGIN");
            //手动将对象转成json
            String json = JSON.toJSONString(result);
            //手动响应json给浏览器
            response.getWriter().print(json);
            return;//结束之后的代码
        }

        //3.4 令牌没有任何问题（用户已登录）：放行
        filterChain.doFilter(request,response);
    }

}
