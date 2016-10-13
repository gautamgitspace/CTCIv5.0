package CTCI11_2;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Gautam on 8/19/16.
 */
public class DriverStub
{
    public static String stringArrayToString(String[] array)
    {
        StringBuilder sb = new StringBuilder();
        for (String v : array) {
            sb.append(v + ", ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] array = {"hello", "part", "this", "hits", "shit", "is", "a", "trap", "world"};
        System.out.println(stringArrayToString(array));
        Arrays.sort(array, new aComparator());
        System.out.println(stringArrayToString(array));
    }
}
