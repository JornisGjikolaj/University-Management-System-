package university.models;

import java.util.*;

public class Teacher extends Person {
    private String title;
    private List<Course> coursesTaught;

    public Teacher(String id, String firstName, String lastName, int age, String title) {
        super(id, firstName, lastName, age);
        this.title = title;
        this.coursesTaught = new ArrayList<>();
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public List<Course> getCoursesTaught() { return coursesTaught; }
    public void setCoursesTaught(List<Course> coursesTaught) { this.coursesTaught = coursesTaught; }

    public void assignCourse(Course c) { this.coursesTaught.add(c); }

    @Override
    public String toString() {
        return String.format("Teacher: %s | Title: %s | Courses: %d",
                super.toString(), title, coursesTaught.size());
    }
}

