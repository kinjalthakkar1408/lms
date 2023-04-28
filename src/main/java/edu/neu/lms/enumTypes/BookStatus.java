package edu.neu.lms.enumTypes;

public enum BookStatus {
    RETURNED("Returned"),
    PENDING("Pending");
	
	private final String displayBookStatus;

	BookStatus(String displayBookStatus) {
        this.displayBookStatus = displayBookStatus;
    }

    public String getDisplayBookStatus() {
        return displayBookStatus;
    }
}
