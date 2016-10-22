package CTCI4_9;

import CTCI4_1.TreeNode;
import java.util.ArrayList;

/**
 * Created by Gautam on 10/18/16.
 */
public class TreePathSum
{
    public static void findPathWithSum(int level, int sum, TreeNode root, int[] path)
    {
        if(root == null)
        {
            return;
        }
        path[level] = root.data;
        int checksum = 0;

        for(int i = level; i>=0; i--)
        {
            checksum += path[i];
            if(checksum == sum)
            {
                print(i, level, path);
            }
        }
        findPathWithSum(level+1, sum, root.left, path);
        findPathWithSum(level+1, sum, root.right, path);
    }

    public  static void print(int start, int end, int[] path)
    {
        for(int i = start; i<=end; i++)
        {
            System.out.print(path[i] + " ");
        }
        System.out.println();
    }

    public static int depth(TreeNode node)
    {
        if(node == null)
        {
            return 0;
        }
        else
        {
            return 1 + Math.max(depth(node.left), depth(node.right));
        }
    }
    public static void findSum(TreeNode node, int sum)
    {
        int depth = depth(node);
        int[] path = new int[depth];
        findPathWithSum(0, sum, node, path);
    }

    public static void main(String args[])
    {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(1);
        treeNode.left.left = new TreeNode(2);
        treeNode.left.right = new TreeNode(8);
        treeNode.right.left = new TreeNode(2);
        treeNode.right.right = new TreeNode(6);
        findSum(treeNode, 8);
    }
}
