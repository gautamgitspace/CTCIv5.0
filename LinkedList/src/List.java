/*
 *  Java Program to Implement Singly Linked List
 *  Implements CTCI 2.1, 2.2, 2.3, 2.4
 */
 
import java.util.Scanner;
import java.util.*;
 
/*  Class Node  */
class Node						//contains Node constructors and getter setter functions
{
    protected int data;
    protected Node link;
	//public Node next;
 
    public Node()
    {
        link = null;
        data = 0;
    }    

    public Node(int d,Node n)		//parameterized constructor 
    {
        data = d;
        link = n;
    }    
    
    public void setLink(Node n)
    {
        link = n;
    }    

    public void setData(int d)
    {
        data = d;
    }    
  
    public Node getLink()
    {
        return link;
    }    

    public int getData()
    {
        return data;
    }
}
 
class linkedList
{
    protected Node start;
    protected Node end ;
    public int size ;
 
  
    public linkedList()
    {
        start = null;
        end = null;
        size = 0;
    }
   
    public boolean isEmpty()
    {
        //returns true if start is null
        return start == null;
    }
  
    public int getSize()
    {
        return size;
    }    
   
    public void insertAtStart(int val)
    {
        Node nptr = new Node(val, null);    
        size++ ;    
        if(start == null) 
        {
            start = nptr;
            end = start;
        }
        else 
        {
            nptr.setLink(start);
            start = nptr;		//inserted element is not the ONLY element so need to take care of end
        }
    }
 
    public void insertAtEnd(int val)
    {
        Node nptr = new Node(val,null);    
        size++ ;    
        if(start == null) 
        {
            start = nptr;
            end = start;
        }
        else 
        {
            end.setLink(nptr);
            end = nptr;
        }
    }
  
    public void insertAtPos(int val , int pos)
    {
        Node nptr = new Node(val, null);                
        Node ptr = start;
        pos = pos - 1 ;
        for (int i = 1; i < size; i++) 
        {
            if (i == pos) 
            {
                Node tmp = ptr.getLink();
                ptr.setLink(nptr);
                nptr.setLink(tmp);
                break;
            }
            ptr = ptr.getLink();
        }
        size++ ;
    }
 
    public void deleteAtPos(int pos)
    {        
        //case 1st element
        if (pos == 1)
        {
            start = start.getLink();
            size--; 
            return ;
        }
        //case last element
        if (pos == size) 
        {
            Node s = start;
            Node previousTracker = start;
            while (s != end)
            {
                previousTracker = s;
                s = s.getLink();		//keep iterating  and updating t until end of list is reached. *TRAIN COACH METHOD*
            }
            end = previousTracker;		//update end
            end.setLink(null);	//update link of end
            size --;
            return;
        }
        //case other - iterate and de-link the node.
        Node ptr = start;
        pos = pos - 1 ;
        for (int i = 1; i < size - 1; i++) 
        {
            if (i == pos) 
            {
                Node tmp = ptr.getLink();
                tmp = tmp.getLink();
                ptr.setLink(tmp);
                break;
            }
            ptr = ptr.getLink();
        }
        size-- ;
    }    

    public void deleteByVal(int val)
    {
    	
    	if(start.getData()==val)			//element at first case
    		{
    			start=start.getLink();
    			size--;
    			return;
    		}
        if(val==end.getData())
        {
            System.out.println("XXX");
            Node iterator = start;
            Node previous = null;
            while(iterator!=end)
            {
                previous=iterator;
                iterator=iterator.getLink();
            }
            System.out.println(end.getData() + " Deleted!");
            end=previous;
            end.setLink(null);
            size--;

            return;
        }
    		
    	Node ptr = start;
    	while(ptr!=null)
        {
            if (ptr.getLink().getData()==val) 
            {
                Node tmp = ptr.getLink();
                tmp = tmp.getLink();
                ptr.setLink(tmp);
                break;
            }
            ptr = ptr.getLink();
        }
        size--;
    		
    	}
    public boolean Search(int val)
    {
    	boolean present=false;
    	Node ptr=start;
    	while(ptr!=null)
    	{
    		if(ptr.getData()==val)
    			{
    			present=true;
    			break;
    			}
    		ptr=ptr.getLink();
    	}
    	return present;
    
    }
    
    public void middleElement()
    {
    	Node ptr = start;
    	int middle =  (size/2) + (size%2==0 ? 0 : 1);
    	for(int i=1;i<middle;i++)
    	{
    		ptr=ptr.getLink();
    	}
    	int middleElement=ptr.getData();
    	System.out.println(( middleElement + " is the middle element"));
    }
    
