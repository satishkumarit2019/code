package controller;

import Model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import service.BookService;

import java.util.List;

@RestController
public class RestDemo {

    @Autowired
    BookService bookService;

    @GetMapping("/book")
    public List<Book> getAllBooks(){
        System.out.println("Inside controller");
        return bookService.getBooks();
    }

}
