/**
 * Created by Gautam on 8/15/16.
 * SORTING USING ONE ADDITIONAL STACK. Runtime - O(n^2)
 */
package CTCI3_6;

import java.util.Stack;


public class SortStackASC
{

    private static Stack<Integer> sort(Stack<Integer> toBeSorted)
    {
        Stack<Integer> alreadySorted = new Stack<Integer>();
        while (!toBeSorted.isEmpty())
        {
            int tmp = toBeSorted.pop();
            while (!alreadySorted.isEmpty() && alreadySorted.peek() > tmp)
            {
                toBeSorted.push(alreadySorted.pop());
            }
            alreadySorted.push(tmp);
        }
        return alreadySorted;
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

        stack = sort(stack);

        System.out.println("SORTING USING ONE ADDITIONAL STACK O(n^2)");
        for(int j=0; j<10; j++)
        {
            int popped = stack.pop();
            System.out.println("POPPING CHERRY: " + popped);
        }

    }
}
