package team11.interceptor;

import com.alibaba.fastjson.JSON;
import team11.pojo.Result;
import team11.utils.JwtUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 自定义拦截器：实现HandlerInterceptor接口，并重写其所有方法
 * 1. preHandle方法：controller方法之前执行：拦截请求
 *                  return true:放行     return false:不放行
 * 2. postHandle方法：controller方法之后执行：拦截响应
 * 3. afterCompletion方法：整个请求响应都执行完毕时运行的方法（常用来释放资源）
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

   // @Override //实现拦截
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("拦截器执行中");

        //获取token令牌
        String token = request.getHeader("token");

        //没有token的请求拒绝放行（让浏览器直接跳到登录界面）
        if (token==null){
            //没令牌：拒绝放行，让浏览器直接跳转到登录页面
            Result result = Result.error("NOT_LOGIN");
            //手动将对象转成json
            String json = JSON.toJSONString(result);
            //手动响应json给浏览器（因为过滤器返回值为空）
            response.getWriter().print(json);
            return false; //不放行
        }

        //有token但是解析失败也拒绝放行 （让浏览器直接跳到登录界面）
        try{
            JwtUtils.parseJWT(token);
        }catch (Exception e){
            //没令牌：拒绝放行，让浏览器直接跳转到登录页面
            Result result = Result.error("NOT_LOGIN");
            //手动将对象转成json
            String json = JSON.toJSONString(result);
            //手动响应json给浏览器
            response.getWriter().print(json);
            return false; //不放行
        }

        // token没有任何问题直接放行（用户已登录）
        return true;
    }

}
