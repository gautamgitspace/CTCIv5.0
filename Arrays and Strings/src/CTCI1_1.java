//This problems has two solutions in case we are allowed to use additional data structure then it becomes easy as we can use a hashset.
// Otherwise we take a boolean array and insert elements of string (to be tested) in it.


public class CTCI1_1
{

private CTCI1_1()
{
	System.out.println("Default Constructor");
}

private boolean check(String str)
{
	boolean Set[] = new boolean [256];
	for(int i=0; i<str.length();i++)
	{
	int val = str.charAt(i);
	System.out.println("Previous state for " + val + " " + Set[val]);
	
	if(Set[val]) {return false;}
	Set[val]=true;
	System.out.println("After state for " + val + " " +  Set[val]);
	
	}
	return true;
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
}


