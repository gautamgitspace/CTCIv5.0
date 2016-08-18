package CTCI4_3;

import CTCI4_1.TreeNode;

/**
 * Created by Gautam on 8/16/16.
 */
public class MinimalBST
{
    public static TreeNode createMinimalBST(int array[], int start, int end)
    {
        if(end < start)
            return null;
        int mid = (start + end)/2;
        /*CREATE MAIN CENTRAL NODE*/
        TreeNode node = new TreeNode(array[mid]);
        /*SET LEFT CHILDREN*/
        node.setLeftChild(createMinimalBST(array, start, mid-1));
        /*SET RIGHT CHILDREN*/
        node.setRightChild(createMinimalBST(array, mid+1, end));
        return node;
    }
    public static void main(String[] args)
    {
        // Create balanced tree
        int[] array = {0, 1, 2, 3, 5, 6, 7, 8, 9, 10};
        TreeNode root = TreeNode.createMinimalBST(array);
        root.print();
    }
}
