package before;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class MyBefoeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] objects, Object target) throws Throwable {
        System.out.println("---------进入前置通知------------");
        System.out.println("当前执行方法：method = " + method.getName());
        System.out.println("当前执行参数 objects = " + objects[0]);
        System.out.println("当前执行的目标对象 target = " + target);
        System.out.println("----------前置通知结束____________");
    }
}
