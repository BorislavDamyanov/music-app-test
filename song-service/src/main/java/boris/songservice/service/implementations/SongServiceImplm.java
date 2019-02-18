package boris.songservice.service.implementations;

import boris.songservice.entity.Song;
import boris.songservice.repository.SongRepository;
import boris.songservice.service.interfaces.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SongServiceImplm implements ISongService {


    @Autowired
    private SongRepository songRepository;


    @Override
    public List<Song> getSongsByYear(int year) {
        return songRepository.getSongByYear(year);
    }

    @Override
    public Song getSong(Long id) {
        return songRepository.getOne(id);
    }

    @Override
    public Song addSong(Song song) {
        Song savedSong = songRepository.save(song);
        return savedSong;
    }

    @Override
    public void deleteSong(Long id) {
        songRepository.deleteById(id);
    }

    @Override
    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    @Override
    public List<Song> getSongByArtistAndYearOfCreation(String artist, int year) {
        return songRepository.getSongByArtistAndYear(artist,year);
    }
}
