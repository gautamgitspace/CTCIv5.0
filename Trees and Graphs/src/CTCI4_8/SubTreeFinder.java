package CTCI4_8;

import CTCI4_1.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gautam on 8/17/16.
 */
public class SubTreeFinder
{
    public static boolean containsTree(TreeNode t1, TreeNode t2)
    {
        /*EMPTY TREE IS SUBTREE OF ALL*/
        if (t2 == null)
            return true;
        else
            return subTree(t1, t2);
    }
    public static boolean subTree(TreeNode r1, TreeNode r2)
    {
        /*IF BIG TREE IS EMPTY, THERE IS NOTHING TO LOOKUP*/
        if (r1 == null)
            return false;
        /*IF NODES MATCH, MATCH DOWN FURTHER*/
        if (r1.data == r2.data)
        {
            if (matchTree(r1,r2)) return true;
        }
        /*IF NODES NOT MATCH, LOOK FURTHER DOWN ON TO THE LEFT AND RIGHT PART OF THE BIG TREE*/
        return (subTree(r1.left, r2) || subTree(r1.right, r2));
    }

    public static boolean matchTree(TreeNode r1, TreeNode r2)
    {
        /*IF BOTH ARE EMPTY*/
        if (r2 == null && r1 == null)
            return true;
        /*IF ONE BUT NOT BOTH ARE EMPTY*/
        if (r1 == null || r2 == null)
            return false;
        /*DATA DOES NOT MATCH DONT LOOK FURTHER*/
        if (r1.data != r2.data)
            return false;
        /*ACTUAL NODE MATCHING - DEEP MATCHING*/
        return (matchTree(r1.left, r2.left) &&
                matchTree(r1.right, r2.right));
    }

    public static TreeNode createTreeFromArray(int[] array)
    {
        if (array.length > 0)
        {
            TreeNode root = new TreeNode(array[0]);
            java.util.Queue<TreeNode> queue = new java.util.LinkedList<TreeNode>();
            queue.add(root);
            boolean done = false;
            int i = 1;
            while (!done) {
                TreeNode r = (TreeNode) queue.element();
                if (r.left == null) {
                    r.left = new TreeNode(array[i]);
                    i++;
                    queue.add(r.left);
                } else if (r.right == null) {
                    r.right = new TreeNode(array[i]);
                    i++;
                    queue.add(r.right);
                } else {
                    queue.remove();
                }
                if (i == array.length)
                    done = true;
            }
            return root;
        }
        else
        {
            return null;
        }
    }

    public static void main(String[] args)
    {
        // t2 is a subtree of t1
        int[] array1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        int[] array2 = {2, 4, 5, 8, 9, 10, 11};

        TreeNode t1 = new TreeNode(1);
        t1.setLeftChild(new TreeNode(2));
        t1.setRightChild(new TreeNode(3));
        t1.left.setLeftChild(new TreeNode(4));
        t1.left.setRightChild(new TreeNode(5));
        t1.left.left.setLeftChild(new TreeNode(8));
        t1.left.left.setRightChild(new TreeNode(9));
        t1.left.right.setLeftChild(new TreeNode(10));
        t1.left.right.setRightChild(new TreeNode(11));
        t1.right.setLeftChild(new TreeNode(6));
        t1.right.setRightChild(new TreeNode(7));
        t1.right.left.setLeftChild(new TreeNode(12));
        t1.right.left.setRightChild(new TreeNode(13));

        TreeNode t2 = createTreeFromArray(array2);

        t1.print();
        t2.print();

        if (containsTree(t1, t2))
            System.out.println("t2 is a subtree of t1");
        else
            System.out.println("t2 is not a subtree of t1");

        // t4 is not a subtree of t3
        int[] array3 = {1, 2, 3};
        TreeNode t3 = createTreeFromArray(array1);
        TreeNode t4 = createTreeFromArray(array3);

        t3.print();
        t4.print();

        if (containsTree(t3, t4))
            System.out.println("t4 is a subtree of t3");
        else
            System.out.println("t4 is not a subtree of t3");
    }

}
