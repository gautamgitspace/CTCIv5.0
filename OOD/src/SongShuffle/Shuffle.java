package SongShuffle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by Gautam on 10/30/16.
 */
public class Shuffle
{
    public HashMap<Integer, Song> shuffler;
    public ArrayList<Integer> tracker;
    int count;
    public Shuffle()
    {
        shuffler = new HashMap<Integer, Song>();
        tracker = new ArrayList<Integer>();
        count = 0;
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
        /*DONE USING A SIMPLE INTEGER VALUE*/
        count++;
        shuffler.put(count, song);
        tracker.add(count);
    }

    public Song shufflePlay()
    {
        Random random = new Random();
        int n = random.nextInt(tracker.size());
        int key = tracker.get(n);
        Song song = shuffler.get(key);
        return song;
    }

}
