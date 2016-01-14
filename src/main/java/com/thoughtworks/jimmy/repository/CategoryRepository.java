package com.thoughtworks.jimmy.repository;

import org.springframework.data.repository.CrudRepository;
import com.thoughtworks.jimmy.entity.CategoryEntity;

public interface CategoryRepository extends CrudRepository<CategoryEntity, Integer> {
    CategoryEntity findByName(String name);
}
