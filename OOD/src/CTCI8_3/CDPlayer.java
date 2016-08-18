package CTCI8_3;

/**
 * Created by Gautam on 8/17/16.
 */
public class CDPlayer
{
    private Playlist playlist;
    private CD cd;

    //CONS 1
    public CDPlayer(Playlist playlist, CD cd)
    {
        this.playlist = playlist;
        this.cd = cd;
    }
    //CONS 2
    public CDPlayer(Playlist playlist)
    {
        this.playlist=playlist;
    }
    //CONS 3
    public CDPlayer(CD cd)
    {
        this.cd = cd;
    }
    //SETTERS
    public void setPlaylist(Playlist p)
    {
        this.playlist = p;
    }
    public void setCD(CD c)
    {
        this.cd = c;
    }
    //GETTERS
    public Playlist getPlaylist()
    {
        return playlist;
    }
    public CD getCD()
    {
        return cd;
    }
    public void playSong(Song songName)
    {
        //TODO
    }






}
