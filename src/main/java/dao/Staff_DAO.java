package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import database.*;
import entities.*;
import interface_DAO.I_Staff_DAO;

import jakarta.persistence.TypedQuery;

public class Staff_DAO implements I_Staff_DAO {
	List<Project> listProject = new ArrayList<>();
	private Connect con = new Connect();
	/*
	@PersistenceContext
	private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("project_ms");
	private final EntityManager entityManager;
	private final EntityTransaction transaction;*/
	Herbinate herbinate=new Herbinate("project_ms");
	public Staff_DAO() {
		super();
		// TODO Auto-generated constructor stub
		//this.entityManager = emf.createEntityManager();
		//this.transaction = entityManager.getTransaction();
	}

	@Override
	public List<Staff> getListStaff() {
		// TODO Auto-generated method stub
		try {
			TypedQuery<Staff> query = herbinate.getEntityManager().createQuery("SELECT p FROM Staff p", Staff.class);
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
			return null;
		}
	}

	@Override
	public String getStringListStaff() {
		// TODO Auto-generated method stub
		String s = "";
		List<Staff> listStaff = getListStaff();
		for (Staff st : listStaff) {
			s += st.toString() + "\n";
		}
		return s;
	}

	@Override
	public void deleteStaff(String emp_id) {
		String sqlDelete = "DELETE FROM [dbo].[Staff] where emp_id=?\r\n";
		try {
			PreparedStatement preparedStatement_Delete = con.con().prepareStatement(sqlDelete);
			preparedStatement_Delete.setString(1, emp_id);
			preparedStatement_Delete.executeUpdate();
			con.con().close();
			preparedStatement_Delete.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}

	@Override
	public void addStaff(Staff st) {
		// TODO Auto-generated method stub
		try {
			herbinate.getTransaction().begin();
			// Kiểm tra xem khóa chính đã tồn tại hay chưa
			if (herbinate.getEntityManager().find(Staff.class, st.getEmp_id()) != null) {
				// Nếu ID đã tồn tại, không thêm vào cơ sở dữ liệu
				System.out.println("Emp id đã tồn tại trong cơ sở dữ liệu.");
				// return false;
			}
			// Nếu khóa chính chưa tồn tại, thực hiện thêm vào cơ sở dữ liệu
			herbinate.getEntityManager().persist(st);
			herbinate.getTransaction().commit();
			System.out.println("Thêm dữ liệu Staff thành công!");
		} catch (Exception e) {
			if (herbinate.getEntityManager() != null && herbinate.getTransaction().isActive()) {
				herbinate.getTransaction().rollback();
				// return false;
			}
			e.printStackTrace();
			System.out.println(e);
		}
	}

}
