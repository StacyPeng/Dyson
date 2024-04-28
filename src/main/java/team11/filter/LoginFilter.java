package team11.filter;

import com.alibaba.fastjson.JSON;
import team11.pojo.Result;
import team11.utils.JwtUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebFilter("/*")
public class LoginFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    //过滤拦截方法
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException {

        System.out.println("过滤器执行中");

        //1. 强转request和response（儿子方法更多）
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //2. 获取用户请求的url地址和token令牌
        String url = request.getRequestURI().toString();
        String token = request.getHeader("token");

        //3. 对请求的url地址做判断

        //3.1 如果地址包含登录：放行，让用户正常登录
        if(url.contains("/login")){
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

    @Override
    public void destroy() {

    }

}
