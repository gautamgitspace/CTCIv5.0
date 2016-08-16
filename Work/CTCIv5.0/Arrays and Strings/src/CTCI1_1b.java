import java.util.HashSet;

/**
 * Created by Gautam on 7/5/16.
 * case when we are allowed to use additional data structure - a hash set
 */
public class CTCI1_1b
{
    public boolean checkUnique(String str)
    {

        HashSet hashSet = new HashSet(str.length());

        for(char c : str.toCharArray())
        { //iterate through character array
            if(!hashSet.add(Character.toUpperCase(c)))//try to add each char to hashset
                return false; //return false if could not add
        }
        return true;
    }
    public static void main(String[] args)
    {

        String str = "aAbc";
        CTCI1_1b uc = new CTCI1_1b();
        boolean result = uc.checkUnique(str);
        if(result)
            System.out.println("String has all unique characters");
        else
            System.out.println("String does not have all unique characters");
    }


}
