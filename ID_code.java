/**
 * This program uses a HashMap to store and retrieve detailed student information
 * efficiently, using a unique Student ID as the key for quick lookups.
 * It now includes functionality to add new student records interactively,
 * with improved input validation for numeric fields.
 */

import java.util.Scanner;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// Static variable to track the next ID number suffix (e.g., 5582)
public class StudentDatabase {
    // The base prefix for the student IDs
    private static final String ID_PREFIX = "24-25STU";
    // This variable will hold the highest existing ID number + 1, ensuring uniqueness.
    private static int nextStudentIdSuffix = 0; 
    
    // 1. Define the Student class with all necessary fields.
    static class Student {
        private String studentId;
        private String name;
        private String address;
        private int studentClass;
        private List<String> subjects;
        private String dateOfBirth; 
        private String phoneNumber; 

        public Student(String studentId, String name, String address, int studentClass, List<String> subjects, String dateOfBirth, String phoneNumber) {
            this.studentId = studentId;
            this.name = name;
            this.address = address;
            this.studentClass = studentClass;
            this.subjects = subjects;
            this.dateOfBirth = dateOfBirth;
            this.phoneNumber = phoneNumber;
        }

        // Method to neatly format and print all details of this student
        public void printDetails() {
            System.out.println("\n==================================================");
            System.out.println("           STUDENT DETAILS - ID: " + studentId);
            System.out.println("==================================================");
            System.out.printf("%-15s %s\n", "Name:", name);
            System.out.printf("%-15s %s\n", "Class:", studentClass);
            System.out.printf("%-15s %s\n", "Date of Birth:", dateOfBirth);
            System.out.printf("%-15s %s\n", "Phone Number:", phoneNumber);
            System.out.printf("%-15s %s\n", "Address:", address);
            System.out.printf("%-15s %s\n", "Subjects:", subjects);
            System.out.println("==================================================");
        }
    }

    /**
     * Finds the maximum suffix from the existing IDs in the database 
     * and sets the starting point for the ID generator.
     */
    private static void initializeIdCounter(Map<String, Student> database) {
        int maxSuffix = 0;
        for (String id : database.keySet()) {
            // Check if the ID starts with the expected prefix
            if (id.startsWith(ID_PREFIX) && id.length() > ID_PREFIX.length()) {
                try {
                    // Extract the numerical part of the ID (e.g., "5567")
                    String suffixStr = id.substring(ID_PREFIX.length());
                    int suffix = Integer.parseInt(suffixStr);
                    if (suffix > maxSuffix) {
                        maxSuffix = suffix;
                    }
                } catch (NumberFormatException e) {
                    // Ignore IDs that don't end in numbers
                    System.err.println("Warning: Found invalid student ID format: " + id);
                }
            }
        }
        // Set the next ID suffix to be one greater than the max found
        nextStudentIdSuffix = maxSuffix + 1;
        System.out.println("ID Counter initialized. Next new ID suffix will be: " + nextStudentIdSuffix);
    }

    /**
     * Generates the next unique student ID in the format 24-25STUXXXX
     */
    private static String generateNextStudentId() {
        String newId = ID_PREFIX + nextStudentIdSuffix;
        nextStudentIdSuffix++; // Increment the counter for the next student
        return newId;
    }
    
    // Helper method to create and populate the HashMap with all student data
    private static Map<String, Student> createStudentDatabase() {
        Map<String, Student> database = new HashMap<>();

        // 2. Initial 5 Students 
        database.put("24-25STU5567", new Student(
            "24-25STU5567", "Sumit", "701 Green St, Mumbai", 10,
            Arrays.asList("Advanced Mathematics", "Physics", "English"),
            "15/05/2009", "9876543210"
        ));

        database.put("24-25STU5568", new Student(
            "24-25STU5568", "Ajay", "25 Residency Rd, Delhi", 12,
            Arrays.asList("Chemistry", "Biology", "Computer Science"),
            "03/11/2007", "9000011111"
        ));

        database.put("24-25STU5569", new Student(
            "24-25STU5569", "Anuj", "14 Lake View, Bangalore", 9,
            Arrays.asList("History", "Geography", "Art", "Science"),
            "20/08/2010", "8585858585"
        ));

        database.put("24-25STU5570", new Student(
            "24-25STU5570", "Gorkhe", "88 Industrial Area, Pune", 11,
            Arrays.asList("Economics", "Business Studies", "Literature"),
            "10/01/2008", "7776665554"
        ));
        
        database.put("24-25STU5571", new Student(
            "24-25STU5571", "Deepak", "100 MG Road, Chennai", 10,
            Arrays.asList("Physical Education", "Math", "Hindi"),
            "29/04/2009", "9998887776"
        ));
        
        // 3. Adding 10 More Students for a total of 15
        database.put("24-25STU5572", new Student(
            "24-25STU5572", "Priya Sharma", "404 North Avenue, Hyderabad", 12,
            Arrays.asList("Physics", "Chemistry", "Math"),
            "12/12/2007", "9123456789"
        ));

        database.put("24-25STU5573", new Student(
            "24-25STU5573", "Rohan Verma", "B-12 Sector 10, Noida", 9,
            Arrays.asList("Science", "Sanskrit", "Computer Apps"),
            "01/03/2010", "8765432109"
        ));

        database.put("24-25STU5574", new Student(
            "24-25STU5574", "Kavita Singh", "55 Defence Colony, Kolkata", 11,
            Arrays.asList("Psychology", "Sociology", "English"),
            "25/06/2008", "7654321098"
        ));

        database.put("24-25STU5575", new Student(
            "24-25STU5575", "Vikram Das", "Plot 30, New Town, Ranchi", 10,
            Arrays.asList("Commerce", "Accounts", "Economics"),
            "14/09/2009", "9012345678"
        ));

        database.put("24-25STU5576", new Student(
            "24-25STU5576", "Nisha Patel", "House 1, Old City, Ahmedabad", 12,
            Arrays.asList("Fine Arts", "History", "Literature"),
            "05/02/2007", "9900990099"
        ));
        
        database.put("24-25STU5577", new Student(
            "24-25STU5577", "Sanjay Rai", "18/A Hill Road, Guwahati", 9,
            Arrays.asList("General Science", "Math", "Assamese"),
            "17/07/2010", "8080808080"
        ));

        database.put("24-25STU5578", new Student(
            "24-25STU5578", "Meena Joshi", "Flat 302, Cyber Hub, Gurgaon", 11,
            Arrays.asList("IT Systems", "Networking", "Database Mgmt"),
            "08/10/2008", "7070707070"
        ));

        database.put("24-25STU5579", new Student(
            "24-25STU5579", "Rahul Goyal", "45 Park Street, Lucknow", 10,
            Arrays.asList("Chemistry", "Biology", "Environmental Science"),
            "21/01/2009", "9555544444"
        ));

        database.put("24-25STU5580", new Student(
            "24-25STU5580", "Shruti Bedi", "2A Garden View, Jaipur", 12,
            Arrays.asList("Political Science", "Law Studies", "Public Admin"),
            "04/03/2007", "8123459876"
        ));

        database.put("24-25STU5581", new Student(
            "24-25STU5581", "Arjun Nair", "1st Floor, Main Bazaar, Kochi", 11,
            Arrays.asList("Physics", "Electronics", "Math"),
            "30/11/2008", "9999900000"
        ));

        return database;
    }

