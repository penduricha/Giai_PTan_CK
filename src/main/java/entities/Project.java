package entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Project")
public class Project {
	
	@Id	
	@Column(name = "code", length = 100, columnDefinition = "nvarchar(20)",nullable = false)
	private String code;
	@Column(name = "description", length = 100, columnDefinition = "nvarchar(100)",nullable = false)
	private String description;
	@Column(name = "start_Date", length = 100,nullable = false)
	private Date start_Date;
	@Column(name = "end_Date", length = 100,nullable = false)
	private Date end_Date;
	@Column(name = "size", length = 100,nullable = false)
	private double size;
	@Column(name = "budget", length = 100,nullable = false)
	private double budget;
	//Nối 1-n với Staff
	@OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    List<Staff> listStaff;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getStart_Date() {
		return start_Date;
	}
	public void setStart_Date(Date start_Date) {
		this.start_Date = start_Date;
	}
	public Date getEnd_Date() {
		return end_Date;
	}
	public void setEnd_Date(Date end_Date) {
		this.end_Date = end_Date;
	}
	public double getSize() {
		return size;
	}
	public void setSize(double size) {
		this.size = size;
	}
	public double getBudget() {
		return budget;
	}
	public void setBudget(double budget) {
		this.budget = budget;
	}
	public List<Staff> getListStaff() {
		if (listStaff == null) {
            listStaff = new ArrayList<>();
        }
        return listStaff;
	}
	public void setListStaff(List<Staff> listStaff) {
		this.listStaff = listStaff;
	}
	
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		return Objects.hash(code);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Project other = (Project) obj;
		return Objects.equals(code, other.code);
	}
	public Project(String code, String description, Date start_Date, Date end_Date, double size, double budget) {
		super();
		this.code = code;
		this.description = description;
		this.start_Date = start_Date;
		this.end_Date = end_Date;
		this.size = size;
		this.budget = budget;
	}
	@Override
	public String toString() {
		return "Project [code=" + code + ", description=" + description + ", start_Date=" + start_Date
				+ ", end_Date=" + end_Date + ", size=" + size + ", budget=" + budget + "]";
	}
	
	
}
