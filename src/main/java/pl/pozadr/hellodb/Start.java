package pl.pozadr.hellodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.pozadr.hellodb.dao.VideoDao;

@Component
public class Start {
    private VideoDao videoDao;

    @Autowired
    public Start(VideoDao videoDao) {
        this.videoDao = videoDao;
        videoDao.saveVideo(2L,
                "North Orbit 2021 - Big Air | Freeride Kite",
                "https://www.youtube.com/watch?v=Jq83KWmZBjo");
    }
}
