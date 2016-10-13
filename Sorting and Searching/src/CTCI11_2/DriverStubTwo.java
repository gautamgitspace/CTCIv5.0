package CTCI11_2;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.LinkedList;

/**
 * Created by Gautam on 8/19/16.
 */
public class DriverStubTwo
{
    public static String sortChars(String s)
    {
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    public static void sort(String[] array)
    {
        Hashtable<String, LinkedList<String>> hash = new Hashtable<String, LinkedList<String>>();

		/*PUT SORTED CONTENT AS KEY AND BUILD A LL OF ANAGRAMS AND PUT IT IN HASH TABLE*/
        for (String s : array)
        {
            //System.out.println("s: " + s);
            /*OBTAIN KEY*/
            String key = sortChars(s);
            //System.out.println("KEY: " + key);
            /*PUT KEY*/
            if (!hash.containsKey(key))
            {
                hash.put(key, new LinkedList<String>());
            }
            /*FETCH LIST AT KEY*/
            LinkedList<String> anagrams = hash.get(key);
            /*PUSH INTO LIST*/
            anagrams.push(s);
        }

		/*GET LIST OF ANAGRAMS BY A KEY AND PUT IT IN THE ARRAY(ARG)*/
        int index = 0;
        for (String key : hash.keySet())
        {
            /*FETCH LIST OF ANAGRAMS*/
            LinkedList<String> list = hash.get(key);
            for (String t : list)
            {
                array[index] = t;
                index++;
            }
        }

        /*DEEP DIVE INTO HASH USING DIFF HASH FUNCTIONS*/

        /*
        System.out.println("KEYS: " + hash.keySet());
        System.out.println("VALUES: " + hash.values());
        System.out.println("ENTRIES: " + hash.entrySet());
        */

    }
    public static String stringArrayToString(String[] array)
    {
        StringBuilder sb = new StringBuilder();
        for (String v : array) {
            sb.append(v + ", ");
        }
        return sb.toString();
    }

    public static void main(String[] args)
    {
        String[] array = {"apple", "banana", "carrot", "ele", "duck", "papel", "tarroc", "cudk", "eel", "lee"};
        System.out.println("BEFORE: " + stringArrayToString(array));
        sort(array);
        System.out.println("AFTER: " + stringArrayToString(array));
    }
}
