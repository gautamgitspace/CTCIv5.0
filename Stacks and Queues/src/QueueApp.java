// Implementation of a Queue as an Array

class Queue
   {
   private int maxSize;
   private long[] queArray;
   private int head;
   private int tail;
   private int nItems;

   public Queue(int s)
      {
      maxSize = s;
      queArray = new long[maxSize];
      head = 0;
      tail = -1;
      nItems = 0;
      }

   public void insert(long j)
      {
      if(tail == maxSize-1)         //if Q.tail==Q.length then Q.tail=start
         tail = -1;
      queArray[++tail] = j;         
      nItems++;                     //increment size
      }

   public long remove()    
      {
	  long temp;
	  
	  if(head==tail+1)				//underflow condition check
	  {
		  System.out.println("Queue is empty");
		  return 0;
	  }
	  else
	  {
      temp = queArray[head++]; // remove element and increment head
      if(head == maxSize)           // if Q.head==Q.length then Q.head=start
         head = 0;
      nItems--; 				// subtract from size
	  			
	  return temp;
	  }
      }

   public long peekFront()      // peek at head element
      {
      return queArray[head];
      }

   public long peekAtATime()	//peek at time to time - insertion at tail
   {
	   return queArray[tail];
   }
   
   public boolean isEmpty()    
      {
      return (nItems==0);
      }

   public boolean isFull()     
      {
      return (nItems==maxSize);
      }

   public int size()          
      {
      return nItems;
      }

   }  

	class QueueApp
   {
		public static void main(String[] args)
      {
      Queue theQueue = new Queue(5);
      theQueue.insert(10);  

      System.out.println("element at 0th index is: " + theQueue.peekAtATime());
      theQueue.insert(20);
      System.out.println("element at 1st index is: " + theQueue.peekAtATime());
      theQueue.insert(30);
      System.out.println("element at 2nd index is: " + theQueue.peekAtATime());
      theQueue.insert(40);
      System.out.println("element at 3rd index is: " + theQueue.peekAtATime());
      theQueue.insert(50);
      System.out.println("element at 4rd index is: " + theQueue.peekAtATime());

      theQueue.remove();              
      theQueue.remove();              
      theQueue.remove();
      theQueue.remove();

      System.out.println("element at head  is: " + theQueue.peekFront());

      theQueue.insert(70);	//at this add attempt tail is set to -1 again and 70 gets added to 0th index
      System.out.println("element at head  is: " + theQueue.peekFront());
      theQueue.remove();	//50 removed and head again becomes 0th index
      System.out.println("element at head  is: " + theQueue.peekFront());

      System.out.println("elements in the list: " + theQueue.size());
      
      while( !theQueue.isEmpty() )    
         {                            
         long n = theQueue.remove();  
         System.out.print(n);
         System.out.print(" ");
         }
      System.out.println("");
      }  
   }  