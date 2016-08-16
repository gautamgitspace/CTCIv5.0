package CTCI3_3;

/**
 * Created by Gautam on 7/14/16.
 */
public class testMethod
{
    public static void main(String[] args)
    {
        int capacity_per_substack = 5;
        SetOfStacks set = new SetOfStacks(capacity_per_substack);
        for (int i = 0; i < 34; i++)
        {
            set.push(i);
            System.out.println("Pushed: " + i);
        }

        System.out.println("POPPED " + set.popAt(2));

        for (int i = 0; i < 33; i++) {
            System.out.println("Popped " + set.pop());
        }
        System.out.println(set.stacks);
    }
}
