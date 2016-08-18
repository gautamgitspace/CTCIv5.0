package CTCI8_3;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Gautam on 8/17/16.
 */
public class Jukebox
{
    private CDPlayer cdPlayer;
    private  SongSelector songSelector;
    private User user;
    private Set<CD> cdSet = new HashSet<CD>();
    User u;


    public Jukebox(CDPlayer cdPlayer, User user, Set<CD> cdSet, SongSelector ss)
    {
        super();
        this.cdPlayer = cdPlayer;
        this.user = user;
        this.songSelector = ss;
        this.cdSet = cdSet;
    }
    /*ADD MORE CDs TO SET */
    public void addToSet(CD cd)
    {
        cdSet.add(cd);
    }

    public Song getCurrentSong()
    {
        return songSelector.getCurrentSong();
    }
    public void setNewUser(String n, long i)
    {
     u = new User(n,i);
    }
    public void editUserInfo(String n, long i)
    {
        u.setName(n);
        u.setUser_id(i);
    }
    public void recharge(long userID, Double amount)
    {
        u.setBalance(amount, userID);
    }
}
