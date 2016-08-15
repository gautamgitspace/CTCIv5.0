package CTCI3_5;

import java.util.Stack;

/**
 * Created by Gautam on 8/15/16.
 */
public class MyQueue<T>
{
    Stack<T> inbox;
    Stack<T> outbox;

    MyQueue()
    {
        inbox = new Stack<T>();
        outbox= new Stack<T>();
    }
    /*PEEK METHOD*/
    public T peek()
    {
        shiftStacks();
        return outbox.peek();
    }

    /*DEQUEUE METHOD*/
    public T dequeue()
    {
        shiftStacks();
        return outbox.pop();
    }
    /*ENQUEUE METHOD*/
    public void add(T value)
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
}
