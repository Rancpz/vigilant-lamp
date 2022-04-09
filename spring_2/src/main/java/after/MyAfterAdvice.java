package after;

import org.springframework.aop.AfterAdvice;
import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class MyAfterAdvice implements AfterReturningAdvice {
//    参数1目标方法返回值  参数2：当前执行的方法对象 参数3：执行的方法参数 参数4 目标对象

    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("进入后置通知");
        System.out.println("返回值 returnValue = " + o);
        System.out.println("当前方法名称 = " + method.getName());
        System.out.println("当前方法参数" + objects[0]);
        System.out.println("target = " + o1.getClass());
    }
}
