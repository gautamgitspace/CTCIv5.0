/**
 * Created by Gautam on 7/8/16.
 * CTCI 1.5 - When we are not allowed to use a StringBuffer or when memory matters.
 * We need to take a char array of the size that we need.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CTCI1_5b
{
    private String stringCompression(String string)
    {
        int count = 1;
        if (string == null || string.isEmpty())
        {
            return "You entered an empty string";
        }
        int compareSize = compressionCount(string);
        System.out.println("Compression Size: " + compareSize + " Original Size: " + string.length());
        if (compareSize>=string.length())
            return string;

        int index = 0;
        //just the size required
        char[] container = new char[compareSize];
        char comparator = string.charAt(0);
        for(int i=1;i<string.length();i++)
        {
            if(string.charAt(i)==comparator)
            {
                count++;
                //System.out.println("Count for " + comparator + " increased to: " + count);
            }
            else
            {
                index = setChar(container, count, index, comparator);
                comparator=string.charAt(i);
                count=1;
            }
        }
        //ENTERTAINING THE VERY LAST
        index = setChar(container, count, index, comparator);
        return String.valueOf(container);
    }

    private int setChar(char[] array, int count, int index, char c)
    {
        //System.out.println("Inserting - " + c);
        array[index] = c;
        index++;
        char [] cnt = String.valueOf(count).toCharArray();
        //System.out.println("*****" + cnt[0]);
        for (char x : cnt)
        {
            array[index] = x;
            index++;
        }
        return index;
    }
    private int compressionCount(String string)
    {
        int i, stringSize = 0;
        int count=1;
        if (string == null || string.isEmpty())
        {
            stringSize = 0;
        }
        char comparator = string.charAt(0);
        for(i=1; i<string.length();i++)
        {
            if(string.charAt(i)==comparator)
            {
                count++;
            }
            else
            {
                comparator=string.charAt(i);
                count=1;
                stringSize += 1 + Integer.toString(count).length();
            }
        }
        //ENTERTAINING THE VERY LAST
        stringSize += 1 + Integer.toString(count).length();
        return stringSize;
    }

    public static void main(String args[])
    {
        try
        {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Testing BetterCompressionAlternateVersion. Enter String");
            String abc = bufferedReader.readLine();
            CTCI1_5b obj = new CTCI1_5b();
            String output = obj.stringCompression(abc);
            System.out.println(output);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
