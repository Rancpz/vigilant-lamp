package comee.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "emt", type = "emp")
@Data

public class Emp {
    private String name;
    private Integer age;
    private String sex;
    private String content;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Emp() {
    }

    public Emp(String name, Integer age, String sex, String content) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
