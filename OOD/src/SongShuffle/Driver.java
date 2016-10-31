package SongShuffle;

/**
 * Created by Gautam on 10/30/16.
 */
public class Driver
{
    public static void main(String args[])
    {
        Shuffle shuffle = new Shuffle();
        Song song1 = new Song("Why You Hate The Game", "The Game", "Doctor's Advocate", "Compton Rap");
        Song song2 = new Song("Ol' English", "The Game", "Doctor's Advocate", "Compton Rap");
        Song song3 = new Song("Sun Goes Down", "Robin Schulz", "Prayer", "House");
        Song song4 = new Song("Promises", "Wiz Khalifa", "Blackk Hollywood", "Hip-Hop");
        Song song5 = new Song("Om Namah Shivay", "Krishna Das", "Heart Full of Soul", "Devotional");
        Song song6 = new Song("Faded", "Alan Walker", "CD Single", "Progressive House");
        Song song7 = new Song("Love Never Came", "Armin Van Buuren", "Insane", "Progressive Trance");
        Song songs[] = {song1, song2, song3, song4, song5, song6, song7};

        for(int i=0; i<songs.length; i++)
        {
            shuffle.addSong(songs[i]);
        }

        Song nowPlaying = shuffle.shufflePlay();
        System.out.println(shuffle.tracker);
        System.out.println("NOW PLAYING:\n");
        System.out.println(nowPlaying.getTrackName());
        System.out.println(nowPlaying.getTrackAlbum());
        System.out.println(nowPlaying.getTrackArtist());
        System.out.println(nowPlaying.getTrackGenre());
    }
}
