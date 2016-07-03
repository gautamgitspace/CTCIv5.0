
/**
 * Created by Gautam on 6/12/16.
 * Add contents of two lists and return the sum in a resultant list. The digits are stored in the same order.
 */
public class CTCI2_5b
{
    private static class PartialSum
    {
        public LinkedListNode sum = null;
        public int carry = 0;
    }
    static int i=0;
    //Recursive function to calculate the length of the list
    private static int length(LinkedListNode l)
    {

        if (l == null)
        {
            return 0;
        }
        else
        {
            i=i+1;
            System.out.println("Called " + i + " times");
            return 1 + length(l.next);

        }
    }

    //Recursive function to add lists
    private static PartialSum addListsHelper(LinkedListNode l1, LinkedListNode l2)
    {
        if (l1 == null && l2 == null)
        {
            PartialSum sum = new PartialSum();
            return sum;
        }
        //add digits *RECURSIVELY*
        PartialSum sum = addListsHelper(l1.next, l2.next);

        //add carry to current data
        int val = sum.carry + l1.data + l2.data;

        //insert sum of current digits (args - node sum and value sum)
        LinkedListNode full_result = insertBefore(sum.sum, val % 10);

        //return sum(obj) with the sum so far and the carry value
        sum.sum = full_result;
        sum.carry = val / 10; //will be zero OR one as datatype is integer
        return sum;
    }

    private static LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2)
    {
        int len1 = length(l1);
        int len2 = length(l2);
        System.out.println("len1 is: " + len1 + " len2 is: " + len2);
        if (len1 < len2)
        {
            l1 = padList(l1, len2 - len1);
        }
        else
        {
            l2 = padList(l2, len1 - len2);
        }

        //*MAIN CALL TO ADD LISTS*
        PartialSum sum = addListsHelper(l1, l2);
        //if there was a carry value left over, insert this at the front of the list. Otherwise, just return the linked list.
        if (sum.carry == 0)
        {
            //otherwise case
            System.out.println("otherwise case");
            return sum.sum;
        }
        else
        {
            //insert carry at the front of the list case
            System.out.println("insert carry at the front of the list case case");
            LinkedListNode result = insertBefore(sum.sum, sum.carry);
            return result;
        }
    }

    //function to pad the list with zeroes
    private static LinkedListNode padList(LinkedListNode l, int padding)
    {

        LinkedListNode head = l;
        //for loop runs equal to the number of zeroes needed for padding
        for (int i = 0; i < padding; i++)
        {
            LinkedListNode n = new LinkedListNode(0, null, null);
            head.prev = n;
            n.next = head;
            head = n;
        }
        return head;
    }

    //function to insert node in the front of a linked list
    private static LinkedListNode insertBefore(LinkedListNode list, int data)
    {
        LinkedListNode node = new LinkedListNode(data, null, null);
        if (list != null)
        {
            list.prev = node;
            node.next = list;
        }
        System.out.println("printing node: " + node.data);
        return node;

    }

    //For Fine Output Printing
    public static int linkedListToInt(LinkedListNode node)
    {
        int value = 0;
        while (node != null)
        {
            value = value * 10 + node.data;
            System.out.println("VALUE BECOMES: " + value);
            node = node.next;
        }
        return value;
    }

    public static void main(String[] args)
    {
        LinkedListNode lA1 = new LinkedListNode(1, null, null);
        LinkedListNode lA2 = new LinkedListNode(2, null, lA1);
        LinkedListNode lA3 = new LinkedListNode(3, null, lA2);
        LinkedListNode lA4 = new LinkedListNode(4, null, lA3);

        LinkedListNode lB1 = new LinkedListNode(9, null, null);
        LinkedListNode lB2 = new LinkedListNode(8, null, lB1);
        LinkedListNode lB3 = new LinkedListNode(6, null, lB2);
        LinkedListNode lB4 = new LinkedListNode(7, null, lB3);

        //call to addLists
        LinkedListNode list3 = addLists(lA1, lB1);

        System.out.println("  " + lA1.printForward());
        System.out.println("+ " + lB1.printForward());
        System.out.println("= " + list3.printForward());

        int l1 = linkedListToInt(lA1);
        int l2 = linkedListToInt(lB1);
        int l3 = linkedListToInt(list3);

        System.out.print(l1 + " + " + l2 + " = " + l3 + "\n");
        System.out.print(l1 + " + " + l2 + " = " + (l1 + l2));
    }

}
