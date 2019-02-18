package boris.songservice.controller;


import boris.songservice.entity.Song;
import boris.songservice.service.interfaces.ISongService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class SongController {


    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private ISongService songService;


    @GetMapping("/hello-test")
    public String helloTest()
    {
        logger.info("Hello world");
        return "Hello World";
    }


    @GetMapping("/songs")
    public List<Song> retrieveAllSongs(){

        logger.info("{}", songService.getAllSongs());
        return songService.getAllSongs();
    }

    @GetMapping("/songs/{id}")
    public Song retrieveSong(@PathVariable Long id){
        logger.info("{}", songService.getSong(id));
        return songService.getSong(id);
    }

    @GetMapping("/songs/artist/{artist}/year/{year}")
    public List<Song> retrieveSongByArtistAndYearOfCreation(@PathVariable("artist")String artist, @PathVariable("year") int year){
        logger.info("{}", songService.getSongByArtistAndYearOfCreation(artist, year));
        return songService.getSongByArtistAndYearOfCreation(artist, year);
    }

    @PostMapping("/songs")
    public ResponseEntity saveSong(@RequestBody Song song){
        Song savedSong = songService.addSong(song);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedSong.getId()).toUri();

        logger.info("{}",ResponseEntity.created(location).build() );
        return ResponseEntity.created(location).build();

    }

    @GetMapping("songs/year/{year}")
    public List<Song> getSongsByYear(@PathVariable("year") int year){
        logger.info("{}", songService.getSongsByYear(year));
        return songService.getSongsByYear(year);
    }


    @DeleteMapping("/songs/{id}")
    public void removeSong(@PathVariable Long id){

        logger.info("id");

        songService.deleteSong(id);
    }



}
