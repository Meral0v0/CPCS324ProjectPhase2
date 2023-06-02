/*
 * Leader: Meral Abdulkareem(2105036) B8
 * Wajd Al-Qahtani(2105344) B8 
 * Lama Al-Shehri(2105655) B0B
 * Reema Bahamdain(2009525) CP1
 * 
 * Subject: CPCS-324
 * Project: Phase 2
 * Constructor:
 * Dr. أسماء الشنقيطي 
 * Dr. سيدرا قريشي
 * Resourses: 
 * https://poe.com/s/jCFYGnSnXzegq5DzzglP
 * https://poe.com/s/LrVvYeXKQw3zkcY6KWm7
 * https://www.youtube.com/watch?v=XB4MIexjvY0
 */

package GraphFramework;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;

// SingleSourceSPAlg is the child of ShortestPathAlgorithm
public class SingleSourceSPAlg extends ShortestPathAlgorithm {

    //source vertex
    Vertex source;
    //Priority queue to queue vertices w.r.t least distance(distance).
    PriorityQueue<Vertex> vertexQueue = new PriorityQueue<>();
    //list to store results(shortest paths)
    List<String> resultsList;

    //constractor
    /**
     * chosen source
     */
    public SingleSourceSPAlg(Graph graph ,Vertex source) {
        this.source = source;
        this.graph= graph;
        resultsList = new ArrayList<>();
    }

    // Implementing Dijkstra algorithm
    public void computeDijkstraAlg() {
        //start time
        long StartTime = System.nanoTime();
        //Starting vertex distance should be 0
        source.distance = 0;
        //add source vertex to the queue
        vertexQueue.add(source);
        //run until queue is not empty
        while (!vertexQueue.isEmpty()) {
            //Get vertex from the top of queue 
            //i.e. vertex with least distance   
            Vertex actualVertex = vertexQueue.peek();
            //get adjacent vertices through connected edges from adjMatrix
            int weight;
            Vertex u;
            for (int i = 0; i < graph.adjMatrix.length; i++) {
                if (graph.adjMatrix[actualVertex.position][i].weight == 99999
                        || graph.adjMatrix[actualVertex.position][i].weight == 0) {
                    continue; //Skip the iteration
                }
                u = graph.vertices[i];
                weight = graph.adjMatrix[actualVertex.position][i].weight;
                if (!u.isVisited) {
                    //Apply Dijkstra formula 
                    if (actualVertex.distance + weight < u.distance) {
                        u.distance = actualVertex.distance + weight;
                        //also update its parent 
                        u.parent = actualVertex;
                        vertexQueue.add(u);
                    }
                }//end if
            }//end for
            //remove vertex from queue
            vertexQueue.poll();
            //mark vertex as visited                  
            actualVertex.isVisited = true;
        }//end while
        //finish time of the algorithm
        long FinishTime = System.nanoTime();
        //print the total time consumed by the algorithm
        System.out.println("\ntaken time (Dijkstra algorithm): " + (FinishTime - StartTime) + "ns (" + TimeUnit.NANOSECONDS.toMillis(FinishTime - StartTime) + "ms)\n");
    }//end computeDijkstraAlg

    //Function to return the shortest path
    List<Vertex> shortestPath(Vertex v) {
        //list to hold path
        List<Vertex> shortPath = new ArrayList<>();
        //Trace route from the 'v' to the source vertex
        shortPath.add(v);
        while (v.parent != null) {
            shortPath.add(v.parent);
            v = v.parent;
        }
        //reverse the list to correct the order
        Collections.reverse(shortPath);

        //return list
       // displayShortestPath(graph);
        return shortPath;
    }

    //display shortest path for given graph in parameter.
    public void displayShortestPath(Graph g , int userSource) {
        //print results:
        List<Vertex> path;
        System.out.println();
       
        resultsList.add("The starting point location is  " + g.vertices[userSource].getLabel());
        System.out.println("The starting point location is  " + g.vertices[userSource].getLabel());
        System.out.println("\nThe routes from location  " + g.vertices[userSource].getLabel() + " to the rest of the locations are:");
        System.out.println();
        for (int i = 0; i < g.getVerticesNo(); i++) {
            // print all paths
            path = shortestPath(g.vertices[i]);
            resultsList.add(String.format("Shortest Paths from location %s to location %s :", g.vertices[userSource].getLabel(), g.vertices[i].getLabel()));
            System.out.println(String.format("Shortest Paths from location %s to location %s :", g.vertices[userSource].getLabel(), g.vertices[i].getLabel()));
            resultsList.add(path.toString());
            System.out.println(path);
            resultsList.add("--- route length: " + g.vertices[i].distance);
            System.out.println("--- route length: " + g.vertices[i].distance);
            if (i != g.getVerticesNo() - 1) {
                resultsList.add("------------------------------------------------------------");
                System.out.println("------------------------------------------------------------");
            }
        }
    }

    

}

    


