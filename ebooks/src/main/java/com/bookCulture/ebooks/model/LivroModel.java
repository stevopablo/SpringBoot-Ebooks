    package com.bookCulture.ebooks.model;

    import lombok.AllArgsConstructor;
    import lombok.Getter;
    import lombok.Setter;
    import org.springframework.data.annotation.Id;
    import org.springframework.data.mongodb.core.mapping.Document;

    @Getter
    @Setter
    @AllArgsConstructor
    @Document(collection = "livros")
    public class LivroModel {
        @Id
        private String id;
        private String autor;
        private String description;
        private String title;
        private Integer quantidades;
        private String imagemUrl;
    }
