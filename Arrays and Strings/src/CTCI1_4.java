// CTCI 1.4 write a method to replace all the spaces in a string with %20.
// Instead of doing it backwards, I am implementing it forwards.

import java.util.*;
import java.io.*;

class CTCI1_4
{
	public void replaceJob(char[] input, int length)
	{
		int spaceCount = 0, index, i;
		for(i=0; i<length; i++)
		{
			if(input[i]==' ')
			{
				spaceCount++;
			}
		}
		index = length + spaceCount*2;
		input[index] = '\0';
		for(i=length-1; i>=0; i--)
		{
			if(input[i]==' ')
			{
				input[index-1] = '0';
				input[index-2] = '2';
				input[index-3] = '%';
				index-=3;
			}
			else
			{
				input[index-1] = input[i];
				index--;
			}
		}

	}
}
