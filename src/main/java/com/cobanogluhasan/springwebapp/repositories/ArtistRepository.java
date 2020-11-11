package com.cobanogluhasan.springwebapp.repositories;

import com.cobanogluhasan.springwebapp.model.Artist;
import org.springframework.data.repository.CrudRepository;

public interface ArtistRepository extends CrudRepository<Artist, Long> {
    //@Repository annotates classes at the persistence layer, which will act as a database repository
}
