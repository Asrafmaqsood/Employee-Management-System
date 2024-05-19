package employee.managment.sys;

import java.sql.*;
public class EmployeeDAO {
    Connection con;
    Statement stmt;
    public EmployeeDAO(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/employee_managment_sys";
            String username = "root";
            String password = "MySQL@786";

            con = DriverManager.getConnection(url, username, password);
            stmt = con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}







