package compzx.intercept;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 自定义拦截器  实现HandlerInterceptor 接口
public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        System.out.println("强制拦截");
        response.sendRedirect(request.getContextPath()+"/test.jsp");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {
        // 参数1：当前的请求对象  参数2：当前请求的响应对象  参数3：当前请求要访问的控制的方法对象  参数4：控制器方法返回的ModelView对象  模型和视图对象
        System.out.println("modelAndView = " + modelAndView);
        System.out.println("=================3=============");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception exception) throws Exception {
        // 参数1：当前的请求对象  参数2：当前请求的响应对象  参数3：当前请求要访问的控制的方法对象  参数4： 请求过程中出现的异常对象
        if (exception !=null) System.out.println("exception = " + exception.getMessage());
        System.out.println("=================4=============");
    }
}
