package university.models;

import java.util.*;

public class Department {
    private String id;
    private String name;
    private List<Course> courses;
    private Map<String, Teacher> facultyById;

    public Department(String id, String name) {
        this.id = id;
        this.name = name;
        this.courses = new ArrayList<>();
        this.facultyById = new HashMap<>();
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<Course> getCourses() { return courses; }
    public void setCourses(List<Course> courses) { this.courses = courses; }

    public Map<String, Teacher> getFacultyById() { return facultyById; }
    public void setFacultyById(Map<String, Teacher> facultyById) { this.facultyById = facultyById; }

    public void addCourse(Course c) { this.courses.add(c); }
    public void addTeacher(Teacher t) { this.facultyById.put(t.getId(), t); }

    @Override
    public String toString() {
        return String.format("Department %s - %s | Courses: %d | Faculty: %d",
                id, name, courses.size(), facultyById.size());
    }
}

