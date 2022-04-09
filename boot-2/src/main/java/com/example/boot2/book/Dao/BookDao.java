package com.example.boot2.book.Dao;



import com.example.boot2.book.Book;

import java.util.List;

public interface BookDao {
    List<Book> findAllBook();
    Book findBookByid(int id);
    void update(int id, String name, float price);
    void addBook(int id, String name, float price);
}
