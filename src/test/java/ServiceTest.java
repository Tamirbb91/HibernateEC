import mum.edu.cs544.dao.AdminDAO;
import mum.edu.cs544.dao.ProjectDAO;
import mum.edu.cs544.dao.TaskDAO;
import mum.edu.cs544.dao.VolunteerDAO;
import mum.edu.cs544.model.*;
import mum.edu.cs544.service.AdminService;
import mum.edu.cs544.service.VolunteerService;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import java.util.Date;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ServiceTest {

    private AdminService adminService = new AdminService();
    private VolunteerService volunteerService = new VolunteerService();
    private static Admin tamir = AdminDAO.getAdmin("Tamir");

    @Test
    public void a_ProjectAdd(){
        Project project = new Project();
        project.setStartDate(new Date());
        project.setEndDate(new Date(100));
        project.setDescription("<html>sample html</html>".getBytes());
        project.setLocation("Fairfield, IA");
        project.setStatus(Status.NOTSTARTED);
        project.setAdmin(tamir);

        adminService.addProject(project);
    }

    @Test
    public void b_addTask(){
        Project project = ProjectDAO.find(1);
        Task task = new Task();
        task.setStatus(Status.NOTSTARTED);
        task.setStartDate(new Date());
        task.setEndDate(new Date(200));
        task.addResource("VOLUNTEER", 2);
        project.addTask(task);
        adminService.modifyProject(project);
        adminService.updateTask(task);
    }

    @Test
    public void c_updateTask(){
        Project project = ProjectDAO.find(1);
        Task task = project.getTasks().get(0);
        task.setStartDate(new Date(100));
        adminService.updateTask(task);
        adminService.modifyProject(project);
    }

    @Test
    public void d_removeTask(){
        Project project = ProjectDAO.find(1);
        Task task = project.getTasks().get(0);
        task.setProject(null);
        adminService.removeTask(task);
        adminService.modifyProject(project);
    }

    @Test
    public void e_offerService(){
        Volunteer volunteer = VolunteerDAO.find(20);
        Task task = TaskDAO.find(10);
        volunteer.addTask(task);

        adminService.updateTask(task);
        volunteerService.offerService(task, volunteer);
    }

    @Test
    public void f_listProjects(){
        adminService.listProjects( tamir);
    }

    @Test
    public void g_listBeneficiaryInformation(){
        adminService.listBeneficiaryInformation(1, tamir);
    }

    @Test
    public void h_listTask(){
        adminService.listTask(1, tamir);
    }

    @Test
    public void i_listProjectByStatus(){
        adminService.listProjectByStatus(Status.NOTSTARTED, tamir);
    }

    @Test
    public void j_listProjectByResource(){
        adminService.listProjectByResource("VOLUNTEER", tamir);
    }

    @Test
    public void k_listProjectByLocationKeyword(){
        adminService.listProjectByLocationKeyword("Fairfield", tamir);
    }

    @Test
    public void l_listProjectByVolunteerOfferedService(){
        adminService.listProjectByVolunteerOfferedService(tamir);
    }

    @Test
    public void m_listTaskByVolunteerOfferedService(){
        adminService.listTaskByVolunteerOfferedService(tamir);
    }
}
