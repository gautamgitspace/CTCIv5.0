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

		//When size of list is odd (), skip to the element next to the middle element
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

}
