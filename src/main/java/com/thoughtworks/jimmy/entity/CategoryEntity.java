package com.thoughtworks.jimmy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "WO_CATEGORY")
public class CategoryEntity {
    @Id
    @Column(name = "CODE", length = 30)
    private String code;

    @Column(name = "NAME", nullable = false, unique = true, length = 30)
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    public CategoryEntity() {
    }

    public CategoryEntity(String code, String name, String description) {
        this.code = code;
        this.name = name;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
