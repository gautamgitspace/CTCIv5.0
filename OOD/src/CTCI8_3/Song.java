package CTCI8_3;

/**
 * Created by Gautam on 8/17/16.
 */
public class Song
{
    private String trackName;
    private int trackID;
    private float trackLength;
    private String artist;
    private String albumTitle;

    Song(int songID, String songName, float songLength, String artistName, String albumName)
    {
        trackID = songID;
        trackName = songName;
        trackLength = songLength;
        artist = artistName;
        albumTitle = albumName;
    }


    public String getSongName()
    {
        return trackName;
    }
    public int getTrackID(){
        return trackID;
    }


}
