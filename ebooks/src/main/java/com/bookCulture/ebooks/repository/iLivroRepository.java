package com.bookCulture.ebooks.repository;

import com.bookCulture.ebooks.model.LivroModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface iLivroRepository extends MongoRepository<LivroModel, String> {
    List<LivroModel> findByAutor(String autor);

    List<LivroModel> findByTitleContainingIgnoreCase(String title);
}
