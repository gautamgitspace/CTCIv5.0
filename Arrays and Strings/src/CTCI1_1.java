//This problems has two solutions in case we are allowed to use additional data structure then it becomes easy as we can use a hashset.
// Otherwise we take a boolean array and insert elements of string (to be tested) in it.


public class CTCI1_1
{

CTCI1_1()
{
	System.out.println("Default Constructor");
}
	
public static void main(String args[])
{
	String str = "abca";
	
CTCI1_1 obj = new CTCI1_1();
boolean result=obj.check(str);
if(result)
	System.out.println("String has unique characters");
else
	System.out.println("String has duplicates");
	
}

public boolean check(String str)
{
	boolean Set[] = new boolean [256];
	for(int i=0; i<str.length();i++)
	{
	int val = str.charAt(i);
	//System.out.println("value is :" + val);
	System.out.println("Previous state " + Set[val]);	//boolean array is false by default
	
	if(Set[val]) {return false;}
	Set[val]=true;
	System.out.println("After state " + Set[val]);
	
	}
	return true;
}
}


