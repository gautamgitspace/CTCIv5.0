package CTCI3_1;
import java.util.EmptyStackException;


/**
 * Created by Gautam on 7/9/16.
 * single array to implement three stacks
 */
public class CTCI3_1
{

    private static int sizeOfStack = 100;
    private static int[] buffer = new int[sizeOfStack*3];
    private static int[] stackPointer = {-1, -1, -1};
    private static void push(int stackNumber, int value)
    {
        //TODO check if we have space to push?
        isFull(stackNumber);
        //TODO increment stack pointer and push
        stackPointer[stackNumber]++;
        buffer[whereInBuffer(stackNumber)]=value;
    }
    private static int pop(int stackNumber)
    {
        //TODO check if stack is empty?
        if(isEmpty(stackNumber))
            throw new EmptyStackException();
        //TODO fetch value and return it, reset index and decrement pointer
        int value = buffer[whereInBuffer(stackNumber)];
        buffer[whereInBuffer(stackNumber)]=0;
        stackPointer[stackNumber]--;
        return value;
    }
    private static int peek(int stackNumber)
    {
        if(isEmpty(stackNumber))
            throw new EmptyStackException();
        return buffer[whereInBuffer(stackNumber)];
    }
    private static boolean isEmpty(int stackNumber)
    {
        //TODO check if stack is empty
        return stackPointer[stackNumber] == -1;
    }
    private static void isFull(int stackNumber)
    {
        try
        {
            if (stackPointer[stackNumber] + 1 > sizeOfStack)
            {
                throw new FullStackException();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    private static int whereInBuffer(int stackNumber)
    {
        return stackNumber * sizeOfStack + stackPointer[stackNumber];
    }
    public static void main(String args[])
    {
        for(int i=0;i<100;i++)
        {
            push(1,i);
        }
        push(2, 4);
        System.out.println("Peek 2: " + peek(2));
        push(0, 3);
        push(0, 7);
        push(0, 5);
        System.out.println("Peek 0: " + peek(0));
        pop(0);
        System.out.println("Peek 0: " + peek(0));
        pop(0);
        System.out.println("Peek 0: " + peek(0));
        System.out.println("Peek 1: " + peek(1));
        System.out.println("Peek 1: " + peek(1));
        //uncomment to raise overflow exception
        //push(1,101);

    }
    private static class FullStackException extends Exception
    {
        private FullStackException()
        {
            super();
        }

        public FullStackException(String message)
        {
            super(message);
        }
    }

}

