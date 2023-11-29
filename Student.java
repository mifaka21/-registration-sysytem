
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

// Class representing a Student
class Student {
    private String name;
    private int id;
    private String department;

    public Student(String name, int id, String department) {
        this.name = name;
        this.id = id;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}

// Class representing the Student Registration System
class StudentRegistration {
    private List<Student> students = new ArrayList<>();

    // Method to register a new student
    public void registerStudent(String name, int id, String department) {
        if (isIdUnique(id)) {
            students.add(new Student(name, id, department));
            System.out.println("Student registered successfully!");
        } else {
            System.out.println("Error: Student ID must be unique. Registration failed.");
        }
    }

    // Method to display registered students
    public void displayRegisteredStudents() {
        System.out.println("Number of registered students: " + students.size());
        if (students.size() > 0) {
            System.out.println("Registered Students:");
            for (Student student : students) {
                System.out.println("Name: " + student.getName() + ", ID: " + student.getId() + ", Department: " + student.getDepartment());
            }
        } else {
            System.out.println("No students registered yet.");
        }
    }

    // Method to edit student information
    public void editStudent(int id, String newDepartment) {
        for (Student student : students) {
            if (student.getId() == id) {
                student.setDepartment(newDepartment);
                System.out.println("Student information updated successfully!");
                return;
            }
        }
        System.out.println("Error: Student not found with ID " + id);
    }

    // Method to delete a student
    public void deleteStudent(int id) {
        students.removeIf(student -> student.getId() == id);
        System.out.println("Student deleted successfully!");
    }

    // Method to search for a student by ID
    public Student searchStudent(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null; // Student not found
    }

    // Method to check if a given ID is unique
    protected boolean isIdUnique(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return false; // ID is not unique
            }
        }
        return true; // ID is unique
    }
}

// Main class representing the Student Registration System application
class StudentRegistrationSystem {
    public static void main(String[] args) {
        System.out.println("Welcome to the Student Registration System!");

        Scanner scanner = new Scanner(System.in);
        StudentRegistration registrationSystem = new StudentRegistration();

        // Main loop for user interaction
        while (true) {
            System.out.println("\n1. Register a student");
            System.out.println("2. Display registered students");
            System.out.println("3. Edit student information");
            System.out.println("4. Delete a student");
            System.out.println("5. Search for a student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character


// Switch statement for handling user choices
                switch (choice) {
                    case 1:
                        String name;
                        while (true) {
                            System.out.print("Enter student name: ");
                            if (scanner.hasNextLine()) {
                                name = scanner.nextLine();
                                if (isValidName(name)) {
                                    break;
                                } else {
                                    System.out.println("Invalid name. Please enter a valid name.");
                                }
                            } else {
                                scanner.next(); // Consume the invalid input
                                System.out.println("Invalid input. Please enter a valid name.");
                            }
                        }

                        int id;
                        while (true) {
                            System.out.print("Enter student ID: ");
                            try {
                                id = scanner.nextInt();
                                scanner.nextLine(); // Consume the newline character
                                if (registrationSystem.isIdUnique(id)) {
                                    break;
                                } else {
                                    System.out.println("Error: Student ID must be unique. Please enter a different ID.");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid ID. Please enter a valid integer ID.");
                                scanner.nextLine(); // Consume the invalid input
                            }
                        }

                        String department;
                        while (true) {
                            System.out.print("Enter student department: ");
                            if (scanner.hasNextLine()) {
                                department = scanner.nextLine();
                                if (isValidDepartment(department)) {
                                    break;
                                } else {
                                    System.out.println("Invalid department. Please enter a valid department.");
                                }
                            } else {
                                scanner.next(); // Consume the invalid input
                                System.out.println("Invalid input. Please enter a valid department.");
                            }
                        }

                        registrationSystem.registerStudent(name, id, department);
                        break;

                    case 2:
                        registrationSystem.displayRegisteredStudents();
                        break;

                    case 3:
                        int editId;
                        do {
                            System.out.print("Enter student ID to edit: ");
                            try {
                                editId = scanner.nextInt();
                                scanner.nextLine(); // Consume the newline character
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid ID. Please enter a valid integer ID.");
                                scanner.nextLine(); // Consume the invalid input
                                editId = -1; // Set to a value that will trigger re-entry
                            }
                        } while (editId == -1);


                        String newDepartment;
                        while (true) {
                            System.out.print("Enter new department: ");
                            if (scanner.hasNextLine()) {
                                newDepartment = scanner.nextLine();
                                if (isValidDepartment(newDepartment)) {
                                    break;
                                } else {
                                    System.out.println("Invalid department. Please enter a valid department.");
                                }
                            } else {
                                scanner.next(); // Consume the invalid input
                                System.out.println("Invalid input. Please enter a valid department.");
                            }
                        }

                        registrationSystem.editStudent(editId, newDepartment);
                        break;

                    case 4:
                        int deleteId;
                        do {
                            System.out.print("Enter student ID to delete: ");
                            try {
                                deleteId = scanner.nextInt();
                                scanner.nextLine(); // Consume the newline character
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid ID. Please enter a valid integer ID.");
                                scanner.nextLine(); // Consume the invalid input
                                deleteId = -1; // Set to a value that will trigger re-entry
                            }
                        } while (deleteId == -1);

                        registrationSystem.deleteStudent(deleteId);
                        break;

                    case 5:
                        int searchId;
                        do {
                            System.out.print("Enter student ID to search: ");
                            try {
                                searchId = scanner.nextInt();
                                scanner.nextLine(); // Consume the newline character
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid ID. Please enter a valid integer ID.");
                                scanner.nextLine(); // Consume the invalid input
                                searchId = -1; // Set to a value that will trigger re-entry
                            }
                        } while (searchId == -1);

                        Student foundStudent = registrationSystem.searchStudent(searchId);
                        if (foundStudent != null) {
                            System.out.println("Student found:");
                            System.out.println("Name: " + foundStudent.getName() + ", ID: " + foundStudent.getId() + ", Department: " + foundStudent.getDepartment());
                        } else {
                            System.out.println("Student not found with ID " + searchId);
                        }
                        break;

                    case 6:
                        System.out.println("Exiting the program. Goodbye!");
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Consume the invalid input
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }

    // Method to check if a given name is valid
    private static boolean isValidName(String name) {
        return name != null && !name.trim().isEmpty() && name.matches("[a-zA-Z]+");
    }


    // Method to check if a given department is valid
    private static boolean isValidDepartment(String department) {
        return department != null && !department.trim().isEmpty() && department.matches("[a-zA-Z]+");
    }
}