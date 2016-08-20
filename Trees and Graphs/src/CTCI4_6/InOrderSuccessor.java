package CTCI4_6;

import CTCI4_1.*;


/**
 * Created by Gautam on 8/17/16.
 */
public class InOrderSuccessor
{
    private static TreeNode inOrderSuccessor(TreeNode n)
    {
        if(n==null)
        {

            return null;
        }
        if(n.right!=null)
        {
            /*CASE #1: HAS RIGHT SUB-TREE*/
            return leftMostChild(n.right);
        }
        else
        {
            /*CASE #2: NO RIGHT SUB-TREE*/
            /*WE NEED TO TRAVERSE UPWARDS FROM Q UNTIL WE FIND A NODE X THAT WE HAVE NOT FULLY TRAVERSED*/

            TreeNode q = n;
            TreeNode x = q.parent;

            while(x!=null && x.left!=q)
            {
                q = x;
                x.parent = x;
            }
            return x;
        }
    }

    private static TreeNode leftMostChild(TreeNode x)
    {
        if(x == null)
            return null;
        while(x.left!=null)
        {
            x=x.left;
        }
        return x;
    }

    /* #DRIVER */
   public static void main(String args[])
   {
       int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
       TreeNode root = TreeNode.createMinimalBST(array);
       root.print();

            TreeNode node = root.search(5);


            TreeNode next = inOrderSuccessor(node);
            if (next != null)
            {
                System.out.println(node.data + "->" + next.data);
            }
            else
            {
                System.out.println(node.data + "->" + null);
            }

   }

}
