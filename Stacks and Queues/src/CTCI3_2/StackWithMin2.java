/**
 * Created by Gautam on 7/14/16.
 */

package CTCI3_2;
import java.util.Stack;

public class StackWithMin2 extends Stack<Integer>
{
    Stack<Integer> s2;

    public StackWithMin2()
    {
        s2 = new Stack<Integer>();
    }

    public void push(int value)
    {
        //compare value with integet.maxvalue, if less (obvious) push it to min stack
        if (value <= min())
        {
            s2.push(value);
            System.out.println("pushed: " + value);
        }
        //irrespective of anything, push it to main stack
        super.push(value);
    }

    public Integer pop()
    {
        //pop irrespective of anything from the main stack
        int value = super.pop();
        //if value lies in min stack, pop it from there too
        if (value == min())
        {
            s2.pop();
        }
        return value;
    }
    //return the top most element always
    public int min()
    {
        if (s2.isEmpty())
            return Integer.MAX_VALUE;
        else
            return s2.peek();
    }
}
