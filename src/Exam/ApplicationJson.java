package Exam;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ApplicationJson {
    public static void main(String[] args) throws SQLException, IOException {
        //Load data
        List<Student> students = ConnectionDB.getStudentFromDatabase();
        //Ghi file json
        String filePath = "students.json";
        studentToJsonFileWrite.writeStudentToJsonFile(students, filePath);
        System.out.println("Data has been written to " + filePath);
    }
}
