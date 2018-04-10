package mum.edu.cs544.service;

import mum.edu.cs544.dao.ProjectDAO;
import mum.edu.cs544.dao.TaskDAO;
import mum.edu.cs544.model.*;

import java.util.List;

public class AdminService {
    public void addProject(Project project){
        ProjectDAO.create(project);
    }

    public void modifyProject(Project project){
        ProjectDAO.update(project);
    }

    public void addTask(Task task){
        TaskDAO.create(task);
    }

    public void updateTask(Task task){
        TaskDAO.update(task);
    }

    public void removeTask(Task task){
        TaskDAO.delete(task);
    }

    public void deleteProject(Project project){
        ProjectDAO.delete(project);
    }

    public Project findProjectDetails(int projectId, User user){
        if(user instanceof Admin){
            return ProjectDAO.find(projectId);
        }
        return null;
    }

    public List<String> listBeneficiaryInformation(int projectId, User user){
        if(user instanceof Admin){
            return ProjectDAO.findBeneficiaryInformation(projectId);
        }
        return null;
    }

    public List<Task> listTask(int projectId, User user){
        if(user instanceof Admin){
            return ProjectDAO.getTasks(projectId);
        }
        return null;
    }

    public List<Project> listProjectByStatus(Status status, User user){
        if(user instanceof Admin){
            return ProjectDAO.findProjectsByStatus(status);
        }
        return null;
    }

    public List<Project> listProjects(User user){
        if(user instanceof Admin){
            return ProjectDAO.findAll();
        }
        return null;
    }

    public List<Project> listProjectByResource(String resource, User user){
        if(user instanceof Admin){
            return ProjectDAO.findProjectsByResource(resource);
        }
        return null;
    }

    public List<Project> listProjectByLocationKeyword(String locationKeyword, User user){
        if(user instanceof Admin){
            return ProjectDAO.findByLocationOrKeyword(locationKeyword);
        }
        return null;
    }

    public List<Project> listProjectByVolunteerOfferedService(User user){
        if(user instanceof Admin){
            return ProjectDAO.listProjectByVolunteerOfferedService();
        }
        return null;
    }

    public List<Task> listTaskByVolunteerOfferedService(User user){
        if(user instanceof Admin){
            return TaskDAO.listTaskByVolunteerOfferedService();
        }
        return null;
    }
}
