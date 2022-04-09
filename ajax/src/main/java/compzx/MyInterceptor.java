package compzx;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//自定义拦截器 实现HandlerInterceptor接口
public class MyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        // 参数1：当前的请求对象  参数2：当前请求的响应对象  参数3：当前请求控制器的方法对象
        System.out.println(((HandlerMethod) o).getMethod().getName());
        System.out.println("=======1==============");
        // 强制用户登录
//        Object user = request.getSession().getAttribute("user");
//        if (user == null){
//            // 如果用户没登录，则重定向到登录页
//            response.sendRedirect(request.getContextPath()+"/login.jsp");
//            return false;
//        }
        return true;
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
        if (exception != null) System.out.println("exception = " + exception.getMessage());
        System.out.println("=================4=============");
    }

}
