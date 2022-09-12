import javax.persistence.*; 
import javax.persistence.Column; 
import javax.persistence.GeneratedValue;
import javax.persistence.Id;  
import javax.persistence.Table; 
import java.time.LocalDate; 
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "project")
public class Project {

    @Id 
    @GeneratedValue 
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "client_name")
    private String clientName;
    
    @Column(name = "company_name")
    private String companyName;

    @Column(name = "start_name")
    LocalDate startDate;

    @Column(name = "project_status")
    String projectStatus;
    
    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
    List<EmployeeProject> employeeProjects = new ArrayList<EmployeeProject>();

    public Project(String name, String clientName, String companyName, String startDate, String projectStatus) {
        this.name = name;
        this.clientName = clientName;
        this.companyName = companyName;
        this.startDate = LocalDate.parse(startDate);
        this.projectStatus = projectStatus;
    } 
    
    public Project () {
    }

    public int getId() {
        return id;
    } 
    
    public void setId() {
        this.id = id;
    }

    public String getName() {  
        return name;  
    }

    public void setName(String name) {  
        this.name = name;  
    }

    public String getClientName() {  
        return clientName;  
    }

    public void setClientName(String clientName) {  
        this.clientName = clientName;  
    }
    
    public String getCompanyName() {  
        return companyName;  
    }

    public void setCompanyName(String companyName) {  
        this.companyName = companyName;  
    }
    
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
    
    public LocalDate getStartDate() {
        return startDate;
    }
    
    public void setProjectStatus(String projectStatus) {
        this.projectStatus = projectStatus;
    }
    
    public String getProjectStatus() {
        return projectStatus;
    }
    
    public void setEmployeeProjects(List<EmployeeProject> employeeProjects) {
        this.employeeProjects = employeeProjects;
    }
    
    public List<EmployeeProject> getEmployeeProjects() {
        return employeeProjects;
    }
    
    public String toString() {
        return "\n Project Name: " + name +  "\n Company Name: " + companyName + "\n Starting Date:" + startDate +
             "\n Project Status:" + projectStatus ;
    }   
}