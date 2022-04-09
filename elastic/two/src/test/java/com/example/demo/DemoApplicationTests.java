package com.example.demo;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Date;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private BookRepository repository;

    @Test
    void contextLoads() {
        Book book = new Book();
        book.setId("21");
        book.setName("小陈");
        book.setCreateDate(new Date());
        book.setAuthor("李白");
        book.setContent("这是中国的好人,这真的是一个很好的人,李白很狂");
        repository.save(book);
    }

}
