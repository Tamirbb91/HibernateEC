package mum.edu.cs544.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Admin extends User{

    @OneToMany
    private List<Project> projects = new ArrayList<Project>();

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public void addProject(Project project){
        project.setAdmin(this);
        this.projects.add(project);
    }
}
