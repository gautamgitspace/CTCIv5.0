package PriorityQueue;

/**
 * Created by Gautam on 11/2/16.
 */
public class PriorityQueue
{
    private Task[] heap;
    private int heapSize, capacity;

    public PriorityQueue(int capacity)
    {
        this.capacity = capacity + 1;
        heap = new Task[this.capacity];
        heapSize = 0;
    }

    public void clear()
    {
        heap = new Task[capacity];
        heapSize = 0;
    }

    public boolean isEmpty()
    {
        return heapSize == 0;
    }

    public boolean isFull()
    {
        return heapSize == capacity - 1;
    }

    public int size()
    {
        return heapSize;
    }
    /*INSERTION*/
    public void insert(String job, int priority)
    {
        Task newJob = new Task(job, priority);

        heap[++heapSize] = newJob;
        System.out.println("task INSERTED in the ready queue at: " + heapSize + " with priority: " + priority);
        int pos = heapSize;
        System.out.println("POS: " + pos);
        while (pos != 1 && newJob.priority > heap[pos/2].priority)
        {
            heap[pos] = heap[pos/2];
            pos /=2;
        }
        heap[pos] = newJob;
        System.out.println("task UPDATED in the ready queue at: [" + pos + "] with priority: " + priority);

    }

    /*DELETION*/
    public Task remove()
    {
        int parent, child;
        Task item, temp;
        if (isEmpty() )
        {
            System.out.println("Queue is empty");
            return null;
        }

        item = heap[1];
        temp = heap[heapSize--];

        parent = 1;
        child = 2;
        while (child <= heapSize)
        {
            if (child < heapSize && heap[child].priority < heap[child + 1].priority)
                child++;
            if (temp.priority >= heap[child].priority)
                break;

            /*TASK WITH NEXT HIGHER PRIORITY MOVED TO HEAP[1]*/
            heap[parent] = heap[child];
            parent = child;
            child *= 2;
        }
        heap[parent] = temp;

        return item;
    }

    /*PEAK*/
    public Task peak()
    {
        return heap[1];
    }

}
