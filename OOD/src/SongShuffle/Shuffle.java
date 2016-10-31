package SongShuffle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by Gautam on 10/30/16.
 */
public class Shuffle
{
    public HashMap<String, Song> shuffler;
    public ArrayList<String> tracker;
    public Shuffle()
    {
        shuffler = new HashMap<String, Song>();
        tracker = new ArrayList<String>();
    }

    public static String generateRandomSlug()
    {
        String alphabetRange = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0; i<7; i++)
        {
            int n = random.nextInt(alphabetRange.length());
            stringBuilder.append(alphabetRange.charAt(n));
        }
        return stringBuilder.toString();
    }

    public void addSong(Song song)
    {
        String trackRandomSlug = generateRandomSlug();
        shuffler.put(trackRandomSlug, song);
        tracker.add(trackRandomSlug);
    }

    public Song shufflePlay()
    {
        Random random = new Random();
        int n = random.nextInt(tracker.size());
        String key = tracker.get(n);
        Song song = shuffler.get(key);
        return song;
    }

}
