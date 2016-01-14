package com.thoughtworks.jimmy.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.thoughtworks.jimmy.entity.BookEntity;

public interface BookRepository extends CrudRepository<BookEntity, String>{
    @Query("SELECT b FROM BookEntity b WHERE b.title like %?1%")
    Iterable<BookEntity> findByTitle(String title);
    Iterable<BookEntity> findByTitleContaining(String title);

    Iterable<BookEntity> findByCategoryCode(String categoryCode);
}
