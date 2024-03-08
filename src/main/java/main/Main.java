package main;




import dao.*;
import entities.*;




public class Main {
	//Tạo và nạp dữ liệu.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Create and upload data
		//EntityManagerFactory emf = Persistence.createEntityManagerFactory("project_ms");
		//EntityManager em = emf.createEntityManager();
		//em.getTransaction().begin();
		Project_DAO project_DAO=new Project_DAO();
		Staff_DAO staff_DAO=new Staff_DAO();
		//Khởi tạo entities.
		//public Project(String code, String description, Date start_Date, Date end_Date, double size, double budget)
		Project prj1=new Project("Pr1", "Landmark 81", java.sql.Date.valueOf("2024-03-09"),java.sql.Date.valueOf("2024-06-09"),100,1000000000);
		Project prj2=new Project("Pr2", "Landmark 82", java.sql.Date.valueOf("2024-03-10"),java.sql.Date.valueOf("2024-06-10"),200,2000000000);
		Project prj3=new Project("Pr3", "Landmark 83", java.sql.Date.valueOf("2023-03-11"),java.sql.Date.valueOf("2024-06-11"),300,2000000000);
		//public Staff(String emp_id, String fullname, Date dateOfBirth, String email, String cellphone)
		Staff stf1=new Staff("Stf1", "Ben Mane",java.sql.Date.valueOf("2000-03-11"), "benmane@gmail.com", "0981646635");
		Staff stf2=new Staff("Stf2", "Kane",java.sql.Date.valueOf("2000-03-12"), "bon23mane@gmail.com", "0981646634");
		Staff stf3=new Staff("Stf3", "Zuec",java.sql.Date.valueOf("2000-03-13"), "ben2mane@gmail.com", "0981646633");
		Staff stf4=new Staff("Stf4", "Fost",java.sql.Date.valueOf("2000-03-14"), "ben3mane@gmail.com", "0981646631");
		Staff stf5=new Staff("Stf5", "Mary Mary",java.sql.Date.valueOf("2000-03-15"), "benmane@gmail.com", "0981646631");
		Staff stf6=new Staff("Stf6", "Lisa",java.sql.Date.valueOf("2000-03-16"), "benma2ne@gmail.com", "0981646630");
		Staff stf7=new Staff("Stf7", "Moses Mark",java.sql.Date.valueOf("2000-03-17"), "be3nmane@gmail.com", "0981646639");
		Staff stf8=new Staff("Stf8", "Oppoes",java.sql.Date.valueOf("2000-03-18"), "benma2ne@gmail.com", "0981646638");
		Staff stf9=new Staff("Stf9", "Jane",java.sql.Date.valueOf("2000-03-19"), "be1nmane@gmail.com", "0981646637");
		//set Project 1-n Staff
		prj1.getListStaff().add(stf1);
		prj1.getListStaff().add(stf2);
		prj1.getListStaff().add(stf3);
		stf1.setProject(prj1);
		stf2.setProject(prj1);
		stf3.setProject(prj1);
		
		prj2.getListStaff().add(stf4);
		prj2.getListStaff().add(stf5);
		prj2.getListStaff().add(stf6);
		stf4.setProject(prj2);
		stf5.setProject(prj2);
		stf6.setProject(prj2);
				
		prj3.getListStaff().add(stf7);
		prj3.getListStaff().add(stf8);
		prj3.getListStaff().add(stf9);
		stf7.setProject(prj3);
		stf8.setProject(prj3);
		stf9.setProject(prj3);
		
		project_DAO.addProject(prj1);
		project_DAO.addProject(prj2);
		project_DAO.addProject(prj3);
		
		System.out.println("List Project");
		System.out.println(project_DAO.getStringListProject());
		
		
		System.out.println("List Staff");
		System.out.println(staff_DAO.getStringListStaff());
		
		System.out.println("List Project with size 200:");
		System.out.println(project_DAO.getStringListProjectWithSize(200));
		
		System.out.println("List Project in year 2023:");
		System.out.println(project_DAO.getStringListProjectWithYear(2023));
			
		//Staff stf10=new Staff("Stf10", "Jany",java.sql.Date.valueOf("2002-03-19"), "j345@gmail.com", "0781646637");
		Project prj4=new Project("Pr4", "Landmark 13", java.sql.Date.valueOf("2025-03-11"),java.sql.Date.valueOf("2027-06-11"),600,1000000000);
		project_DAO.addProject(prj4);
		System.out.println("List Project after adding.");
		System.out.println(project_DAO.getStringListProject());
		
		staff_DAO.deleteStaff("Stf9");
		System.out.println("List Staff after deleted:");
		System.out.println(staff_DAO.getStringListStaff());
		
		Project prj5=new Project("Pr5", "Landmark 800", java.sql.Date.valueOf("2024-03-11"),java.sql.Date.valueOf("2028-06-11"),300,2000000000);
		project_DAO.updateProject("Pr2",prj5);
		System.out.println("List Project after update.");
		System.out.println(project_DAO.getStringListProject());
		
		Staff stf10=new Staff("Stf10", "Zane",java.sql.Date.valueOf("2000-03-19"), "be1nmane@gmail.com", "0981646637");
		staff_DAO.addStaff(stf10);
		System.out.println("List Staff after added:");
		System.out.println(staff_DAO.getStringListStaff());
	}

}
