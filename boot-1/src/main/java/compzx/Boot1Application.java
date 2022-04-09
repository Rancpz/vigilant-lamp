package compzx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("compzx.book.Dao")
public class Boot1Application {

	public static void main(String[] args) {
		SpringApplication.run(Boot1Application.class, args);
		System.out.println("hello boot");
	}
}
