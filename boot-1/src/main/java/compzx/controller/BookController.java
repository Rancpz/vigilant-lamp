package compzx.controller;

import compzx.util.Book;
import compzx.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("book")
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping("findAll")
    public String findAllBook(HttpServletRequest request) {
        List<Book> books = bookService.findAllBook();
        request.setAttribute("books",books);
        return "home";
    }

    @RequestMapping("findone")
    public String findOneBook(int id, HttpServletRequest request) {
        Book book = bookService.findBookByid(id);
        request.setAttribute("book", book);
        return "showOne";
    }

    @RequestMapping("findsome")
    public String findbook(int id, String name , String author, HttpServletRequest request) {
        Book book = bookService.findBook(id, name, author);
        request.setAttribute("book", book);
        return "showOne";
    }
}
