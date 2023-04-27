package com.infy.testplayground.controller;

import com.infy.testplayground.entity.H2Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

public class AbstractCrudController <R extends CrudRepository<E, Long>, E extends H2Entity> {

    @Autowired
    private R repository;

    @GetMapping("/{id}")
    public Optional<E> getById(@PathVariable Long id) {
        return repository.findById(id);
    }

    @GetMapping
    public Iterable<E> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public E create(@RequestBody E entity) {
        return repository.save(entity);
    }

    @PutMapping
    public E update(@RequestBody E entity) {
        return repository.save(entity);
    }

    @DeleteMapping
    public void deleteById(@RequestParam Long id) {
        repository.deleteById(id);
    }
}
