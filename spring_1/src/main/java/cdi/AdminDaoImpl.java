package cdi;

public class AdminDaoImpl implements AdminDao {
    private String name;
    private Integer age;

    public AdminDaoImpl(String name, Integer age) {
        this.age = age;
        this.name = name;
    }

    @Override
    public void save(String name) {
        System.out.println("AdminDAO name = " + name);
        System.out.println("this.name = " + this.name + " " + this.age);

    }

    public void setName(String name) {
        this.name = name;
    }
}
