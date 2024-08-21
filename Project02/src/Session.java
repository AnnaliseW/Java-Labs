/**
 * Represents an individual session in a lab.
 * <p>
 * Purdue University -- CS18000 -- Fall 2023 -- Project 02 -- Session
 *
 * @author Annalise Wang Purdue CS
 * @version October 12, 2023
 */
public class Session {
    private String name;
    private int enrollment;

    public Session(String name, int enrollment) {
        this.name = name;
        this.enrollment = enrollment;
    }

    public Session() {
        this.name = "";
        this.enrollment = 0;
    }

    public String getName() {
        return name;
    }

    public int getEnrollment() {
        return enrollment;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEnrollment(int enrollment) {
        this.enrollment = enrollment;
    }

    public String toString() {
        return "Session{Name - " + this.name + ", Enrollment - " + this.enrollment + "}";
    }

}

