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



// DBAllSourseSPAlg is the child of ShortestPathAlgorithm
public class DBAllSourseSPAlg extends ShortestPathAlgorithm {

    
    //Constructors 
     
    public DBAllSourseSPAlg(Graph g , Vertex source , int userSource){
        // create an object of SingleSourceSPAlg to be able to call computeDijkstraAlg() method
        SingleSourceSPAlg current = new SingleSourceSPAlg(g,g.vertices[userSource]);  

        // invoke computeDijkstraBasedAlg() method
        computeDijkstraBasedAlg ( current , g, source , userSource);

    }

    public DBAllSourseSPAlg(Graph g){
       

    }

    public void computeDijkstraBasedAlg(SingleSourceSPAlg current , Graph g , Vertex source , int userSource){
          
        // invoke computeDijkstraAlg() mehtod
        current.computeDijkstraAlg();
        // invoke displayShortestPath() method
        current.displayShortestPath(g , userSource);


    }



}//end class


   











