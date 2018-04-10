package mum.edu.cs544.model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Entity
public class Task {

    @Id
    @GeneratedValue
    private int id;

    @Enumerated(EnumType.STRING)
    private Status status;
    private Date startDate;
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "projectId")
    private Project project;

    @ElementCollection
    private Map<String, Integer> resources = new HashMap<String, Integer>();


    @ManyToOne
    @JoinColumn(name = "volunteerId")
    private Volunteer volunteer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Map<String, Integer> getResources() {
        return resources;
    }

    public void setResources(HashMap<String, Integer> resources) {
        this.resources = resources;
    }

    public void addResource(String resourceType, int number) {
        this.resources.put(resourceType, number);
    }

    public Volunteer getVolunteer() {
        return volunteer;
    }

    public void setVolunteer(Volunteer volunteer) {
        this.volunteer = volunteer;
    }
}
