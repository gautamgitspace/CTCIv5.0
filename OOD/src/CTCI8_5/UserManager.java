package CTCI8_5;

import javax.jws.soap.SOAPBinding;
import java.util.Hashtable;

/**
 * Created by Gautam on 8/18/16.
 */
public class UserManager
{
    private Hashtable<String, User> subscribers;
    //CONS
    UserManager()
    {
        subscribers = new Hashtable<String, User>();
    }
    /*ADDITION*/
    public User addSubsriber(String uname, String uid, String atype, float bal)
    {
        User subscriber = new User(uname, uid, atype, bal);
        if (subscribers.containsKey(uid))
            return null;
        subscribers.put(uid, subscriber);
        return subscriber;
    }

    /*REMOVAL*/
    public boolean removeSubscriber(User user)
    {
        return removeSubscriberFromSubscribers(user.getUserID());
    }

    public boolean removeSubscriberFromSubscribers(String id)
    {
        if(!subscribers.containsKey(id))
            return false;
        subscribers.remove(id);
        return true;
    }
    /*SEARCH*/
    public User search(String id)
    {
        return subscribers.get(id);
    }
}

