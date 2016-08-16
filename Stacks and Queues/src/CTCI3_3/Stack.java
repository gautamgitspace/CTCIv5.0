package CTCI3_3;

/**
 * Created by Gautam on 7/14/16.
 */
public class Stack
{
    private int capacity;
    public Node top;
    public Node bottom;
    public int size = 0;

    public Stack(int capacity)
    {
        this.capacity = capacity;
    }

    public boolean isFull()
    {
        return capacity == size;
    }

    public void join(Node above, Node below)
    {
        if (below != null) below.above = above;
        if (above != null) above.below = below;
    }

    public boolean push(int v)
    {
        /*check availability before pushing*/
        if (size >= capacity) return false;
        size++;
        Node n = new Node(v);
        /*if this is the only element, bottom = top = n*/
        if (size == 1) bottom = n;
        /*Otherwise, join the new node n to the existing top*/
        join(n, top);
        /*Make the new node the new TOP*/
        top = n;
        return true;
    }

    public int pop()
    {
        Node t = top;
        /*element below the popped element becomes the new TOP*/
        top = top.below;
        /*decrement size of the stack*/
        size--;
        return t.value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int removeBottom()
    {
        Node b = bottom;
        /*Node above the bottom one(that gets removed) becomes the new BOTTOM*/
        bottom = bottom.above;
        System.out.println(bottom.value + " becomes the new bottom");
        if (bottom != null) bottom.below = null;
        size--;
        return b.value;
    }
}
