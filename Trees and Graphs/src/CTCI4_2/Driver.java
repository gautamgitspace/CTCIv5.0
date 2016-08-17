package CTCI4_2;

import java.util.LinkedList;

/**
 * Created by Gautam on 8/16/16.
 */
public class Driver
{
    public enum State
    {
        Unvisited, Visiting, Visited;
    }

    public static void main(String args[])
    {
        /*STEP 1: CREATE NODES*/

        Node a = new Node("a", 3);
        Node b = new Node("b", 0);
        Node c = new Node("c", 0);
        Node d = new Node("d", 1);
        Node e = new Node("e", 1);
        Node f = new Node("f", 0);

        /*ADD NODES TO ADJACENCY LIST I.E. FORM THE GRAPH*/
        a.addAdjacent(a);
        a.addAdjacent(b);
        a.addAdjacent(c);
        d.addAdjacent(e);
        e.addAdjacent(f);

        /*ADD NODES TO THE GRAPH*/
        Graph graph = new Graph();

        graph.addNode(a);
        graph.addNode(b);
        graph.addNode(c);
        graph.addNode(d);
        graph.addNode(e);
        graph.addNode(f);

        /*FETCH NODES TO DECIDE SOURCE AND DESTINATION*/
        Node fetch[] = graph.getNodes();
        Node source = fetch[3];
        Node destination = fetch[5];

        System.out.println("PATH FROM: " + source.getVertexName() + " TO: " + destination.getVertexName() + " EXISTS? =>");
        /*CALL TO SEARCH FUNCTION*/
        System.out.println(search(graph, source, destination));

    }

    /*BFS*/
    public static boolean search(Graph g, Node s, Node d)
    {
        if(s == d)
            return true;
        LinkedList<Node> q = new LinkedList<Node>();
        /*MARK EACH AS UNVISITED TO START WTIH*/
        for(Node u: g.getNodes())
        {
            u.state = State.Unvisited;
        }
        /*MARK START AS VISITING AND ADD IT TO Q*/
        s.state = State.Visiting;
        q.add(s);
        Node next;
        while(!q.isEmpty())
        {
            next = q.removeFirst();
            if(next!=null)
            {
                for(Node v: next.getAdjacencyList())
                {
                    if(v.state==State.Unvisited)
                    {
                        if(v == d)
                        {
                            return true;
                        }
                        else
                        {
                            v.state=State.Visiting;
                            q.add(v);
                            //System.out.println("ADDED " + v.getVertexName() + " TO Q");
                        }
                    }
                }
                next.state = State.Visited;
            }
        }
        return false;
    }

}
