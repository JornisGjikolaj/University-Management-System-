package university.services;

import university.models.*;
import university.data.DataGenerator;
import java.util.*;

public class UniversityService {
    private Map<String, Student> studentsById;
    private Map<String, Teacher> teachersById;
    private Map<String, Course> coursesByCode;
    private Map<String, Department> departmentsById;

    public UniversityService() {
        this.studentsById = new HashMap<>();
        this.teachersById = new HashMap<>();
        this.coursesByCode = new HashMap<>();
        this.departmentsById = new HashMap<>();
    }

    // Student operations
    public void addStudent(Student s) { studentsById.put(s.getId(), s); }
    public Student getStudent(String id) { return studentsById.get(id); }
    public Collection<Student> getAllStudents() { return studentsById.values(); }

    // Teacher operations
    public void addTeacher(Teacher t) { teachersById.put(t.getId(), t); }
    public Teacher getTeacher(String id) { return teachersById.get(id); }

    // Course operations
    public void addCourse(Course c) { coursesByCode.put(c.getCode(), c); }
    public Course getCourse(String code) { return coursesByCode.get(code); }
    public Collection<Course> getAllCourses() { return coursesByCode.values(); }

    // Department operations
    public void addDepartment(Department d) { departmentsById.put(d.getId(), d); }
    public Department getDepartment(String id) { return departmentsById.get(id); }

    // Enrollment and teacher assignment
    public void enrollStudentInCourse(String studentId, String courseCode) {
        Student s = studentsById.get(studentId);
        Course c = coursesByCode.get(courseCode);
        if (s == null || c == null) return;
        c.enrollStudent(s);
    }

    public void assignTeacherToCourse(String teacherId, String courseCode) {
        Teacher t = teachersById.get(teacherId);
        Course c = coursesByCode.get(courseCode);
        if (t == null || c == null) return;
        c.setTeacher(t);
        t.assignCourse(c);
    }

    // Grading
    public void setGrade(String studentId, String courseCode, double grade) {
        Student s = studentsById.get(studentId);
        Course c = coursesByCode.get(courseCode);
        if (s == null || c == null) return;
        for (Enrollment e : s.getEnrollments()) {
            if (e.getCourse().getCode().equals(courseCode)) {
                e.setGrade(grade);
                return;
            }
        }
    }

    // Bulk data loader
    public void loadBulkData(int numStudents, int numTeachers, int numCourses, int numDepartments) {
        DataGenerator dg = new DataGenerator(this);
        dg.generate(numStudents, numTeachers, numCourses, numDepartments);
    }

    // Getter for departmentsById (used in reports)
    public Map<String, Department> getDepartmentsById() { return departmentsById; }
}

