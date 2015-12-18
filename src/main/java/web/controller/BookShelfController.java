package web.controller;

import org.springframework.web.bind.annotation.*;
import web.model.Book;
import web.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookShelfController {

    @Autowired
    private BookService bookService;

    @Autowired
    public BookShelfController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Book> queryBooks() {
        return bookService.findAll();
    }

    @RequestMapping(value = "book/{isbn}", method = RequestMethod.GET)
    @ResponseBody
    public Book showBook(@PathVariable String isbn) {
       return bookService.findByIsbn(isbn);
    }

    @RequestMapping(value = "book/new", method = RequestMethod.GET)
    @ResponseBody
    public Book newBook() {
       return new Book("", "", "", 0.0);
    }

    @RequestMapping(value = "book", method = RequestMethod.POST)
    @ResponseBody
    public Iterable<Book> saveBook(Book book) {
        bookService.create(book);
        return bookService.findAll();
    }

    @RequestMapping(value = "book/edit/{isbn}", method = RequestMethod.GET)
    @ResponseBody
    public Book editBook(@PathVariable String isbn) {
        return bookService.findByIsbn(isbn);
    }

    @RequestMapping(value = "delete/{isbn}", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Book> deleteBook(@PathVariable String isbn) {
        bookService.delete(isbn);
        return bookService.findAll();
    }
}
