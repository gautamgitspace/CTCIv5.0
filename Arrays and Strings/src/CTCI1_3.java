import java.util.*;
import java.io.*;


public class CTCI1_3
{
		String output;
		
	private String sort(String s)
	{
		char[] stringContent = s.toCharArray();
		Arrays.sort(stringContent);
		output=new String(stringContent);
		return output;
	}
	
	
	
}

