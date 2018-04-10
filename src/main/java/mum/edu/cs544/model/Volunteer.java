package mum.edu.cs544.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Volunteer extends User{

    @OneToMany
    private List<Task> tasks = new ArrayList<Task>();

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public void addTask(Task task){
        task.setVolunteer(this);
        this.tasks.add(task);
    }

}
