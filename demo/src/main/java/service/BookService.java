package service;

import Model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    @Autowired
    Book bool;
    public List<Book> getBooks(){
        List<Book> books = new ArrayList<Book>();
        books.add(new Book("title1","Name1", 1.1));
        Book book= books.get(0);

        return books;
    }

}
