package SongShuffle;

/**
 * Created by Gautam on 10/30/16.
 */
public class Song
{
    public String trackName;
    public String trackArtist;
    public String trackAlbum;
    public String trackGenre;

    public Song(String trackName, String trackArtist, String trackAlbum, String trackGenre)
    {
        this.trackName = trackName;
        this.trackArtist = trackArtist;
        this.trackAlbum = trackAlbum;
        this.trackGenre = trackGenre;
    }

    public String getTrackName()
    {
        return trackName;
    }

    public String getTrackArtist()
    {
        return trackArtist;
    }

    public String getTrackAlbum()
    {
        return trackAlbum;
    }

    public String getTrackGenre()
    {
        return trackGenre;
    }
}
