import java.io.*;

public class CTCI1_5
{
	int count=1;
		
	private String compression(String str)
	{
		if (str == null || str.isEmpty())
		{
			return "You've entered an empty string, program will terminate now";
		}
		else
		{
			int compareSize = countCompression(str);
			System.out.println("Compression Size: " + compareSize + " Original Size: " + str.length());
			if (compareSize>=str.length())
				return str;
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
			customStr.append(last);		//ENTERTAINING THE VERY LAST CHARACTER IN THE STRING
			customStr.append(count);
			return customStr.toString();
		}
	}
	private int countCompression(String string)
	{
		int stringSize = 0;
		int count = 1;
		if (string == null || string.isEmpty())
		{
			stringSize = 0;
		}
		char last = string.charAt(0);
		for(int i=1;i<string.length();i++)
		{
			if (string.charAt(i) == last)
			{
				count++;
			}
			else
			{
				last = string.charAt(i);
				stringSize += 1 + String.valueOf(count).length();
				count = 1;
			}
		}
			stringSize += 1 + String.valueOf(count).length();
		return  stringSize;
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
			System.out.println("Resulting String: " + result);

		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
	}
}
