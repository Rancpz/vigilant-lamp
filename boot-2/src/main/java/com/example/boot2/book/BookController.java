package com.example.boot2.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping("update")
    public String update(int id, String name , float price) {
        bookService.update(id, name, price);
        return "first";
    }

    @RequestMapping("addBook")
    public String addBook(int id, String name , float price){
        bookService.addBook(id, name, price);
        return "first";
    }
}
