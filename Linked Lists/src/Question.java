/**
 * Created by Gautam on 6/3/16.
 */

public class Question
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
        if (beforeStart == null) {
            return afterStart;
        }

        beforeEnd.next = afterStart;
        return beforeStart;
    }

    public static void main(String[] args)
    {
		/* Create linked list */
        int[] vals = {1, 3, 7, 5, 2, 9, 4};
        LinkedListNode head = new LinkedListNode(vals[0], null, null);
        LinkedListNode current = head;
        System.out.println("Head is: " + head.data);
        System.out.println("Current is: " + current.data);
        for (int i = 1; i < vals.length; i++)
        {
            current = new LinkedListNode(vals[i], null, current);
            System.out.println("current updated to: " + current.data);
        }
        System.out.println("GENERATING LIST. . .");
        System.out.println(head.printForward());
        System.out.println("PARTITIONING LIST. . .");

		/* Partition */
        LinkedListNode h = partition(head,3);

		/* Print Result */
        System.out.println("PARTITIONING RESULT----->");
        System.out.println(h.printForward());
    }

}

