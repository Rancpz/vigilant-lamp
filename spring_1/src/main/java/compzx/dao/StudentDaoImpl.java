package compzx.dao;

public class StudentDaoImpl implements StudentDao {

    @Override
    public void save(String name) {
        System.out.println("StudentDao name = " + name);
    }
}
