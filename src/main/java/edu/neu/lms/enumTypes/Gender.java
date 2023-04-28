package edu.neu.lms.enumTypes;

public enum Gender {
	Male("Male"), 
	Female("Female"), 
	Other("Other");
	
	private final String displayGender;
	
	Gender(String displayGender) {
        this.displayGender = displayGender;
    }

    public String getDisplayGender() {
        return displayGender;
    }

}
