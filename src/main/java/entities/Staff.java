package entities;

import java.sql.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;
@Entity
@Table(name = "Staff")
public class Staff {
	@Id
	@Column(name = "emp_id", length = 100, columnDefinition = "nvarchar(20)",nullable = false)
	private String emp_id;
	@Column(name = "fullname", length = 100, columnDefinition = "nvarchar(50)",nullable = false)
	private String fullname;
	@Column(name = "dateOfBirth", length = 100,nullable = false)
	private Date dateOfBirth;
	@Column(name = "email", length = 100, columnDefinition = "nvarchar(20)",nullable = false)
	private String email;
	@Column(name = "cellphone", length = 100, columnDefinition = "nvarchar(10)",nullable = false)
	private String cellphone;
	//n-1 với Project	
	@ManyToOne
    @JoinColumn(name = "code")
    private Project project;
	
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public Staff() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Staff(String emp_id, String fullname, Date dateOfBirth, String email, String cellphone) {
		super();
		this.emp_id = emp_id;
		this.fullname = fullname;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.cellphone = cellphone;
	}
	@Override
	public String toString() {
		return "Staff [emp_id=" + emp_id + ", fullname=" + fullname + ", dateOfBirth=" + dateOfBirth
				+ ", email=" + email + ", cellphone=" + cellphone + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(emp_id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Staff other = (Staff) obj;
		return Objects.equals(emp_id, other.emp_id);
	}
	
}
