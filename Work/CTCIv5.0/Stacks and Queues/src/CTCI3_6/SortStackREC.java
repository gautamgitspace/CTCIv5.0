package CTCI3_6;

import java.util.Stack;

/**
 * Created by Gautam on 8/15/16.
 */
public class SortStackREC
{

    public static Stack<Integer> mergesort(Stack<Integer> inStack) {
        if (inStack.size() <= 1) {
            return inStack;
        }

        Stack<Integer> left = new Stack<Integer>();
        Stack<Integer> right = new Stack<Integer>();
        int count = 0;
        while (!inStack.isEmpty())
        {
            count++;
            if (count % 2 == 0)
            {
                int temp = inStack.pop();
                System.out.println(temp + " PUSHED TO LEFT");
                left.push(temp);
            }
            else
            {
                int temp = inStack.pop();
                System.out.println(temp + " PUSHED TO RIGHT");
                right.push(temp);

            }
        }

        left = mergesort(left);
        right = mergesort(right);

        while (left.size() > 0 || right.size() > 0)
        {
            System.out.println("RIGHT SIZE: " + right.size());
            System.out.println("LEFT SIZE: " + left.size());
            /*IF LEFT GETS EMPTY POP FROM RIGHT INSERT TO ORIGINAL*/
            if (left.size() == 0)
            {
                int temp = right.pop();
                System.out.println(temp + " PUSHED FROM RIGHT TO ORIGINAL");
                inStack.push(temp);
            }
            /*IF RIGHT GETS EMPTY POP FROM LEFT INSERT TO ORIGINAL*/
            else if (right.size() == 0)
            {
                int temp = left.pop();
                System.out.println(temp + " PUSHED FROM LEFT TO ORIGINAL");
                inStack.push(temp);
            }
            else if (right.peek().compareTo(left.peek()) <= 0)
            {
                int temp = left.pop();
                System.out.println(temp + " was bigger and got popped from left");
                inStack.push(temp);
            }
            else
            {
                int temp = right.pop();
                System.out.println(temp + " was smaller and got popped from right");
                inStack.push(temp);
            }
        }
        /*POP FROM ORIGINAL STACK TO NEW STACK(THIS NEW STACK WILL BE SORTED) AND RETURN THIS NEW STACK*/
        Stack<Integer> reverseStack = new Stack<Integer>();
        while (inStack.size() > 0)
        {
            reverseStack.push(inStack.pop());
        }

        return reverseStack;
    }
    private static int randomInt(int n)
    {
        return (int) (Math.random() * n);
    }

    private static int randomIntInRange(int min, int max)
    {
        return randomInt(max + 1 - min) + min;
    }

    public static void main(String [] args)
    {
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < 10; i++)
        {
            int randomPush = randomIntInRange(0, 100);
            stack.push(randomPush);
        }

        stack = mergesort(stack);
        System.out.println("SORTING USING RECURSION O(n^2)");
        for(int j=0; j<10; j++)
        {
            int popped = stack.pop();
            System.out.println("POPPING CHERRY: " + popped);
        }
    }

}
