/**
 * Created by Gautam on 7/3/16.
 */
public class CTCI2_6
{
    private static LinkedListNode FindBeginning(LinkedListNode head)
    {
        LinkedListNode slow = head;
        LinkedListNode fast = head;

        while (fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
            {
                System.out.println("HERE WE MEET");
                break;
            }
        }

        // Error check - there is no meeting point, and therefore no loop
        if (fast == null || fast.next == null)
        {
            return null;
        }

        slow = head;
        while (slow != fast)
        {
            slow = slow.next;
            fast = fast.next;
        }

        // At this point slow=fast=starting of the loop
        return fast;
    }

   
}
