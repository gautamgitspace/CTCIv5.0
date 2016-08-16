package CTCI3_5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import static javafx.scene.input.KeyCode.T;

/**
 * Created by Gautam on 8/15/16.
 */
public class MyQueue
{
<<<<<<< HEAD
    /*STACK TO WHICH WE PUSH THE NEW INCOMING ELEMENTS*/
    Stack<Integer> inbox;
    /*STACK FROM WHICH WE POP OR DEQUEUE*/
=======
    Stack<Integer> inbox;
>>>>>>> c2c7015f4831910c5fe7206af3ae73efc1f4cbd9
    Stack<Integer> outbox;

    MyQueue()
    {
        System.out.println("DEF CONS");
        inbox = new Stack<Integer>();
        outbox= new Stack<Integer>();
    }
    /*GET SIZE METHOD*/
    public Integer size()
    {
        return inbox.size() + outbox.size();
    }
    /*PEEK METHOD*/
    public Integer peek()
    {
        shiftStacks();
        return outbox.peek();
    }

    /*DEQUEUE METHOD*/
    public Integer dequeue()
    {
        shiftStacks();
        return outbox.pop();
    }
    /*ENQUEUE METHOD*/
<<<<<<< HEAD
    public void addToInbox(Integer value)
=======
    public void add(Integer value)
>>>>>>> c2c7015f4831910c5fe7206af3ae73efc1f4cbd9
    {
        inbox.push(value);
    }

    /*SHIFT STACKS LOGIC*/
    private void shiftStacks()
    {
        if(outbox.isEmpty())
        {
            while(!inbox.isEmpty())
            {
                outbox.push(inbox.pop());
            }
        }
    }
<<<<<<< HEAD
=======

    /* #DRIVER# */

>>>>>>> c2c7015f4831910c5fe7206af3ae73efc1f4cbd9
}
