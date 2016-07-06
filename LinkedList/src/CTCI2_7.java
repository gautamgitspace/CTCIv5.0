import java.util.Stack;

/**
 * Created by Gautam on 7/6/16.
 */
public class CTCI2_7
{
    public static boolean isPalindrome(LinkedListNode head)
    {
        LinkedListNode fast = head;
        LinkedListNode slow = head;

        Stack<Integer> stack = new Stack<>();

        while (fast != null && fast.next != null)
        {
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }

		//BLOCK A
        // When size of list is odd (), skip to the element next to the middle element
        if (fast != null)
        {
            slow = slow.next;
        }

        while (slow != null)
        {
            int top = stack.pop().intValue();
            System.out.println(slow.data + " " + top);
            if (top != slow.data)
            {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }

    public static void main(String[] args)
    {
        //change length to a an odd number to see use of BLOCK A
        int length = 10;
        //create list
        LinkedListNode[] nodes = new LinkedListNode[length];
        for (int i = 0; i < length; i++)
        {
            nodes[i] = new LinkedListNode(i >= length / 2 ? length - i - 1 : i, null, null);
        }

        //set next and previous for each node
        for (int i = 0; i < length; i++)
        {
            if (i < length - 1)
                nodes[i].setNext(nodes[i + 1]);
            if (i > 0)
                nodes[i].setPrevious(nodes[i - 1]);
        }
        //uncomment below to alter palindrome property
        //nodes[length - 2].data = 9;

        LinkedListNode head = nodes[0];
        System.out.println(head.printForward());
        //call to function with head as the argument
        System.out.println(isPalindrome(head));
    }

}
