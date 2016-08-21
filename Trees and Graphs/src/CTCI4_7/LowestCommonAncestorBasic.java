package CTCI4_7;

import CTCI4_1.TreeNode;

/**
 * Created by Gautam on 8/17/16.
 */
public class LowestCommonAncestorBasic
{
    public static TreeNode commonAncestorBad(TreeNode root, TreeNode p, TreeNode q)
    {
        /*BASE CASE*/
        if (root == null)
        {
            return null;
        }
        /*SINGLE NODE TREE*/
        if (root == p && root == q)
        {
            return root;
        }

        TreeNode left = commonAncestorBad(root.left, p, q);
        TreeNode right = commonAncestorBad(root.right, p, q);
        if (left != null && left != p && left != q)
        {
            System.out.println("IN LEFT SUBTREE CASE");
            return left;
        }

        if (right != null && right != p && right != q)
        {
            System.out.println("IN RIGHT SUBTREE CASE");
            return right;
        }

        if (left != null && right != null)
        {
            /*P AND Q ARE IN DIFF SUB TREES*/

            System.out.println("ROOT.DATA: "  + root.data);
            return root;
        }
        else if (root == p || root == q)
        {
            /*RETURN ROOT TO THE PARENT*/
            return root;
        }
        else
        {
            /*FINALLY WHICHEVER IS NOT NULL, THAT WILL BE THE COMMON ANCESTOR*/
            return left == null ? right : left;
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = TreeNode.createMinimalBST(array);
        root.print();
        System.out.println("IN MAIN: " + root.data);
        TreeNode n3 = root.search(1);
        TreeNode n7 = root.search(3);
        TreeNode ancestor = commonAncestorBad(root, n3, n7);
        if (ancestor != null)
        {
            System.out.println("COMMON ANCESTOR IS: " + ancestor.data);
        } else {
            System.out.println("null");
        }
    }
}
