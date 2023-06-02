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
import java.util.LinkedList;
import java.util.List;


 public class Vertex implements Comparable<Vertex> {

    //vertex label
    char label;
    //position value               
    public int position;
    //visited flag
    public boolean isVisited;
    // we use the following valraible for Dijkstra's algorithm
    //distance value               
    public int distance;
    //parent of this vartex
    Vertex parent;

    LinkedList <Edge> adjList;

    //constractor
    protected Vertex(char label) {
        this.label = label;
        this.isVisited = false;
        this.position = 0;
        this.distance = Integer.MAX_VALUE;
        this.parent = null;
    }

    //constractor for default vertex.
    Vertex() {
        this.label = '0';
        this.isVisited = false;
        this.position = 0;
        this.distance = Integer.MAX_VALUE;
        this.parent = null;
    }

    // get position of the current vertex.
    /*
     *  v list of all vertices.
     */
    public int getVertPos(List<Vertex> v) {
        return position;
    }

    // get label of the current vertex.
    public char getLabel() {
        return this.label;
    }

    // Overriden compareTo method
    @Override
    public int compareTo(Vertex o) {
        return (int) (this.distance - o.distance);
    }


    // Overriden toString method
    @Override
    public String toString() {
        return "loc."+ this.label+":city " + this.distance;
    }

    public void displayinfo(){

    }



}
