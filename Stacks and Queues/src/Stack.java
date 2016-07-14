
public class Stack 
{
	   private int maxSize;
	   private long[] stackArray;
	   private int top;
	   private static int nItems;
	   
	   private Stack(int s)
	   {
	      maxSize = s;
	      stackArray = new long[maxSize];
	      top = -1;
	   }
	   
	   private void push(long j)
	   {
		   stackArray[++top] = j;
		   nItems++;
	   }
	   private long pop()
	   {
	    	 return stackArray[top--];
	   }
	   private long peek()
	   {
	      return stackArray[top];
	   }
	   private boolean isEmpty()
	   {
	      return (top == -1);
	   }
	   private boolean isFull()
	   {
	      return (top == maxSize - 1);
	   }
	   public static void main(String[] args) 
	   {
	      Stack theStack = new Stack(4);
		   for(int i=0;i<10;i++)
		   {
			   if (!theStack.isFull())
			   {
				   theStack.push(i);
			   }
		   }

		   System.out.println("Top Element: " + theStack.peek());

	      while (!theStack.isEmpty()) 
	      {
	         long value = theStack.pop();
	         System.out.print(value);
	         System.out.print(" ");
	      }
	      System.out.println("");
	      System.out.println("Total number of elements: " + nItems);
	   }
}
