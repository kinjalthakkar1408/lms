package edu.neu.lms.enumTypes;

public enum Course {
	
	COMPUTER_SCIENCE("Computer Science"), 
	INFORMATION_SYSTEM("Information System"), 
	MECHANICAL_ENGINEERING("Mechanical Engineering"), 
	CIVIL_ENGINEERING("Civil Engineering");
	
	private final String displayCourseName;

	Course(String displayCourseName) {
		this.displayCourseName = displayCourseName;
	}
	
	public String getDisplayCourseName() {
		return displayCourseName;
	}

}
