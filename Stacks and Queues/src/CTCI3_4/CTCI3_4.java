package CTCI3_4;

import java.util.Stack;

/**
 * Created by Gautam on 8/14/16.
 */
public class CTCI3_4
{
    private Stack<Integer> disks;
    private int index;

    /*CONSTRUCTOR*/
    CTCI3_4(int i)
    {
        disks = new Stack<>();
        index=i;
    }

    /*ADD DISK METHOD*/
    public void add(int newDisk)
    {
        if(!disks.isEmpty() && disks.peek()<=newDisk)
            System.out.println("RULE VIOLATION!");
        else
            disks.push(newDisk);
    }

    int getIndex()
    {
        return index;
    }

    /*MOVE TOP METHOD*/
    public void moveTop(CTCI3_4 tower)
    {
        int top = disks.pop();
        tower.add(top);
        System.out.println("Move disk " + top + " from " + getIndex() + " to " + tower.getIndex());
    }

    /*MOVE DISKS METHOD*/
    public void moveDisks(int n, CTCI3_4 destination, CTCI3_4 buffer)
    {
        /*n is the number of hanoi disks you want to play the game with*/
        if(n>0)
        {
            moveDisks(n-1, buffer, destination);
            moveTop(destination);
            buffer.moveDisks(n-1, destination, this);
        }
    }


    /*DRIVER*/
    public static void main(String args[])
    {
        int n = 3;
        CTCI3_4[] towers = new CTCI3_4[n];
        for(int i=0; i<3; i++)
        {
            towers[i] = new CTCI3_4(i);
        }
        for(int i=n-1; i>=0; i--)
        {
            towers[0].add(i);
        }
        /*PARAMS - NO. OF DISKS, DEST, BUFFER*/
        towers[0].moveDisks(n,towers[2], towers[1]);
    }
}

