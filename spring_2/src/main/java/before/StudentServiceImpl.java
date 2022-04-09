package before;

public class StudentServiceImpl implements StudentService {

    @Override
    public void save(String name) {
        System.out.printf("当前执行方法：save");
        System.out.printf("处理业务逻辑调用Dao name =" + name);
    }

    @Override
    public String findOne(String id) {
        System.out.printf("当前执行方法：find");
        System.out.printf("处理业务逻辑调用Dao id = " + id);
        return id;
    }
}
