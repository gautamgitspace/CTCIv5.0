package CTCI4_4;

import CTCI4_1.TreeNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by Gautam on 8/16/16.
 */
public class LinkedListOfNodes_DFS_REC
{
    private static void createLevelLinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level)
    {
    if (root == null) return;
    LinkedList<TreeNode> list = null;
    if (lists.size() == level)
    {
        System.out.println("ADDING LL TO AL");
        list = new LinkedList<TreeNode>();
        lists.add(list);
    }
    else
    {
        /*FETCH LL FROM AL TO ADD MORE NODES AT THAT LEVEL*/
        System.out.println("RETRIEVING LL FROM AL");
        list = lists.get(level);
    }
    list.add(root);
        System.out.println("ADDED " + root.data + " TO LL");
    createLevelLinkedList(root.left, lists, level + 1);
    createLevelLinkedList(root.right, lists, level + 1);
}

    private static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root)
    {
        ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
        createLevelLinkedList(root, lists, 0);
        return lists;
    }

    public static void printResult(ArrayList<LinkedList<TreeNode>> result)
    {
        int depth = 0;
        for(LinkedList<TreeNode> entry : result)
        {
            Iterator<TreeNode> iterator = entry.listIterator();
            System.out.print("LIST AT DEPTH LEVEL " + "[" + depth + "]: ");
            while(iterator.hasNext())
            {
                System.out.print(" " + ((TreeNode)iterator.next()).data);
            }
            System.out.println();
            depth++;
        }
    }


    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.print();
        ArrayList<LinkedList<TreeNode>> list = createLevelLinkedList(root);
        printResult(list);
    }

}
