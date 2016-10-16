package CTCI4_2;

/**
 * Created by Gautam on 8/16/16.
 */
public class Node
{
    Node adjacenyList[];
    String vertex;
    int adjacentNodeCount;
    Driver.State state;

    /*ADJACENT LENGTH IS THE NEIGHBORING NODE COUNT*/
    /*A NEW NODE WHEN FORMED, TELLS IT'S NAME AND THE NUMBER OF NEIGHBORS IT WILL HAVE*/

    //DEF CONS
    public Node(String vertex, int adjacentLength)
    {
        this.vertex=vertex;
        adjacenyList = new Node[adjacentLength];
        adjacentNodeCount = 0;
    }

    public void addAdjacent(Node x)
    {
        /*If you have N nodes, there are N - 1 directed edges than can lead from it (going to every other node). Therefore, the maximum number of edges is N * (N - 1)*/
        if (adjacentNodeCount < 30)
        {
            adjacenyList[adjacentNodeCount] = x;
            adjacentNodeCount++;
        }
        else
        {
            System.out.println("NO MORE ADDITION POSSIBLE");
        }
    }

    public Node[] getAdjacencyList()
    {
        return adjacenyList;
    }

    public String getVertexName()
    {
        return vertex;
    }



}
