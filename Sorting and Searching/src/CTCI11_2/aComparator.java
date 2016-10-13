package CTCI11_2;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Gautam on 8/19/16.
 */
public class aComparator implements Comparator<String>
{
    public String sortChars(String s)
    {
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    public int compare(String s1, String s2)
    {
        return sortChars(s1).compareTo(sortChars(s2));
    }
}
