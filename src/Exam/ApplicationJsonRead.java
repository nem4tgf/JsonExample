package Exam;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Scanner;

public class ApplicationJsonRead {
    public static List<Student> readStudentFromJsonFile(String filePath) {
        try (FileReader reader = new FileReader(filePath)) {
            Gson gson = new GsonBuilder().setDateFormat("MMM d, yyyy").create();
            Type studentListType = new TypeToken<List<Student>>() {}.getType();
            return gson.fromJson(reader, studentListType);
        } catch (IOException e) {
            System.err.println("Failed to read from JSON file: " + e.getMessage());
            return null;
        }
    }

    public static List<Student> searchByName(List<Student> students, String name) {
        return students.stream().filter(student -> student.getName().equalsIgnoreCase(name)).toList();
    }

    public static List<Student> searchByEmail(List<Student> students, String email) {
        return students.stream().filter(student -> student.getEmail().equalsIgnoreCase(email)).toList();
    }

    public static void main(String[] args) {
        String filePath = "students.json";
        List<Student> students = readStudentFromJsonFile(filePath);

        if (students != null) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("1.Search by name:");
            System.out.println("2.Search by email:");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter name to search:");
                    String name = scanner.nextLine();
                    List<Student> studentsByName = searchByName(students, name);
                    if (!studentsByName.isEmpty()) {
                        studentsByName.forEach(System.out::println);
                    } else {
                        System.out.println("No students found with name: " + name);
                    }
                    break;
                case 2:
                    System.out.println("Enter email to search:");
                    String email = scanner.nextLine();
                    List<Student> studentsByEmail = searchByEmail(students, email);
                    if (!studentsByEmail.isEmpty()) {
                        studentsByEmail.forEach(System.out::println);
                    } else {
                        System.out.println("No students found with email: " + email);
                    }
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}

