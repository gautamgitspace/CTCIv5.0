package CTCI8_3;

import java.util.*;

/**
 * Created by Gautam on 8/17/16.
 */
public class Playlist
{
    private Song song;
    private Queue<Song> songs = new LinkedList<Song>();
    /*CONS - EVERYTIME A NEW PLAYLIST IS NEEDED, CONS IS CALLED*/
    public Playlist(Queue<Song> songs, Song song)
    {
        super();
        this.song = song;
        this.songs = songs;
    }
    /*PLAY NEXT SONG IN THE GIVEN PLAYLIST*/
    public Song playNextInPlaylist(Queue<Song> songs)
    {
        return songs.peek();
    }
    /*ADD SONG TO SPECIFIED PLAYLIST*/
    public void addToPlaylist(Queue<Song> songs, Song song)
    {
        songs.add(song);
    }
    public void shufflePlay(CD cd, CDPlayer cdPlayer)
    {
        Map a = cd.getTracks();

        List<Integer> keysAsArray = new ArrayList<Integer>(a.keySet());
        Random r = new Random();
        Object trackName  = a.get(keysAsArray.get(r.nextInt(keysAsArray.size())));
        cdPlayer.playSong((Song) trackName);


    }

}
