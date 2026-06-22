import java.util.Scanner;

class Student {
    private int id;
    private String name;
    private int age;
    private String course;

    Student(int id, String name, int age, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
    }

    int getId() {
        return id;
    }

    void displayStudent() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Course: " + course);
        System.out.println("---------------------");
    }
}

class StudentManager {
    private Student[] students = new Student[100];
    private int count = 0;

    void addStudent(Student student) {
        students[count] = student;
        count++;
        System.out.println("Student added successfully!");
    }

    void viewStudents() {
        if (count == 0) {
            System.out.println("No students found.");
            return;
        }

        for (int i = 0; i < count; i++) {
            students[i].displayStudent();
        }
    }

    void searchStudent(int id) {
        for (int i = 0; i < count; i++) {
            if (students[i].getId() == id) {
                students[i].displayStudent();
                return;
            }
        }

        System.out.println("Student not found.");
    }
}

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        int choice;

        do {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();

                    Student student = new Student(id, name, age, course);
                    manager.addStudent(student);
                    break;

                case 2:
                    manager.viewStudents();
                    break;

                case 3:
                    System.out.print("Enter ID to search: ");
                    int searchId = sc.nextInt();
                    manager.searchStudent(searchId);
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);

        sc.close();
    }
}
