package com.bookCulture.ebooks.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@Document(collection = "User")
public class UserModel {
    @Id
    private String Id;
    private String name;
    private String email;
    private String password;
}