    public Node middleNode()		//RETURNS THE MIDDLE NODE (as per CTCI v5.0-2.3 access to middle node is already given)
    {
    	Node ptr = start;
    	int middle =  (size/2) + (size%2==0 ? 0 : 1);
    	for(int i=1;i<middle;i++)
    	{
    		ptr=ptr.getLink();
    	}
    	System.out.println("middle is ***** " + ptr.getData());
    	return ptr;
    }
    
    public int countElement(int val)
    {

    	int count=0;
    	Node ptr=start;
    	for(int i=0;i<size;i++)
    	{
    		if(ptr.getData()==val)
    			{
    			//f=true;
    			count++;
    			//break;
    			}
    		ptr=ptr.getLink();
    	}
    	return count;
    
    }
    public Node reverseList(Node pointer)
    {
	  Node ptr=pointer;
	  Node prev,next,result;
	  prev=next=null;
	  
	  while(ptr!=null)
	  {
		  next=ptr.getLink();
		  ptr.setLink(prev);	//de-link ptr from the list 
		  prev=ptr;
		  ptr=next;
	  }
	  result=prev;
	  return result;
	  
    }
    
    public void removeDup()
    {
    	//solution when extra buffer is allowed. in this case, HashSet
        boolean result=true;
    	if(size==0)
    	System.out.println("List is empty");
    		
    	
    	Node ptr=start;
    	Node prev =null;
    	//Node next =null;
    	HashSet <Integer> hs = new HashSet<Integer>();
    	while(ptr!=null)
    	{
    	if (hs.contains(ptr.getData()))
    	{
    	prev.setLink(ptr.getLink());
    		System.out.println("duplicate detected and removed");
    	}
    	else
    	{
    		hs.add(ptr.getData());
    		prev=ptr;
    	}
    	ptr=ptr.getLink();
    	}
    	System.out.println("hashset is :" + hs);

    
    }
    
    public int kthToLast(int k)
    {
    	
    	Node ptr1=start;
    	Node ptr2=start;

    	for(int i=0;i<k;i++)
    	{
    		if(ptr2==null)
    		System.out.println("EMPTY LIST");
    		ptr2=ptr2.getLink();
            System.out.println("ptr2 stopped at: " + ptr2.getData());
    	}
    	if(ptr2==null)
    		System.out.println("REACHED END");
    	while(ptr2!=null)
    	{
    		ptr1=ptr1.getLink();
    		ptr2=ptr2.getLink();
            if(ptr2!=null)
            System.out.println("ptr2 stopped at: " + ptr2.getData());
    	}
    	return ptr1.getData();
    }
    	
    public void deleteMiddle(Node m)		//DELETES THE MIDDLE ELEMENT GIVEN ACCESS ONLY TO MIDDLE NODE CTCI v5.0-2.3
    {
    	m.setData(m.getLink().getData());
    	m.setLink(m.getLink().getLink());
        size--;
    }
    public void pivotSort(int pivot)
    {
    	Node ptr1=start;
    	Node ptr2=null;
    	Node wow = new Node(pivot, null);
    	boolean flag=false;
    	while(ptr1!=null)
    	{
    		if(ptr1.getData()<pivot)
    		{
    			if(ptr2==null)
    			{
    				ptr2=start;
    			}
    			else
    			{
    				ptr2=ptr2.getLink();
    			}
    			
    			int tmp=ptr1.getData();
    			ptr1.setData(ptr2.getData());
    			ptr2.setData(tmp);
    			
    		}
    			
    			if(ptr1.getData()==pivot)
    			flag=true;
    			ptr1=ptr1.getLink();
    	}
    	if(!flag)
    	{
    		Node tmp = ptr2.getLink();
    		wow.setLink(tmp);
    		ptr2.setLink(wow);
    	}
    	
    }
    
    public void display()
    {
        System.out.print("\nSingly Linked List = ");
        if (size == 0) 
        {
            System.out.print("empty\n");
            return;
        }    
        if (start.getLink() == null) 
        {
            System.out.println(start.getData() );
            return;
        }
        Node ptr = start;
        System.out.print(start.getData()+ "->");
        ptr = start.getLink();
        while (ptr.getLink() != null)
        {
            System.out.print(ptr.getData()+ "->");
            ptr = ptr.getLink();
        }
        System.out.print(ptr.getData()+ "\n");
    }
}
 

