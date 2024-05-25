package Exam;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConnectionDB {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/studentJSON";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";
    public static List<Student> getStudentFromDatabase() throws SQLException {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM student";
        Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String address = resultSet.getString("address");
            String email = resultSet.getString("email");
            String phone = resultSet.getString("phone");
            Date dob = resultSet.getDate("dob");
            students.add(new Student(id, name, address, email, phone, dob));
        }
        return students;
    }
}
