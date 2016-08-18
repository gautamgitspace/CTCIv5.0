package CTCI8_3;

/**
 * Created by Gautam on 8/17/16.
 */
public class SongSelector
{
    private Song currentSong;
    //DEFCONS
    public SongSelector(Song s)
    {
        this.currentSong = s;
    }
    public void setSong(Song s)
    {
        currentSong = s;
    }
    public Song getCurrentSong()
    {
        return currentSong;
    }
}
