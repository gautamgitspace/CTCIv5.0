package CTCI4_1;

/**
 * Created by Gautam on 8/16/16.
 */
public class TreeNode
{
    private  TreeNode left;
    private  TreeNode right;
    private  TreeNode parent;
    private  int data;
    private  int size;

    /*DEF CONS*/
    TreeNode(int d)
    {
        data=d;
        size = 0;
    }
    /*SET LEFT CHILD*/
    private  void setLeftChild(TreeNode left)
    {
        this.left=left;
        if(left!=null)
        {
            left.parent=this;
        }
    }
    /*SET RIGHT CHILD*/
    private  void setRightChild(TreeNode right)
    {
        this.right=right;
        if(right!=null)
        {
            right.parent=this;
        }
    }
    /*INSERT ELEMENTS IN ORDER*/
    private  void insert(int d)
    {
        if(d<=data)
        {
            if(left==null)
            {
                setLeftChild(new TreeNode(d));
            }
            else
            {
                left.insert(d);
            }
        }
        else
        {
            if(right==null)
            {
                setRightChild(new TreeNode(d));
            }
            else
            {
                right.insert(d);
            }
        }
        size++;
    }

    /*HEIGHT OF TREE*/
    private int height()
    {
        int leftHeight = left!=null ? left.height() : 0;
        int rightHeight = right!=null ? right.height() : 0;
        return 1+ Math.max(leftHeight, rightHeight);
    }

    /*BST VALIDATOR*/
    private boolean bstValidator()
    {
        if(left!=null)
        {
            if (data < left.data || left.bstValidator())
                return false;
        }
        if(right!=null)
        {
            if (data >= right.data || right.bstValidator())
                return false;
        }
        return true;
    }

    /*SEARCH BST*/
    private TreeNode search(int d)
    {
        if(d==data)
            return this;
        if(d<data)
        {
            return left!=null ? left.search(d) : null;
        }
        else if(d>data)
        {
            return right!=null ? right.search(d) : null;
        }
        return null;
    }

    private int getSize()
    {
        return size;
    }



}
