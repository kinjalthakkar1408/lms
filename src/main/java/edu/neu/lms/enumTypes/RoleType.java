package edu.neu.lms.enumTypes;

public enum RoleType {
    Admin("Admin"),
    Librarian("Librarian"),
    Student("Student");

    private final String displayRoleType;

    RoleType(String displayRoleType) {
        this.displayRoleType = displayRoleType;
    }

    public String getDisplayRoleType() {
        return displayRoleType;
    }
}