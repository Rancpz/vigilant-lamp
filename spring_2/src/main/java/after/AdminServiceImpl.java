package after;

public class AdminServiceImpl implements AdminService {

    @Override
    public void save(String name) {
        System.out.println("当前执行方法：save");
        System.out.println("调用Dao：" + name);
    }

    @Override
    public void update(String id) {
        System.out.println("当前执行方法：update");
        System.out.println("调用Dao：" + id);
    }

    @Override
    public String findOne(String id) {
        System.out.println("当前执行方法：findOne");
        System.out.println("调用Dao：" + id);
        return id;
    }
}
