package CTCI8_3;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Gautam on 8/17/16.
 */
public class CD
{
    private String albumTitle;
    private String artist;
    public Map<Integer , Song> tracks = new HashMap<Integer, Song>();

    CD(String albumName, String artisName, Map records)
    {
        this.albumTitle = albumName;
        this.artist = artisName;
        this.tracks = records;
    }

    public Map getTracks()
    {
        return tracks;
    }


}
