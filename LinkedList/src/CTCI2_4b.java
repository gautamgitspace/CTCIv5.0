/**
 * Created by Gautam on 7/2/16.
 * CTCI 2.4b - pivot element sort
 * APPROACH #2 - Head and Tail
 */
public class CTCI2_4b
{
    private static LinkedListNode partition(LinkedListNode node, int x)
    {
        LinkedListNode head = node;
        LinkedListNode tail = node;

        while (node != null)
        {
            LinkedListNode next = node.next;
            if (node.data < x)
            {
                node.next = head; //keep adding on to the left of the head
                head = node;
                System.out.println("HEAD IS: " + head.data);
            }
            else
            {
                tail.next = node; //keep adding on to the right of the tail
                tail = node;
                System.out.println("TAIL IS: " + tail.data);
            }
            node = next;
        }
        tail.next = null;

        return head;
    }

    public static void main(String[] args)
    {
        int[] values = {25, 10, 19, 8, 12, 13};
        System.out.println("GENERATING HEAD. . .");
        LinkedListNode head = new LinkedListNode(values[0], null, null);
        LinkedListNode current = head;
        System.out.println("Head is: " + head.data);
        System.out.println("current is: " + current.data);
        System.out.println("GENERATING LIST. . .");
        for (int i = 1; i < values.length; i++)
        {
            current = new LinkedListNode(values[i], null, current);
            System.out.println("current updated to: " + current.data);
        }

        System.out.println(head.printForward());
        System.out.println("PARTITIONING LIST. . .");

        LinkedListNode h = partition(head,13);

        System.out.println("PARTITIONING RESULT----->");
        System.out.println(h.printForward());
    }
}
