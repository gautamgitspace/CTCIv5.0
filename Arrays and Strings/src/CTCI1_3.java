import java.util.*;
import java.io.*;


public class CTCI1_3
{
		private String output;
		
	private String sort(String s)
	{
		char[] stringContent = s.toCharArray();
		Arrays.sort(stringContent);
		output=new String(stringContent);
		return output;
	}

	private boolean isPermutation(String str1, String str2)
	{
		boolean var;
		if (str1.length()!=str2.length())
			return false;
		else
			var=sort(str1).equals(sort(str2));
		//System.out.println(var);
		return var;
	}
	

}

