package com.thoughtworks.jimmy.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.thoughtworks.jimmy.entity.BookEntity;
import com.thoughtworks.jimmy.entity.CategoryEntity;
import com.thoughtworks.jimmy.repository.BookRepository;
import com.thoughtworks.jimmy.repository.CategoryRepository;

public class BookServiceImplTest {

    @InjectMocks
    private BookServiceImpl bookService;

    @Mock
    private BookRepository bookRepository;

    @Mock
    private CategoryRepository categoryRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void should_find_book_by_title_when_given_title() {
        Iterable<BookEntity> expectedBooks = Arrays.asList(
                new BookEntity("12345", "Head Fist Java", "author", 55.0)
        );
        String title = "Java";
        when(bookRepository.findByTitle(title)).thenReturn(expectedBooks);

        Iterable<BookEntity> books = bookService.findByTitle(title);

        assertEquals(expectedBooks, books);

    }

    @Test
    public void should_find_book_by_tag_when_given_valid_tag() {
        Iterable<BookEntity> expectedBooks = Arrays.asList();
        CategoryEntity category = new CategoryEntity("B011", "IT", "This is a description");
        when(categoryRepository.findByName(category.getName())).thenReturn(category);
        when(bookRepository.findByCategoryCode(category.getCode())).thenReturn(expectedBooks);

        Iterable<BookEntity> books = bookService.findByCategoryName(category.getName());

        assertEquals(expectedBooks, books);
    }

    @Test(expected = RuntimeException.class)
    public void should_throw_exception_when_tag_not_found() {
        String categoryName = "category name";
        when(categoryRepository.findByName(categoryName)).thenReturn(null);

        bookService.findByCategoryName(categoryName);
    }
}