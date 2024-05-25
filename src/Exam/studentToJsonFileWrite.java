package Exam;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class studentToJsonFileWrite {
    public static void writeStudentToJsonFile(List<Student> employees, String filePath) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(filePath)) {  // Use try-with-resources to ensure the writer is closed
            gson.toJson(employees, writer);
        }
    }
}