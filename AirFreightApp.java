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

package AirFreightApp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import GraphFramework.*;
// The main class
public class AirFreightApp {

    // create a static scanner to be able to read even out of the scope of the main method
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {
        input = new Scanner(System.in); // Create a scanner object 

        // Declare required variables
        Graph g;
        int selection, graph_selection;
        int VerticesNo = 0, EdgesNo = 0;
        
        System.out.println("\n\t\t\tWelcome to our amazing Dijkstra program!!!");
        // ask the user to enter the choise 
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("Please, choose how to create the graph:");
        System.out.println("\t 1- Random graph");
        System.out.println("\t 2- Read graph from file");

        // invoke getSelection() method to read the user choice
        graph_selection = getSelection();
       
        

        if (graph_selection == 1) {
            //Random graph
            
            System.out.println("Please choose the number of Vertices and Edges:");
            // Dijkstra Algorithm
            
                DijkstraRandomValues(); // Take the values.
                do {
                    selection = input.nextInt();
                    if (selection < 1 || selection > 5) {
                        System.out.println("Invalid input! Try again");
                    }
                } while (selection < 1 || selection > 5);

                // Vertices number & Edges number
                switch (selection) {
                    case 1:
                        VerticesNo = 2000;
                        EdgesNo = 10000;
                        break;
                    case 2:
                        VerticesNo = 3000;
                        EdgesNo = 15000;
                        break;
                    case 3:
                        VerticesNo = 4000;
                        EdgesNo = 20000;
                        break;
                    case 4:
                        VerticesNo = 5000;
                        EdgesNo = 25000;
                        break;
                    case 5:
                        VerticesNo = 6000;
                        EdgesNo = 30000;
                }//end swich
                

                System.out.println("Is your graph directed or not?");
                System.out.println("\t 1- Yes");
                System.out.println("\t 2- No");
                selection = getSelection(); 

                // Required invokation to create the graph
                g = new Graph(VerticesNo, EdgesNo, (selection == 1)); // Create a graph.
                g.makeGraph(VerticesNo,EdgesNo); // Make a graph.
                g.replaceNullValues();

                SingleSourceSPAlg dijkstra = new SingleSourceSPAlg(g,g.vertices[0]); // Compute the dijkstra.
                dijkstra.computeDijkstraAlg();
            
        } else {

                // keep solving the problem until the user enters 10 
                do{

                    // Display resourses options
                    System.out.println("\nChoose the desired source:\n");
                    System.out.println("**********  Enter 0 for A **********  ");
                    System.out.println("**********  Enter 1 for B **********  ");
                    System.out.println("**********  Enter 2 for C **********  ");
                    System.out.println("**********  Enter 3 for D **********  ");
                    System.out.println("**********  Enter 4 for E **********  ");
                    System.out.println("**********  Enter 5 for F **********  ");
                    System.out.println("**********  Enter 6 for G **********  ");
                    System.out.println("**********  Enter 7 for H **********  ");
                    System.out.println("**********  Enter 8 for I **********  ");
                    System.out.println("**********  Enter 9 for J **********  ");
                    System.out.println();
                    // stop condition
                    System.out.println("Note: Enter 10 to finish the program >v< !");

                    


                    // read the user choice
                    int userSource = input.nextInt();
                    
                    if (userSource >= 0 && userSource <= 9){
                        // construct the graph from the given file
                        g = new Graph();
                        File newInput = new File("graph.txt");
                        g.readGraphFromFile(newInput , userSource);
                        g.replaceNullValues();
                      
                        // create an object from DBAllSourseSPAlg 
                        // DBAllSourseSPAlg will automatically calculate the result by invoking SingleSourceSPAlg
                        DBAllSourseSPAlg dijkstra = new DBAllSourseSPAlg(g,g.vertices[userSource] ,userSource );
                       
                    }
                    else {
                        // end message
                        System.out.println("Bye !! Thank you for using our program!");
                        break;
                    }
                }while(true);
            } 
        

    }//end main


// ************************************ DijkstraRandomValues ************************************ 
    public static void DijkstraRandomValues() {
        System.out.println("------------------------------------------------------------");
        System.out.println("(n): number of vertices and (m): number of edges)");
        System.out.println(" 1: n= 2000  and  m= 10000");
        System.out.println(" 2: n= 3000 and  m= 15000");
        System.out.println(" 3: n= 4000 and  m= 20000");
        System.out.println(" 4: n= 5000 and  m= 25000");
        System.out.println(" 5: n= 6000 and  m= 30000");
        System.out.println("------------------------------------------------------------");

    }


// ************************************ getSelection ************************************     
    public static int getSelection() {
        int selection;
        do {
            selection = input.nextInt(); // read from the user
            if (selection != 1 && selection != 2) {
                System.out.println("Invalid input! Try again"); // error message
            }
        } while (selection != 1 && selection != 2); 
        return selection; // return the result 
    }
}//end class
