package com.bookCulture.ebooks.repository;

import com.bookCulture.ebooks.model.LivroModel;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class LivroRepository implements iLivroRepository {

    @Override
    public List<LivroModel> findByAutor(String autor) {
        return List.of();
    }

    @Override
    public List<LivroModel> findByTitleContainingIgnoreCase(String title) {
        return List.of();
    }

    @Override
    public <S extends LivroModel> S insert(S entity) {
        return null;
    }

    @Override
    public <S extends LivroModel> List<S> insert(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public <S extends LivroModel> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends LivroModel> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends LivroModel> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends LivroModel> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends LivroModel> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends LivroModel> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends LivroModel, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends LivroModel> S save(S entity) {
        return null;
    }

    @Override
    public <S extends LivroModel> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<LivroModel> findById(String s) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public List<LivroModel> findAll() {
        return List.of();
    }

    @Override
    public List<LivroModel> findAllById(Iterable<String> strings) {
        return List.of();
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(LivroModel entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends String> strings) {

    }

    @Override
    public void deleteAll(Iterable<? extends LivroModel> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<LivroModel> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<LivroModel> findAll(Pageable pageable) {
        return null;
    }
}
