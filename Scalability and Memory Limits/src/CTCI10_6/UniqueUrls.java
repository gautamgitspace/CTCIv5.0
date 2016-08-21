package CTCI10_6;

import java.util.Hashtable;

/**
 * Created by Gautam on 8/21/16.
 */
public class UniqueUrls
{
    private static Hashtable<String, Boolean> urls = new Hashtable<String, Boolean>();

    public static boolean addToURLs(String url, Boolean flag)
    {
        if(urls.containsKey(url))
        {
            urls.put(url, true);
            return false;
        }
        urls.put(url, flag);
        return true;
    }

        public static void main(String args[])
        {
            addToURLs("tumb.lr/one", false);
            addToURLs("tumb.lr/two", false);
            addToURLs("tumb.lr/three", false);
            addToURLs("tumb.lr/four", false);
            addToURLs("tumb.lr/five", false);
            /*INSERTING DUPLICATE*/
            addToURLs("tumb.lr/five", false);

            System.out.print(urls.values());

        }
    }


