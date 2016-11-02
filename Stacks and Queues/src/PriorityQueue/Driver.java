package PriorityQueue;

/**
 * Created by Gautam on 11/2/16.
 */
public class Driver
{
    public static int size = 10;

    public static void main(String args[])
    {
        PriorityQueue priorityQueue = new PriorityQueue(size);
        priorityQueue.insert("VoIP", 5);
        priorityQueue.insert("MPEG", 1);
        priorityQueue.insert("SMTP", 4);
        priorityQueue.insert("ICMP", 2);
        System.out.println("Size of PQ: " + priorityQueue.size());
        Task task = priorityQueue.remove();
        System.out.println("Task using CPU: " + task.toString());
        System.out.println("Task next to get CPU: " + priorityQueue.peak());
    }
}
