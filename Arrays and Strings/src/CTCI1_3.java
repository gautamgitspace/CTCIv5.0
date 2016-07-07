/**
 * Created by Gautam on 7/7/16.
 * CTCI 1_3 - to check if one string is permutation of the other
 */

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
	public static void main(String args[])
	{
		String input1, input2, sortedInput1, sortedInput2;
		boolean result;

		try
		{

			System.out.println("Enter First String(lower case only)");
			BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
			input1=br.readLine();
			System.out.println("Enter Second String(lower case only)");
			BufferedReader br2 = new BufferedReader (new InputStreamReader(System.in));
			input2=br.readLine();
			CTCI1_3 obj = new CTCI1_3();
			result=obj.isPermutation(input1,input2);
			if(result)
				System.out.println("Strings are permutation");
			else
				System.out.println("Strings are not permutation");
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
	}


}

