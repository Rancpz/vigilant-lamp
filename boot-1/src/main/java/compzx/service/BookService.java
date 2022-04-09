package compzx.service;

import compzx.util.Book;

import java.util.List;

public interface BookService {
    List<Book> findAllBook();
    Book findBook(int id, String name, String author);
    Book findBookByid(int id);
}