public class List
{    
    public static void main(String[] args)
    {             
        Scanner scan = new Scanner(System.in);
        /* Creating object of class linkedList */
        linkedList list = new linkedList(); 
        System.out.println("Singly Linked List Test\n");          
        char ch;
        /*  Perform list operations  */
        do
        {
            System.out.println("\nSingly Linked List Operations");
            System.out.println("-------------------------------\n");
            System.out.println("1. insert at beginning");
            System.out.println("2. insert at end");
            System.out.println("3. insert at position");
            System.out.println("4. delete at position");
            System.out.println("5. delete by value");
            System.out.println("6. check empty");
            System.out.println("7. get size");  
            System.out.println("8. Search List");
            System.out.println("9. Print middle value");
            System.out.println("10. Count occurrence of an element");
            System.out.println("11. Reverse the list");
            System.out.println("12. Remove duplicates");
            System.out.println("13. get Kth element from last");
            System.out.println("14. Delete Middle Element");
            System.out.println("15. Sort list around element");
            int choice = scan.nextInt();            
            switch (choice)
            {
            case 1 : 
                System.out.println("Enter integer element to insert");
                list.insertAtStart( scan.nextInt() );                     
                break;                          
            case 2 : 
                System.out.println("Enter integer element to insert");
                list.insertAtEnd( scan.nextInt() );                     
                break;                         
            case 3 : 		//INSERT AT A POSI
                System.out.println("Enter integer element to insert");
                int num = scan.nextInt() ;
                System.out.println("Enter position");
                int pos = scan.nextInt() ;
                if (pos <= 1 || pos > list.getSize() )
                    System.out.println("Invalid position\n");
                else
                    list.insertAtPos(num, pos);
                break;                                          
            case 4 : 		//DELETE AT A POSI
                System.out.println("Enter position");
                int p = scan.nextInt() ;
                if (p < 1 || p > list.getSize() )
                    System.out.println("Invalid position\n");
                else
                    list.deleteAtPos(p);
                break;
            case 5 : 		//DELETE BY A GIVEN VALUE
            	System.out.println("Enter value");
            	int v = scan.nextInt();
            	boolean result=list.Search(v);
           	 if(result)
           		list.deleteByVal(v);
           	 else
           		 System.out.println(v + " does not exist in the list");
           	 break;
            case 6 : 
                System.out.println("Empty status = "+ list.isEmpty());
                break;                   
            case 7 : 
                System.out.println("Size = "+ list.getSize() +" \n");
                break;                         
            case 8 :		//SEARCH AN ELEMENT IN THE LIST
            	 System.out.println("Enter a value to search in the list");
            	 int v1 = scan.nextInt();
            	 boolean searchResult=list.Search(v1);
            	 if(searchResult)
            		 System.out.println(v1 + " exists in the list");
            	 else
            		 System.out.println(v1 + " does not exist in the list");
            	 break;
            case 9 :
            	if(list.isEmpty())
            		System.out.println("EMPTY LIST");
            	else
            		list.middleElement();
            	break;
            case 10 :
            	if(list.isEmpty())
            	{
            		System.out.println("EMPTY LIST");
            	}
            	else
            	{
            	System.out.println("Enter value");
            	int v2 = scan.nextInt();
            	boolean result1=list.Search(v2);
              	 if(result1)
              	 {
              		 int countResult=list.countElement(v2);
              		 System.out.println(v2 + " occurs in the list " + countResult + " times");
              	 }
              	 else
              		 System.out.println(v2 + " does not exist in the list");
            	}
            	break;
            case 11 :
            list.start=list.reverseList(list.start);
            break;
            case 12:		//remove duplicates
            	list.removeDup();
            	break;
            case 13:
            	if(list.isEmpty())
            		System.out.println("EMPTY LIST");
            	else
            	{
            	System.out.println("enter the value of k");
            	int k = scan.nextInt();
            	int output = list.kthToLast(k);
            	System.out.println("----- " + output + " -----");}
            	break;
            case 14:
            	if(list.isEmpty())
            	{
            		System.out.println("EMPTY LIST");
            	}
            	else
            	{
            		Node tmp=list.middleNode();
            		list.deleteMiddle(tmp);
            	}
            	break;
            case 15: 
            	if(list.isEmpty())
            	{
            		System.out.println("EMPTY LIST");
            	}
            	else
            	{
            		System.out.println("Enter an element to sort the list around");
            		int pivotElement = scan.nextInt();
            		list.pivotSort(pivotElement);
            	}
            	break;
            	
            default : 
                System.out.println("Wrong Entry \n ");
                break;   
            }
            /*  Display List  */ 
            list.display();
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);                        
        } while (ch == 'Y'|| ch == 'y');               
    }

	
}