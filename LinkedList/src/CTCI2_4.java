/**
 * Created by Gautam on 6/3/16.
 * CTCI 2.4 - pivot element sort
 * APPROACH #1 - Before and After
 */

public class CTCI2_4
{
    public static LinkedListNode partition(LinkedListNode node, int x)
    {
        LinkedListNode beforeStart = null;
        LinkedListNode beforeEnd = null;
        LinkedListNode afterStart = null;
        LinkedListNode afterEnd = null;

		/* Partition list */
        while (node != null)
        {
            //Keep storing next
            LinkedListNode next = node.next;
            //keep making next of last node = null
            node.next = null;
            if (node.data < x)
            {
                if (beforeStart == null)
                {
                    beforeStart = node;
                    beforeEnd = beforeStart;
                    System.out.println("ADDED " + node.data + " TO beforeStart");
                }
                else
                {
                    beforeEnd.next = node;
                    beforeEnd = node;
                    System.out.println("ADDED " + node.data + " TO beforeStart");
                }
            }
            else
            {
                if (afterStart == null)
                {
                    afterStart = node;
                    afterEnd = afterStart;
                    System.out.println("ADDED " + node.data + " TO afterStart");
                }
                else
                {
                    afterEnd.next = node;
                    afterEnd = node;
                    System.out.println("ADDED " + node.data + " TO afterStart");
                }
            }
            node = next;
        }

		/* Merge before list and after list */
        if (beforeStart == null)
        {
            return afterStart;
        }

        beforeEnd.next = afterStart;
        return beforeStart;
    }

    public static void main(String[] args)
    {
        int[] values = {25, 10,19, 8, 13};
        System.out.println("GENERATING HEAD. . .");
        LinkedListNode head = new LinkedListNode(values[0], null, null);
        LinkedListNode current = head;
        System.out.println("Head is: " + head.data);

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

