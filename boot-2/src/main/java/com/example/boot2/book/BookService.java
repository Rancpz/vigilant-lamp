package com.example.boot2.book;

import java.util.List;

public interface BookService {
    List<Book> findAllBook();
    void update(int id, String name, float price);
    void addBook(int id, String name, float price);
    Book findBookByid(int id);
}
