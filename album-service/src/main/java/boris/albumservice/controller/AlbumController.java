package boris.albumservice.controller;


import boris.albumservice.SongInfo;
import boris.albumservice.SongServiceProxy;
import boris.albumservice.entity.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AlbumController {


    @Autowired
    private SongServiceProxy proxy;


    @GetMapping("/test")
    public  String test(){
        return "This is just a test  for the album class";
    }

    @GetMapping("/getSongBy/artist/{artist}/year/{year}")
   public List<SongInfo> retrieveSongByArtistAndYearOfCreation(@PathVariable("artist")String artist, @PathVariable("year") int year){
        List<SongInfo> response =  proxy.retrieveSongByArtistAndYearOfCreation(artist,year);

        return response;



    }

    @GetMapping("/getSongsBy/year/{year}")
    public List<SongInfo> retrieveSongsByYear( @PathVariable("year") int year){
        List<SongInfo> response =  proxy.getSongsByYear(year);

        return response;

    }



    @GetMapping("/getAllSongs")
    public List<SongInfo>  getAllSongs(){
        return proxy.retrieveAllSongs();
    }



}
