package compzx.config;

import compzx.intercept.MyInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册使用哪个拦截器
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**").excludePathPatterns("/book/findAll").excludePathPatterns("/user/findAll");
    }
}