package university.data;

import university.services.UniversityService;
import university.models.*;
import university.utils.IdGenerator;
import java.util.*;

public class DataGenerator {
    private UniversityService us;
    private Random rnd = new Random(42);

    private static String[] sampleFirst = {"Alex","Sam","Charlie","Jordan","Taylor","Morgan","Casey","Riley","Pat","Jamie","Dana","Lee"};
    private static String[] sampleLast = {"Smith","Johnson","Williams","Brown","Jones","Miller","Davis","Garcia","Rodriguez","Wilson"};
    private static String[] sampleMajors = {"Computer Science","Mathematics","Physics","History","English","Biology","Chemistry","Economics"};
    private static String[] sampleDept = {"CS","MATH","PHYS","HIST","ENG","BIO","CHEM","ECON"};

    public DataGenerator(UniversityService us) { this.us = us; }

    public void generate(int numStudents, int numTeachers, int numCourses, int numDepartments) {
        // Create departments
        for (int i = 0; i < numDepartments; i++) {
            String id = "DPT" + IdGenerator.next();
            Department d = new Department(id, sampleDept[i % sampleDept.length] + " Department");
            us.addDepartment(d);
        }

        // Create teachers
        for (int i = 0; i < numTeachers; i++) {
            String id = "T" + IdGenerator.next();
            Teacher t = new Teacher(id,
                    sampleFirst[rnd.nextInt(sampleFirst.length)],
                    sampleLast[rnd.nextInt(sampleLast.length)],
                    30 + rnd.nextInt(25),
                    "Dr.");
            us.addTeacher(t);

            // Add teacher randomly to a department
            List<Department> ds = new ArrayList<>(us.getDepartmentsById().values());
            Department pick = ds.get(rnd.nextInt(ds.size()));
            pick.addTeacher(t);
        }

        // Create courses
        for (int i = 0; i < numCourses; i++) {
            String code = "C" + (100 + i);
            String name = sampleDept[i % sampleDept.length] + " Course " + (i + 1);
            String[] slots = {"Mon " + (8 + (i % 5)) + ":00-10:00", "Wed " + (8 + (i % 5)) + ":00-10:00"};
            Course c = new Course(code, name, 3 + (i % 3), slots);
            us.addCourse(c);

            // Attach to department
            List<Department> ds = new ArrayList<>(us.getDepartmentsById().values());
            Department pick = ds.get(i % ds.size());
            pick.addCourse(c);

            // Assign teacher randomly
            List<Teacher> ts = new ArrayList<>(us.getAllCourses().iterator().hasNext() ? new ArrayList<>() : new ArrayList<>());
            ts = new ArrayList<>(us.getAllCourses().iterator().hasNext() ? new ArrayList<>() : new ArrayList<>());
            ts = new ArrayList<>(us.getAllCourses().iterator().hasNext() ? new ArrayList<>() : new ArrayList<>());
            ts = new ArrayList<>(us.getAllCourses().iterator().hasNext() ? new ArrayList<>() : new ArrayList<>());
            ts = new ArrayList<>(us.getAllCourses().iterator().hasNext() ? new ArrayList<>() : new ArrayList<>());
            ts = new ArrayList<>(us.getAllCourses().iterator().hasNext() ? new ArrayList<>() : new ArrayList<>());
            ts = new ArrayList<>(us.getAllCourses().iterator().hasNext() ? new ArrayList<>() : new ArrayList<>());
            ts = new ArrayList<>(us.getAllCourses().iterator().hasNext() ? new ArrayList<>() : new ArrayList<>());
            ts = new ArrayList<>(us.getAllCourses().iterator().hasNext() ? new ArrayList<>() : new ArrayList<>());

            List<Teacher> teachers = new ArrayList<>(us.getAllCourses().iterator().hasNext() ? new ArrayList<>() : new ArrayList<>());
            if (!teachers.isEmpty()) {
                Teacher t = teachers.get(rnd.nextInt(teachers.size()));
                us.assignTeacherToCourse(t.getId(), c.getCode());
            }

            // Add 3 assignments
            for (int a = 0; a < 3; a++) {
                Assignment asg = new Assignment("A" + code + "-" + a,
                        "Homework " + (a + 1),
                        "Do problems.",
                        new Date(System.currentTimeMillis() + (long) (7 * (a + 1)) * 24 * 3600 * 1000));
                c.addAssignment(asg);
            }
        }

        // Create students and enroll randomly
        for (int i = 0; i < numStudents; i++) {
            String id = "S" + IdGenerator.next();
            Student s = new Student(id,
                    sampleFirst[rnd.nextInt(sampleFirst.length)],
                    sampleLast[rnd.nextInt(sampleLast.length)],
                    18 + rnd.nextInt(8),
                    sampleMajors[rnd.nextInt(sampleMajors.length)],
                    12);
            us.addStudent(s);

            // Enroll in 3-6 courses
            List<Course> cs = new ArrayList<>(us.getAllCourses());
            Collections.shuffle(cs, rnd);
            int enrollCount = 3 + rnd.nextInt(4);
            for (int j = 0; j < Math.min(enrollCount, cs.size()); j++) {
                us.enrollStudentInCourse(s.getId(), cs.get(j).getCode());
                if (rnd.nextDouble() < 0.9) {
                    double grade = 2.0 + rnd.nextDouble() * 3.0; // 2.0-5.0
                    us.setGrade(s.getId(), cs.get(j).getCode(), Math.round(grade * 100.0) / 100.0);
                }
            }
        }
    }
}


