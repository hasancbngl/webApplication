package com.cobanogluhasan.springwebapp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String genre;
    private String publishedCountry;
    private String language;

    @OneToMany //one genre many albums
    @JoinColumn(name = "album_id")
    private Set<Album> albums = new HashSet<>();

    public Genre() {
    }

    public Genre(String genre) {
        this.genre = genre;
    }

    public Genre(String genre, String publishedCountry, String language) {
        this.genre = genre;
        this.publishedCountry = publishedCountry;
        this.language = language;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPublishedCountry() {
        return publishedCountry;
    }

    public void setPublishedCountry(String publishedCountry) {
        this.publishedCountry = publishedCountry;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Set<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(Set<Album> albums) {
        this.albums = albums;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", genre='" + genre + '\'' +
                ", publishedCountry='" + publishedCountry + '\'' +
                ", language='" + language + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genre genre = (Genre) o;
        return Objects.equals(id, genre.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
