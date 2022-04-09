package service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//动态代理的原理
public class TestProxy {
    public static void main(String[] args) {
        //使用动态代理对象：指的是在程序运行的过程中动态的通关代码为指定的类生成代理对象
        final UserServiceImpl userService = new UserServiceImpl();
        //目标类
        //Proxy用来生成动态对象的类
        // 参数1 classloader 类加载器:Proxy类需要在运行时为目标类生成代理对象，通过类加载器读取生成的目标类的信息，把目标类加载到内存中
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        // 参数2 class[] 动态代理对象的接口类型的数组，因为有多个类
        Class[] classes = {UserService.class};
        // 参数3 InvocationHandler 接口类型 invoke 方法,用来书写额外的操作

        //Proxy用来生成动态对象，返回值：创建好的动态代理对象
        UserService userServiceDy = (UserService) Proxy.newProxyInstance(classLoader, classes, new InvocationHandler() {
            // invoke 参数： 参数1： 要创建好的代理对象  参数2：当前代理对象要执行的方法对象
            //              参数3：当前代理对象执行方法的参数
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // 通过动态代理，对象调用自己的里面代理方法时会先执行InvocationHandler类中的 invoke方法
                System.out.println("当前执行的方法 = " + method.getName());
                System.out.println("当前的执行方法的参数 = " + args[0]);
                try {
                    System.out.println("开启事务");
                    // 通过反射机制调用目标类中的业务方法
                    Object invoke = method.invoke(new UserServiceImpl(), args);
                    System.out.println("提交事务");
                    return invoke;
                } catch (Exception e) {
                    System.out.println("回滚事务");
                    e.printStackTrace();
                }
                return null;
            }
        });
        System.out.println(userServiceDy.getClass());
        userServiceDy.findAll("雄安黑");
    }
}
