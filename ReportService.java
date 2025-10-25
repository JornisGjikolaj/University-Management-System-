package university.services;

import university.models.*;
import java.util.*;

public class ReportService {
    private UniversityService us;

    public ReportService(UniversityService us) { this.us = us; }

    public void printTopStudents(int n) {
        List<Student> all = new ArrayList<>(us.getAllStudents());
        all.sort((a, b) -> Double.compare(b.calculateGPA(), a.calculateGPA()));
        System.out.println("Top " + n + " Students:");
        for (int i = 0; i < Math.min(n, all.size()); i++) {
            System.out.println((i + 1) + ". " + all.get(i));
        }
    }

    public void departmentSummary() {
        System.out.println("Department summaries:");
        for (Department d : new ArrayList<>(us.getDepartmentsById().values())) {
            System.out.println(d);
            for (Course c : d.getCourses()) {
                System.out.println("  - " + c.getCode() + ": " + c.getName() +
                        " (" + c.getEnrollments().size() + " students)");
            }
        }
    }
}

