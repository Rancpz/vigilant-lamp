package compzx;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import compzx.service.BookService;

@SpringBootTest
public class Test2 {

    @Autowired
    private BookService bookService;

    @Test
    public void testmybatis(){
        System.out.println(bookService.findAllBook());
    }
}
