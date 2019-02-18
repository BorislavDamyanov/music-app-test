package boris.songservice.repository;


import boris.songservice.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {

        List<Song> getSongByArtistAndYear(String artist, int year);

        List<Song> getSongByYear(int year);

}
