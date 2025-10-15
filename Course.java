package university.models;

import java.util.*;

public class Course {
    private String code;
    private String name;
    private int credits;
    private Teacher teacher;
    private List<Enrollment> enrollments;
    private String[] scheduleSlots;
    private Map<String, Assignment> assignments;

    public Course(String code, String name, int credits, String[] scheduleSlots) {
        this.code = code;
        this.name = name;
        this.credits = credits;
        this.scheduleSlots = scheduleSlots != null ? scheduleSlots : new String[0];
        this.enrollments = new ArrayList<>();
        this.assignments = new HashMap<>();
    }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getCredits() { return credits; }
    public void setCredits(int credits) { this.credits = credits; }

    public Teacher getTeacher() { return teacher; }
    public void setTeacher(Teacher teacher) { this.teacher = teacher; }

    public List<Enrollment> getEnrollments() { return enrollments; }
    public void setEnrollments(List<Enrollment> enrollments) { this.enrollments = enrollments; }

    public String[] getScheduleSlots() { return scheduleSlots; }
    public void setScheduleSlots(String[] scheduleSlots) { this.scheduleSlots = scheduleSlots; }

    public Map<String, Assignment> getAssignments() { return assignments; }
    public void setAssignments(Map<String, Assignment> assignments) { this.assignments = assignments; }

    public void addAssignment(Assignment a) {
        this.assignments.put(a.getAssignmentId(), a);
    }

    public void enrollStudent(Student s) {
        Enrollment e = new Enrollment(this, s);
        enrollments.add(e);
        s.addEnrollment(e);
    }

    @Override
    public String toString() {
        return String.format("%s - %s (%d cr) | Teacher: %s | Enrolled: %d",
                code, name, credits, teacher == null ? "TBD" : teacher.getFullName(), enrollments.size());
    }
}

