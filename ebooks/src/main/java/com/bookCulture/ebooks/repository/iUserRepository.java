package com.bookCulture.ebooks.repository;

import com.bookCulture.ebooks.model.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface iUserRepository extends MongoRepository<UserModel, String> {
    UserModel findByName(String name);
}
