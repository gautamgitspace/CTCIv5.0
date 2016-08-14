package CTCI3_3;

import java.util.ArrayList;

/**
 * Created by Gautam on 7/14/16.
 */
public class SetOfStacks
{
    ArrayList<Stack> stacks = new ArrayList<Stack>();
    public int capacity;

    public SetOfStacks(int capacity)
    {
        this.capacity = capacity;
    }

    //returns the index of stack
    public Stack getLastStack()
    {
        if (stacks.size() == 0)
            return null;
        return stacks.get(stacks.size() - 1);
    }

    public void push(int v)
    {
        Stack last = getLastStack();
        if (last != null && !last.isFull())
        { //add to last
            last.push(v);
        }
        else
        { //create new stack, push element to it, add stack to Arraylist
            Stack stack = new Stack(capacity);
            stack.push(v);
            stacks.add(stack);  //add stack to stacks. This is the only time when size of stacks increases.
        }
    }

    public int pop()
    {
        Stack last = getLastStack();
        int v = last.pop();
        if (last.size == 0)
        {
            stacks.remove(stacks.size() - 1);
        }
        return v;
    }

    public int popAt(int index)
    {
        return leftShift(index, true);
    }

    //important pseudocode
    public int leftShift(int index, boolean removeTop)
    {
        /*Fetch the stack at that index*/
        Stack stack = stacks.get(index);
        int removed_item;
        if (removeTop)
        {
            /*will be always true for the first time*/
            removed_item = stack.pop();
            System.out.println("=========================>HERE");
            System.out.println("removed_item: " + removed_item + " at top of index " + index);
        }
        else
        {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~>HERE");
            removed_item = stack.removeBottom();
            System.out.println("removed item: " + removed_item + " from bottom");
        }
        if (stack.isEmpty())
        {
            /*Remove the stack from the ArrayList if its completely empty after suffering from left shifts*/
            stacks.remove(index);
        }
        /*Keep on shifting un till the length of the ArrayList*/
        else if (stacks.size() > index + 1)
        {
            System.out.println("comparing size of arraylist: " + stacks.size()+ " with index: " + index);
            /*Recursively call leftShift*/
            int v = leftShift(index + 1, false);
            System.out.println("pushing: " + v + " to top of index: " + index);
            stack.push(v);
        }
        /*returns what pop() had to return*/
        return removed_item;
    }

}
