package main;

import java.sql.Date;
import java.time.LocalDate;

public class CovertDateToLocalDate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Tạo một đối tượng java.sql.Date
        Date sqlDate = Date.valueOf("2024-02-16");
        
        // Chuyển đổi java.sql.Date thành LocalDate
        LocalDate localDate = sqlDate.toLocalDate();
        
        // In ra LocalDate
        System.out.println("LocalDate: " + localDate);
	}

}
