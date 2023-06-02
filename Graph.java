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
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;
 
 public class Graph {
	 

	//Data fields
	
	// vertices & edge number 
	 int verticesNo;
	 int edgeNo;
	 // is graph directed or not.
	 boolean isDigraph;
	 //list of vertices of this graph
	 public Vertex vertices[];
	 // matrix of edges
	 Edge [][] adjMatrix;

	 int userVerticesNo;
	 int userEdgesNo;


	 // constructors
	 public Graph() {
		 vertices = new Vertex[verticesNo];
	 }
 
	 public Graph(int veticesNo, int edgeNo, boolean isDigraph) {
		 this.userVerticesNo = veticesNo;
		 this.userEdgesNo = edgeNo;
		 this.isDigraph = isDigraph;
		 vertices =  new Vertex[userVerticesNo];
		 adjMatrix = new Edge[userVerticesNo][userVerticesNo];}


	 // makeGraph method
	 public void makeGraph( int numberOfVertices, int numberOfEdges ) {
		 Random random = new Random();

		 // create random weights
		 for (int i = 0; i < numberOfVertices - 1; i++) {
			 int randomWeight = random.nextInt(50)+1;
			 addEdge(i, i + 1, randomWeight); 
		 }
		 
		 //create edges.
		 while (edgeNo < numberOfEdges) {
			 int source = random.nextInt(numberOfVertices);
			 int Destination = random.nextInt(numberOfVertices);
			 
			 int weight = random.nextInt(50)+1;
			 // to avoid self loops and duplicate edges
			 if (source == Destination || adjMatrix[source][Destination]!=null) { 
				continue;
			 } else {
				 addEdge(source, Destination, weight);
			 }
		 }}
 
	 //-----------------------------------------------------------------------------------
     // getters methods

	 public int getVerticesNo() {
		 return this.verticesNo;
	 }
 
	 public int getEdgeNo() {
		 return this.edgeNo;
	 }
 
	 public boolean getDirected() {
		 return this.isDigraph;
	 }
     //-----------------------------------------------------------------------------------

	 // readGraphFromFile method
	 public void readGraphFromFile(File inputfile , int userSource) throws FileNotFoundException {
		// create a scanner object
		Scanner input = new Scanner(inputfile);
		input.next();
		// read graph properties
		this.isDigraph = (input.next().contains("1"));
		userVerticesNo= input.nextInt();
		userEdgesNo= input.nextInt();
		// make a 2DIM array to create the matrix 
		vertices= new Vertex[userVerticesNo];
		adjMatrix = new Edge[userVerticesNo][userVerticesNo];
		
		// construct the graph by reading source & destination each time and then 
		// add the edge,vertices, And their Labels
		 while(edgeNo<userEdgesNo){
			 char source = input.next().charAt(0);
			 char destination = input.next().charAt(0);
			 addEdge(source-65,destination-65, input.nextInt());
			 addVertLabel(vertices[source-65]); // store it as a char
			 addVertLabel(vertices[destination-65]);}} // store it as a char
	 
	// 	add edge method 	 
	 public Edge addEdge(int v, int u, int w) {
		 if(vertices[v]==null){
				 // create a vertex "source"
				 Vertex tempVert = new Vertex();
				 // add it to the vertices array and increase the counter
				 vertices[v]= tempVert;
				 tempVert.position=v;
				 verticesNo++;
		 }
		  if(vertices[u]==null){
			     // create a vertex "destination"
				 Vertex tempVert = new Vertex();
				 // add it to the vertices array and increase the counter
				 vertices[u]= tempVert;
				 tempVert.position=u;
				 verticesNo++;
		 }
		 
		 // add both vertices to the adjMatrix
		 adjMatrix[v][u] = new Edge(vertices[v], vertices[u], w);
		 edgeNo++;
		 if (!isDigraph) {
			 adjMatrix[u][v] = new Edge(vertices[u], vertices[v], w);
			 edgeNo++;
		 }
		 return adjMatrix[v][u];
	 }
 
	
 
	 /*
	  * add the label if not exist otherwise return false
	  *  vLabel vertex that will be adding.
	  *  true if vLable was added before.
	  */
	 public void addVertLabel(Vertex vLabel) {
		 vLabel.label = (char)(65+vLabel.position);
		 
	 }
	 
	 // replace null values with defult values to be able to 
	 // compare and apply the Dijksta Algorithm with out any problems
	 public void replaceNullValues(){
		 for (int i = 0; i < verticesNo; i++) {
			 for (int j = 0; j < verticesNo; j++) {
				 if(adjMatrix[i][j]==null)
					 adjMatrix[i][j]= new Edge(null, null, 99999); // large values
				 if(i==j)
					 adjMatrix[i][j]= new Edge(null, null, 0);   // small values
			 }
			 
		 }
	 
	 }
 }
 