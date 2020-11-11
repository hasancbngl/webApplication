package com.cobanogluhasan.springwebapp.bootstrap;

import com.cobanogluhasan.springwebapp.model.Album;
import com.cobanogluhasan.springwebapp.model.Artist;
import com.cobanogluhasan.springwebapp.model.Genre;
import com.cobanogluhasan.springwebapp.repositories.AlbumRepository;
import com.cobanogluhasan.springwebapp.repositories.ArtistRepository;
import com.cobanogluhasan.springwebapp.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {
    //CommandLineRunner is an interface used to run instances when it founds them

    private ArtistRepository artistRepository;
    private AlbumRepository albumRepository;
    private GenreRepository genreRepository;

    public Bootstrap(ArtistRepository artistRepository, AlbumRepository albumRepository, GenreRepository genreRepository) {
        this.artistRepository = artistRepository;
        this.albumRepository = albumRepository;
        this.genreRepository = genreRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Artist eminem = new Artist("eminem");
        Album slimShady = new Album("slim Shady",1999);

        eminem.getAlbums().add(slimShady);
        slimShady.getArtists().add(eminem);

        artistRepository.save(eminem);
        albumRepository.save(slimShady);

        Album musicMurderedBy = new Album("Music To Be murdered by", 2020);
        eminem.getAlbums().add(musicMurderedBy);
        musicMurderedBy.getArtists().add(eminem);

        artistRepository.save(eminem);
        albumRepository.save(musicMurderedBy);


        System.out.println("number of albums: " + albumRepository.count());
        System.out.println("number of artists: " + artistRepository.count());

        System.out.println("----------------------");

        Genre rap = new Genre("rap/hiphop", "U.S.","en");

        rap.getAlbums().add(musicMurderedBy);
        rap.getAlbums().add(slimShady);
        musicMurderedBy.setGenre(rap);
        slimShady.setGenre(rap);

        genreRepository.save(rap);
        albumRepository.save(musicMurderedBy);
        albumRepository.save(slimShady);


        System.out.println(" albums: " + albumRepository.findAll());
        System.out.println("genre: " + genreRepository.findAll());


    }
}
