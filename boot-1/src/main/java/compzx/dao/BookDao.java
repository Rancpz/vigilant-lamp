package compzx.dao;

import compzx.util.Book;

import java.util.List;

public interface BookDao {
    List<Book> findAllBook();
    Book findBook(int id, String name, String author);
    Book findBookByid(int id);
}
