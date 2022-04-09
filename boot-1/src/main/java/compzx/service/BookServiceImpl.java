package compzx.service;

import compzx.util.Book;
import compzx.dao.BookDao;
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
    public Book findBook(int id, String name, String author) {
        return bookDao.findBook(id, name, author);
    }

    @Override
    public Book findBookByid(int id) {
        return bookDao.findBookByid(id);
    }
}
