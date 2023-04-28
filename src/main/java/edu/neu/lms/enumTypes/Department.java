package edu.neu.lms.enumTypes;


//Dont use this
public enum Department {
	
	COE("COE"),
	DAMG("DAMG"),
	CPS("CPS");
	
	private final String displayDepartmentName;

	Department(String displayDepartmentName) {
		this.displayDepartmentName=displayDepartmentName;
	}
	
	public String getDisplayDepartmentName() {
		return displayDepartmentName;
	}

}
