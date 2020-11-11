package com.cobanogluhasan.springwebapp.repositories;

import com.cobanogluhasan.springwebapp.model.Genre;
import org.springframework.data.repository.CrudRepository;

public interface GenreRepository extends CrudRepository<Genre, Long> {
}
