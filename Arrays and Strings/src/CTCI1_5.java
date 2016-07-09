import java.io.*;

public class CTCI1_5
{
	int count=1;
		
	public String compression(String str)
	{
		if (str == null || str.isEmpty())
		{
			return "You've entered an empty string, program will terminate now";
		}
		else
		{
		StringBuffer customStr = new StringBuffer();
		char last = str.charAt(0);
		for(int i=1;i<str.length();i++)
		{
		if (last==str.charAt(i))
		{
			count++;
		}
		else
		{
			customStr.append(last);		//#1	APPEND CHARACTER TO RESULT STRING
			customStr.append(count);	//#2	APPEND COUNT TO RESULT STRING
			last=str.charAt(i);			//#3	UPDATE LAST	
			count=1;					//#4	RESET COUNT
		}
		}
		customStr.append(last);		//APPEND CHARACTER TO RESULT STRING
		customStr.append(count);
		
		
		String afterCompression=customStr.toString();
		if(afterCompression.length()>=str.length())
		{
			return str;
		}
		else
		return customStr.toString();
	}
	}
	public static void main(String args[])
	{
		try
		{
			CTCI1_5 obj = new CTCI1_5();
			System.out.println("Enter string");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String input=br.readLine();
			String result=obj.compression(input);
			System.out.println(result);

		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
	}
}
