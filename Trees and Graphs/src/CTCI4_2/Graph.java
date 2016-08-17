package CTCI4_2;

/**
 * Created by Gautam on 8/16/16.
 */
public class Graph
{
    Node vertices[];
    int count;

    //CONS
    public Graph()
    {
        vertices = new Node[6];
        count = 0;
    }

    public void addNode(Node x)
    {
        /*If you have N nodes, there are N - 1 directed edges than can lead from it (going to every other node). Therefore, the maximum number of edges is N * (N - 1)*/
        if(count < 30)
        {
            vertices[count] = x;
            count++;
        }
        else
        {
            System.out.println("GRAPH FULL BRUH");
        }
    }
    /*TO FETCH SOURCE AND DESTINATIONS*/
    public Node[] getNodes()
    {
        return vertices;
    }


}
