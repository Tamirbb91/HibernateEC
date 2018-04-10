package mum.edu.cs544.service;

import mum.edu.cs544.dao.TaskDAO;
import mum.edu.cs544.dao.VolunteerDAO;
import mum.edu.cs544.model.Task;
import mum.edu.cs544.model.User;
import mum.edu.cs544.model.Volunteer;

public class VolunteerService {

    public void offerService(Task task, User user){
        if(user instanceof Volunteer){
            Volunteer volunteer = (Volunteer) user;
            volunteer.addTask(task);
            VolunteerDAO.update(volunteer);
            TaskDAO.update(task);
        }
    }
}
