package CTCI4_2;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

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

        Node a = new Node("a", 2);
        Node b = new Node("b", 1);
        Node c = new Node("c", 0);
        Node d = new Node("d", 1);
        Node e = new Node("e", 1);
        Node f = new Node("f", 0);

        /*ADD NODES TO ADJACENCY LIST I.E. FORM THE GRAPH*/

        a.addAdjacent(b);
        a.addAdjacent(c);
        b.addAdjacent(d);
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
        /*CHOOSE SOURCE AND DEST*/
        Node source = fetch[0];
        Node destination = fetch[5];

        System.out.println("PATH FROM: " + source.getVertexName() + " TO: " + destination.getVertexName() + " EXISTS? =>");
        /*CALL TO SEARCH FUNCTION*/
        System.out.println(search(graph, source, destination));
        System.out.println(hasCycle(graph));

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
        /*MARK SOURCE AS VISITING AND ADD IT TO Q*/
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

    public static boolean hasCycle(Graph g)
    {
        Set<Node> white = new HashSet<>();
        Set<Node> black = new HashSet<>();
        Set<Node> gray = new HashSet<>();

        for(Node v : g.getNodes())
        {
            /*ADD ALL TO WHITE*/
            white.add(v);
        }
        while(white.size() > 0)
        {
            /*KEEP FETCHING FROM WHITE AND TESTING*/
            Node toTest = white.iterator().next();
            if(dfs(toTest, white, gray, black))
            {
                return true;
            }
        }
        return false;
    }

    public static  boolean dfs(Node toTest, Set<Node> whiteSet, Set<Node> blackSet, Set<Node> graySet)
    {
        /*MOVE FROM WHITE TO GRAY AND EXPLORE IT*/
        moveNode(toTest, whiteSet, graySet);
        for(Node ne : toTest.getAdjacencyList())
        {
            if(blackSet.contains(ne))
            {
                continue;
            }
            if(graySet.contains(ne))
            {
                return true;
            }
            if(dfs(ne, whiteSet, blackSet, graySet))
            {
                return true;
            }
        }
        /*MOVE TO BLACK WHEN EXPLORED*/
        moveNode(toTest, graySet, blackSet);
        return false;
    }

    public static void moveNode(Node toMove, Set<Node> moveFrom, Set<Node> moveTo)
    {
        moveFrom.remove(toMove);
        moveTo.add(toMove);
    }
}
