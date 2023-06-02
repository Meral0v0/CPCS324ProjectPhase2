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

import GraphFramework.Vertex;

public class Location extends Vertex {

	// Data Fields
	public String City;

    // Constructor
	public Location(char label) {
		super(label);
		// initilize data fields 
		this.City = String.valueOf((char) (label + 65));
	}

	// Methods
	
	public String displayInfo() {

		return "City." + City;

	} 

} 
