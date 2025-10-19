package university.models;

import java.util.*;

public class Submission {
    private Student student;
    private Date timestamp;
    private String content;
    private Double grade;

    public Submission(Student student, String content) {
        this.student = student;
        this.content = content;
        this.timestamp = new Date();
    }

    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }

    public Date getTimestamp() { return timestamp; }
    public void setTimestamp(Date timestamp) { this.timestamp = timestamp; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public Double getGrade() { return grade; }
    public void setGrade(Double grade) { this.grade = grade; }
}

