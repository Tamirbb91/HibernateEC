package mum.edu.cs544.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Project {

    @Id
    @GeneratedValue
    private int id;

    @Lob
    private byte[] description;

    private String location;
    private Date startDate;
    private Date endDate;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "project")
    @OrderBy("startDate")
    private List<Task> tasks = new ArrayList<Task>();

    @OneToMany
    private List<Beneficiary> beneficiaries = new ArrayList<Beneficiary>();

    @ManyToOne
    private Admin admin;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getDescription() {
        return description;
    }

    public void setDescription(byte[] description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public void addTask(Task task){
        task.setProject(this);
        this.tasks.add(task);
    }

    public void removeTask(Task task){
        this.tasks.remove(task);
        task.setProject(null);

    }

    public List<Beneficiary> getBeneficiaries() {
        return beneficiaries;
    }

    public void setBeneficiaries(List<Beneficiary> beneficiaries) {
        this.beneficiaries = beneficiaries;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public void addBeneficiary(Beneficiary beneficiary){
        this.beneficiaries.add(beneficiary);
    }
}
