package interface_DAO;
import java.util.*;
import entities.*;
public interface I_Project_DAO {
	public List<Project> getListProject();
	public String getStringListProject();
	public String getStringListProjectWithSize(double size);
	public String getStringListProjectWithYear(int year);
	public void addProject(Project p);
	public void updateProject(String code,Project p);
}
