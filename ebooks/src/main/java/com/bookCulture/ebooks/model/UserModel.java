package com.bookCulture.ebooks.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Document(collection = "users")
public class UserModel {
    @Id
    private String id;
    private String name;
    private String email;
    private String password;
    private List<String> cart;
}