    /**
     * Handles the interactive process of gathering new student data from the user
     * and adding it to the database. Includes robust input validation for Class.
     */
    private static void addNewStudent(Scanner scanner, Map<String, Student> database) {
        System.out.println("\n--- ADD NEW STUDENT RECORD ---");
        
        // 1. Generate unique ID
        String newId = generateNextStudentId();
        System.out.println("New unique Student ID generated: " + newId);

        // 2. Gather input (string inputs are simple)
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine().trim();

        int studentClass = 0;
        boolean validInput = false;
        // Input validation loop for studentClass: ensures a valid integer is entered
        do {
            System.out.print("Enter Student Class (e.g., 10): ");
            String classInput = scanner.nextLine().trim();
            try {
                studentClass = Integer.parseInt(classInput);
                validInput = true; // Input is valid, exit loop
            } catch (NumberFormatException e) {
                System.err.println("Invalid input. Please enter a valid number for the class (e.g., 9, 10, 11).");
            }
        } while (!validInput);

        System.out.print("Enter Student Address: ");
        String address = scanner.nextLine().trim();

        System.out.print("Enter Date of Birth (DD/MM/YYYY): ");
        String dob = scanner.nextLine().trim();

        System.out.print("Enter Phone Number: ");
        String phone = scanner.nextLine().trim();

        System.out.print("Enter Subjects (comma-separated, e.g., Math, Science, English): ");
        String subjectsInput = scanner.nextLine().trim();
        // Convert comma-separated string into a List of Strings
        List<String> subjects = Arrays.asList(subjectsInput.split(",\\s*"));

        // 3. Create the new Student object
        Student newStudent = new Student(
            newId, 
            name, 
            address, 
            studentClass, 
            subjects, 
            dob, 
            phone
        );

        // 4. Save the new student to the HashMap
        database.put(newId, newStudent);

        System.out.println("\n*** SUCCESS! New student record saved. ***");
        newStudent.printDetails();
    }
    
    // --- MAIN EXECUTION METHOD ---
    public static void main(String[] args) {
        // Initialize the database map
        Map<String, Student> studentDatabase = createStudentDatabase();
        // Initialize the counter based on the loaded data
        initializeIdCounter(studentDatabase); 
        
        Scanner scanner = new Scanner(System.in);
        String choice = "";

        System.out.println("\n*** Welcome to the Student Database System ***");
        System.out.println("The database currently contains " + studentDatabase.size() + " student records.");
        

        // Loop to allow the user to search or add multiple times
        while (true) {
            System.out.println("\n--------------------------------------------------");
            System.out.println("What would you like to do?");
            System.out.println("1. Search Student by ID (e.g., 24-25STU5567)");
            System.out.println("2. Add New Student Record");
            System.out.println("3. Exit Program");
            System.out.print("Enter your choice (1, 2, or 3): ");
            
            choice = scanner.nextLine().trim(); 

            if (choice.equals("3") || choice.equalsIgnoreCase("exit")) {
                System.out.println("Thank you for using the system. Goodbye!");
                break;
            } else if (choice.equals("2")) {
                // Call the method to add a student
                addNewStudent(scanner, studentDatabase);

            } else if (choice.equals("1")) {
                // Search logic 
                System.out.print("\nPlease type the **FULL Student ID** to search: ");
                String searchId = scanner.nextLine().trim(); 

                Student foundStudent = studentDatabase.get(searchId); 

                if (foundStudent != null) {
                    foundStudent.printDetails();
                } else {
                    System.out.println("\n--- ID NOT FOUND ---");
                    System.out.println("The Student ID '" + searchId + "' was not found in the database.");
                    System.out.println("Please ensure the ID is typed correctly.");
                    System.out.println("--------------------");
                }
            } else {
                System.out.println("\nInvalid choice. Please enter 1, 2, or 3.");
            }
        }

        // Close the scanner when done
        scanner.close();
    }
          }
