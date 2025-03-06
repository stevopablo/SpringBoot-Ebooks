package com.bookCulture.ebooks.service;

import com.bookCulture.ebooks.model.LivroModel;
import com.bookCulture.ebooks.repository.iLivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {
    @Autowired
    private iLivroRepository livroRepository;

    public List<LivroModel> getAllLivros(){
        return livroRepository.findAll();
    }
    public Optional<LivroModel> getLivroById(String id){
        return livroRepository.findById(id);
    }

    public LivroModel saveLivro(LivroModel livroModel){
        return livroRepository.save(livroModel);
    }

    public void deletarLivro(String id){
        livroRepository.deleteById(id);
    }

    public List<LivroModel> buscarPorAutor(String autor){
        return livroRepository.findByAutor(autor);
    }

    public List<LivroModel> buscarPorTitulo(String titulo){
        return livroRepository.findByTitleContainingIgnoreCase(titulo);
    }

}
