package university.models;

import java.util.*;

public class Assignment {
    private String assignmentId;
    private String title;
    private String description;
    private Date dueDate;
    private Map<String, Submission> submissions;

    public Assignment(String assignmentId, String title, String description, Date dueDate) {
        this.assignmentId = assignmentId;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.submissions = new HashMap<>();
    }

    public String getAssignmentId() { return assignmentId; }
    public void setAssignmentId(String assignmentId) { this.assignmentId = assignmentId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Date getDueDate() { return dueDate; }
    public void setDueDate(Date dueDate) { this.dueDate = dueDate; }

    public Map<String, Submission> getSubmissions() { return submissions; }
    public void setSubmissions(Map<String, Submission> submissions) { this.submissions = submissions; }

    public void addSubmission(Submission s) { this.submissions.put(s.getStudent().getId(), s); }
}

