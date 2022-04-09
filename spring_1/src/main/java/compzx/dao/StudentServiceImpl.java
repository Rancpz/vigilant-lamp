package compzx.dao;

import java.util.Date;

public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao;
    private String name;
    private Integer age;
    private Double salary;
    private Date bir;
    private Boolean sex;

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public void setBir(Date bir) {
        this.bir = bir;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void save(String name) {

        System.out.println("StudentServiceImpl name = " + name);
        studentDao.save("小贝");
        System.out.println("this.name = " + this.name);
        System.out.println("this.age = " + this.age);
        System.out.println("this.bir = " + this.bir);
        System.out.println("this.sex = " + this.sex);
        System.out.println("this.salary = " + this.salary);
    }

    public void setStudentDao(StudentDaoImpl studentDao) {
        this.studentDao = studentDao;
    }
}
