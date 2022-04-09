package compzx.Aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspects {

//    @Before("execution(* compzx.service.*.*(..))")
//    public void before(JoinPoint joinPoint){
//        System.out.println("=======进入前置通知=======");
//        System.out.println(joinPoint.getTarget()); //获取目标方法
//        joinPoint.getSignature(); //方法签名
//        joinPoint.getArgs(); //方法参数
//    }
//
//    @After("execution(* compzx.service.*.*(..))")
//    public void after(JoinPoint joinPoint){
//        System.out.println("=======进入后置通知========");
//        System.out.println(joinPoint.getSignature());
//        System.out.println(joinPoint.getArgs());
//        System.out.println(joinPoint.getTarget());
//    }
//
//    @Around("execution(* compzx.service.*ServiceImpl.*(..))")
//    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//        System.out.println("======进入环绕通知=========");
//        proceedingJoinPoint.getTarget();
//        proceedingJoinPoint.getArgs();
//        proceedingJoinPoint.getSignature();
//        Object proceed = proceedingJoinPoint.proceed();// 执行目标方法 放行
//        System.out.println("=====目标方法执行完成后回到环绕通知======");
//        return proceed; // 返回目标方法的返回值
//    }
}
