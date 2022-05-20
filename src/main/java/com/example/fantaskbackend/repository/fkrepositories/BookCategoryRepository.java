package com.example.fantaskbackend.repository.fkrepositories;

import com.example.fantaskbackend.model.fkmodels.BookCategories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookCategoryRepository extends JpaRepository<BookCategories, Long> {
}
