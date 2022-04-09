package service;

// 静态代理类：为一个业务层手动开发一个代理对象的过程称之为静态代理类
public class UserServiceStaticProxy implements UserService {
    //依赖于目标对象 真正的业务逻辑对象  target
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void save(String name) {
        System.out.println("处理业务逻辑,调用DAO~~~");

    }

    @Override
    public void delete(String id) {
        try {
            System.out.println("开启事务");
            userService.delete(id);//    调用真正业务逻辑方法
            System.out.println("提交事务");
        } catch (Exception e) {
            System.out.println("回滚事务");
            e.printStackTrace();
        }
    }

    @Override
    public void update(int id) {
        try {
            System.out.println("开启事务");
            userService.update(id);//    调用真正业务逻辑方法
            System.out.println("提交事务");
        } catch (Exception e) {
            System.out.println("回滚事务");
            e.printStackTrace();
        }
    }

    @Override
    public String findAll(String name) {
        try {
            System.out.println("开启事务");
            String result = userService.findAll(name);//    调用真正业务逻辑方法
            System.out.println("提交事务");
            return result;
        } catch (Exception e) {
            System.out.println("回滚事务");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String findOne(String name) {
        try {
            System.out.println("开启事务");
            String one = userService.findOne(name);//    调用真正业务逻辑方法
            System.out.println("提交事务");
            return one;
        } catch (Exception e) {
            System.out.println("回滚事务");
            e.printStackTrace();
        }
        return null;
    }
}
