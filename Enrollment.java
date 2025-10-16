package university.models;

import java.util.Date;

public class Enrollment {
    private Course course;
    private Student student;
    private Double grade; // null = not graded yet
    private Date enrollmentDate;

    public Enrollment(Course course, Student student) {
        this.course = course;
        this.student = student;
        this.enrollmentDate = new Date();
    }

    public Course getCourse() { return course; }
    public void setCourse(Course course) { this.course = course; }

    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }

    public Double getGrade() { return grade; }
    public void setGrade(Double grade) { this.grade = grade; }

    public Date getEnrollmentDate() { return enrollmentDate; }
    public void setEnrollmentDate(Date enrollmentDate) { this.enrollmentDate = enrollmentDate; }

    @Override
    public String toString() {
        return String.format("Enrollment: %s -> %s | Grade: %s",
                student.getFullName(),
                course.getCode(),
                grade == null ? "N/A" : String.format("%.2f", grade));
    }
}
