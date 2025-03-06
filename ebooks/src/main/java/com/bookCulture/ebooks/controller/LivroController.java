package com.bookCulture.ebooks.controller;

import com.bookCulture.ebooks.model.LivroModel;
import com.bookCulture.ebooks.repository.iLivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/livros")
@CrossOrigin("*") // Permite requisições de qualquer origem
public class LivroController {

    @Autowired
    private iLivroRepository livroRepository;

    // Retorna todos os livros
    @GetMapping()
    public ResponseEntity<List<LivroModel>> getAllBooks() {
        List<LivroModel> livros = livroRepository.findAll();
        return ResponseEntity.ok(livros);
    }

    // Retorna um livro por ID
    @GetMapping("/{id}")
    public ResponseEntity<LivroModel> getBookById(@PathVariable String id) {
        Optional<LivroModel> livro = livroRepository.findById(id);
        return livro.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Cria um novo livro
    @PostMapping()
    public ResponseEntity<LivroModel> createBook(@RequestBody LivroModel book) {
        LivroModel novoLivro = livroRepository.save(book);
        return ResponseEntity.ok(novoLivro);
    }

    // Deleta um livro por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookById(@PathVariable String id) {
        if (!livroRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        livroRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<LivroModel> uptadeBook(@PathVariable String id, @RequestBody LivroModel uptadedBook){
        return livroRepository.findById(id)
                .map(livro -> {
                livro.setTitle(uptadedBook.getTitle());
                livro.setAutor(uptadedBook.getAutor());
                livro.setDescription(uptadedBook.getDescription());
                livro.setQuantidades(uptadedBook.getQuantidades());
                livro.setImagemUrl(uptadedBook.getImagemUrl());
                LivroModel saveBook = livroRepository.save(livro);
                return ResponseEntity.ok(uptadedBook);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //Buscar Por autor
    @GetMapping("autor/{autor}")
    public ResponseEntity<List<LivroModel>> searchAutor(@PathVariable String autor){
        List<LivroModel> livros = livroRepository.findByAutor(autor);
        return ResponseEntity.ok(livros);
    }

    //Buscar por titulo
    @GetMapping("buscar/{tituto}")
    public ResponseEntity<List<LivroModel>> searchTitle(@PathVariable String tituto){
        List<LivroModel> livros = livroRepository.findByTitleContainingIgnoreCase(tituto);
        return ResponseEntity.ok(livros);
    }
}
