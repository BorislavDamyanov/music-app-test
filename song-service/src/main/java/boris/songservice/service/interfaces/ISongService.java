package boris.songservice.service.interfaces;

import boris.songservice.entity.Song;

import java.util.List;

public interface ISongService {


     Song getSong (Long id);

     Song addSong(Song song);

     void deleteSong(Long id);

     List<Song> getAllSongs();

     List<Song> getSongByArtistAndYearOfCreation(String artist, int year);

     List<Song> getSongsByYear(int year);



}
