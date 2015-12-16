package web.service;

import web.model.Book;

public interface BookService {

    Iterable<Book> findAll();

    Book findByIsbn(String isbn);

    void create(Book book);

    void delete(String isbn);
}
