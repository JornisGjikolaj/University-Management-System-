package university.models;

import java.util.*;

public class Student extends Person {
    private String major;
    private List<Enrollment> enrollments; // uses List
    private int[] examAttemptsPerSemester; // uses array

    public Student(String id, String firstName, String lastName, int age, String major, int semestersCapacity) {
        super(id, firstName, lastName, age);
        this.major = major;
        this.enrollments = new ArrayList<>();
        this.examAttemptsPerSemester = new int[semestersCapacity];
    }

    public String getMajor() { return major; }
    public void setMajor(String major) { this.major = major; }

    public List<Enrollment> getEnrollments() { return enrollments; }
    public void setEnrollments(List<Enrollment> enrollments) { this.enrollments = enrollments; }

    public int[] getExamAttemptsPerSemester() { return examAttemptsPerSemester; }
    public void setExamAttemptsPerSemester(int[] examAttemptsPerSemester) { this.examAttemptsPerSemester = examAttemptsPerSemester; }

    public void addEnrollment(Enrollment e) { this.enrollments.add(e); }

    public double calculateGPA() {
        double sum = 0;
        int count = 0;
        for (Enrollment e : enrollments) {
            if (e.getGrade() != null) {
                sum += e.getGrade();
                count++;
            }
        }
        return count == 0 ? 0.0 : sum / count;
    }

    @Override
    public String toString() {
        return String.format("Student: %s | Major: %s | GPA: %.2f", super.toString(), major, calculateGPA());
    }
}

