/**
 * Created by Gautam on 7/9/16.
 */
public class CTCI1_8
{
    private static boolean isSubstring(String big, String small)
    {
        if (big.contains(small))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    private static boolean isRotation(String s1, String s2)
    {
        if (s1.length() == s2.length() && s1.length() > 0)
        {
            String bigString = s1 + s1;
            return isSubstring(bigString, s2);
        }
        return false;
    }

    public static void main(String[] args)
    {

            String word1 = "razer";
            String word2 = "rraze";
            String word3 = "waterbottle";
            String word4 = "bottlerwate";
            boolean result = isRotation(word1, word2);
            boolean result2 = isRotation(word3, word4);
            System.out.println(word1 + ", " + word2 + ": " + result);
            System.out.println(word3 + ", " + word4 + ": " + result2);
        }
    }


