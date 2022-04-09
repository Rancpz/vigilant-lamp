package com.example.boot2.book;


import com.example.boot2.book.Dao.BookDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService{

    @Resource
    private BookDao bookDao;

    @Override
    public List<Book> findAllBook() {
        return bookDao.findAllBook();
    }

    @Override
    public void update(int id, String name, float price) {
        bookDao.update(id, name, price);
    }

    @Override
    public void addBook(int id, String name, float price) {
        bookDao.addBook(id, name, price);
    }

    @Override
    public Book findBookByid(int id) {
        return bookDao.findBookByid(id);
    }
}
