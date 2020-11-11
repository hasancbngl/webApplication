package com.cobanogluhasan.springwebapp.repositories;

import com.cobanogluhasan.springwebapp.model.Album;
import org.springframework.data.repository.CrudRepository;

public interface AlbumRepository extends CrudRepository<Album,Long> {
}
