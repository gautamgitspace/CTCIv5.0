package CTCI4_4;

import CTCI4_1.TreeNode;
import com.apple.eawt.AppEvent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by Gautam on 8/17/16.
 */
public class LinkedListOfNodes_BFS_ITR
{
    public static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root)
    {
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();

        LinkedList<TreeNode> current = new LinkedList<TreeNode>();
        /* "Visit" the root */
        if (root != null)
        {
            current.add(root);
        }

        while (current.size() > 0)
        {
            result.add(current);
            System.out.println("CURRENT ADDED TO RESULT");
            /*GO TO NEXT LEVEL OF DEPTH*/
            LinkedList<TreeNode> parents = current;
            for(int i = 0; i < parents.size(); i++) {
                System.out.println("NEW PARENT(S) ARE: " + parents.get(i).data);
            }
            current = new LinkedList<TreeNode>();
            for (TreeNode parent : parents)
            {
				/* Visit the children */
                if (parent.left != null)
                {
                    current.add(parent.left);
                    System.out.println("ADDED LEFT TO CURRENT");
                }
                if (parent.right != null)
                {
                    current.add(parent.right);
                    System.out.println("ADDED RIGHT TO CURRENT");
                }
            }
        }

        return result;
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
        ArrayList<LinkedList<TreeNode>> list = createLevelLinkedList(root);
        printResult(list);
    }
}
