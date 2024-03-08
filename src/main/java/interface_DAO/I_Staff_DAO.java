package interface_DAO;
import java.util.*;
import entities.*;
public interface I_Staff_DAO {
	public List<Staff> getListStaff();
	public String getStringListStaff();
	public void deleteStaff(String emp_id);
	public void addStaff(Staff st);
}
