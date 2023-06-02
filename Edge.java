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

public class Edge {

	// Data Fields
	int weight;
	Vertex source;
	Vertex target;
	Vertex parent;
	Vertex v;
    Vertex u;

	public Edge() {
		source = new Vertex(); // create new source
		target = new Vertex(); // create new target
		parent = new Vertex(); // create new parent
	}

	/**
	 * constructor with parameters
	 * 
	 * @param source source vertex of edge
	 * @param target target vertex of edge
	 * @param weight edge weight
	 */
	public Edge(Vertex source, Vertex target, int weight) {
		this.v = source;
		this.u = target;
		this.weight = weight;
		parent = new Vertex();
	}
	

	// Methods
	/**
	 * display edges info
	 */
	public void displayInfo() {

	}

} 