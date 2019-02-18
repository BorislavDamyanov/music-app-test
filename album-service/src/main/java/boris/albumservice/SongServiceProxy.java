package boris.albumservice;


import boris.albumservice.entity.Album;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@FeignClient("zuul-api-gateway")
@RibbonClient("song-service")
public interface SongServiceProxy {

    @GetMapping("/song-service/songs/artist/{artist}/year/{year}")
    List<SongInfo> retrieveSongByArtistAndYearOfCreation(@PathVariable("artist")String artist, @PathVariable("year") int year);

    @GetMapping("/song-service/songs/year/{year}")
    List<SongInfo> getSongsByYear(@PathVariable("year") int year);

    @GetMapping("/song-service/songs")
     List<SongInfo> retrieveAllSongs();

}
