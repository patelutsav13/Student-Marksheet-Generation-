import java.util.*;
import java.io.*;

public class Marksheet1
{
    static class Student
    {
        int id;
        String name;
        int mark1, mark2, mark3, mark4, mark5;
        int totalMarks;
        double percentage;
        String grade;

        public Student(int id, String name, int mark1, int mark2, int mark3, int mark4, int mark5)
        {
            this.id = id;
            this.name = name;
            this.mark1 = mark1;
            this.mark2 = mark2;
            this.mark3 = mark3;
            this.mark4 = mark4;
            this.mark5 = mark5;
            this.totalMarks = mark1 + mark2 + mark3 + mark4 + mark5;
            this.percentage = calculatePercentage(this.totalMarks);
            this.grade = calculateGrade(this.percentage);
        }

        public double calculatePercentage(int totalMarks)
        {
            return totalMarks / 5.0;
        }

        public String calculateGrade(double percentage)
        {
            if (percentage >= 90)
            {
                return "A+";
            }
            else if (percentage >= 80)
            {
                return "A";
            }
            else if (percentage >= 70)
            {
                return "B+";
            }
            else if (percentage >= 60)
            {
                return "B";
            }
            else if (percentage >= 50)
            {
                return "C+";
            }
            else if (percentage >= 40)
            {
                return "C";
            }
            else
            {
                return "F";
            }
        }

        @Override
        public String toString()
        {
            return "ID: " + id + "\nName: " + name + "\nMarks: [" + mark1 + ", " + mark2 + ", " + mark3 + ", " + mark4 + ", " + mark5 + "]\nTotal Marks: " + totalMarks + "\nPercentage: " + percentage + "\nGrade: " + grade + "\n";
        }
    }

    static List<Student> studentList = new ArrayList<>();

    public static void addStudent(Scanner sc)
    {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Marks for Subject 1: ");
        int mark1 = sc.nextInt();
        System.out.print("Enter Marks for Subject 2: ");
        int mark2 = sc.nextInt();
        System.out.print("Enter Marks for Subject 3: ");
        int mark3 = sc.nextInt();
        System.out.print("Enter Marks for Subject 4: ");
        int mark4 = sc.nextInt();
        System.out.print("Enter Marks for Subject 5: ");
        int mark5 = sc.nextInt();

        Student student = new Student(id, name, mark1, mark2, mark3, mark4, mark5);
        studentList.add(student);
        saveDataToFile();
        System.out.println("Student added successfully.");
    }

    public static void updateStudent(Scanner sc)
    {
        System.out.print("Enter Student ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        Student student = findStudentById(id);
        if (student != null)
        {
            System.out.print("Enter New Name: ");
            student.name = sc.nextLine();
            System.out.print("Enter New Marks for Subject 1: ");
            student.mark1 = sc.nextInt();
            System.out.print("Enter New Marks for Subject 2: ");
            student.mark2 = sc.nextInt();
            System.out.print("Enter New Marks for Subject 3: ");
            student.mark3 = sc.nextInt();
            System.out.print("Enter New Marks for Subject 4: ");
            student.mark4 = sc.nextInt();
            System.out.print("Enter New Marks for Subject 5: ");
            student.mark5 = sc.nextInt();

            student.totalMarks = student.mark1 + student.mark2 + student.mark3 + student.mark4 + student.mark5;
            student.percentage = student.calculatePercentage(student.totalMarks);
            student.grade = student.calculateGrade(student.percentage);

            saveDataToFile();
            System.out.println("Student updated successfully.");
        }
        else
        {
            System.out.println("Student not found.");
        }
    }

    public static void deleteStudent(Scanner sc)
    {
        System.out.print("Enter Student ID to delete: ");
        int id = sc.nextInt();

        Student student = findStudentById(id);
        if (student != null)
        {
            studentList.remove(student);
            saveDataToFile();
            System.out.println("Student deleted successfully.");
        }
        else
        {
            System.out.println("Student not found.");
        }
    }

    public static Student findStudentById(int id)
    {
        for (Student student : studentList)
        {
            if (student.id == id)
            {
                return student;
            }
        }
        return null;
    }

    public static void viewAllStudents()
    {
        if (studentList.isEmpty())
        {
            System.out.println("No students available.");
        }
        else
        {
            for (Student student : studentList)
            {
                System.out.println(student);
            }
        }
    }

    public static void saveDataToFile()
    {
        try
        {
            FileWriter writer = new FileWriter("students.txt");
            for (Student student : studentList)
            {
                writer.write(student.toString());
                writer.write("\n");
            }
            writer.close();
        }
        catch (IOException e)
        {
            System.out.println("Error writing to file.");
        }
    }

    public static void loadDataFromFile()
    {
        try
        {
            File file = new File("students.txt");
            if (file.exists())
            {
                Scanner fileScanner = new Scanner(file);
                while (fileScanner.hasNextLine())
                {
                    String line = fileScanner.nextLine();
                    String[] parts = line.split("\n");
                    int id = Integer.parseInt(parts[0].split(":")[1].trim());
                    String name = parts[1].split(":")[1].trim();
                    int mark1 = Integer.parseInt(parts[2].split(":")[1].trim());
                    int mark2 = Integer.parseInt(parts[3].split(":")[1].trim());
                    int mark3 = Integer.parseInt(parts[4].split(":")[1].trim());
                    int mark4 = Integer.parseInt(parts[5].split(":")[1].trim());
                    int mark5 = Integer.parseInt(parts[6].split(":")[1].trim());

                    Student student = new Student(id, name, mark1, mark2, mark3, mark4, mark5);
                    studentList.add(student);
                }
                fileScanner.close();
            }
        }
        catch (IOException e)
        {
            System.out.println("Error reading from file.");
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        loadDataFromFile();

        while (true)
        {
            System.out.println("\n1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. View All Students");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice)
            {
                case 1:
                    addStudent(sc);
                    break;
                case 2:
                    updateStudent(sc);
                    break;
                case 3:
                    deleteStudent(sc);
                    break;
                case 4:
                    viewAllStudents();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        }
    }
}