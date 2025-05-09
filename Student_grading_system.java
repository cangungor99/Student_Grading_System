/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.hw1.student_grading_system;

/**
 *
 * @author can
 */





import java.util.Scanner;

public class Student_grading_system {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Student Grading System ---");
            System.out.println("1. List Students");
            System.out.println("2. Insert Student");
            System.out.println("3. Edit Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Backup Students");
            System.out.println("6. Restore Students");
            System.out.println("7. List Courses");
            System.out.println("8. Insert Course");
            System.out.println("9. Edit Course");
            System.out.println("10. Delete Course");
            System.out.println("11. Backup Courses");
            System.out.println("12. Restore Courses");
            System.out.println("13. List Grades");
            System.out.println("14. Insert Grade");
            System.out.println("15. Edit Grade");
            System.out.println("16. Delete Grade");
            System.out.println("17. Backup Grades");
            System.out.println("18. Restore Grades");
            System.out.println("19. List Attendance");
            System.out.println("20. Insert Attendance");
            System.out.println("21. Edit Attendance");
            System.out.println("22. Delete Attendance");
            System.out.println("23. Backup Attendance");
            System.out.println("24. Restore Attendance");
            System.out.println("25. List Department");
            System.out.println("26. Insert Department");
            System.out.println("27. Edit Department");
            System.out.println("28. Delete Department");
            System.out.println("29. Backup Department");
            System.out.println("30. Restore Department");
            System.out.println("31. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: StudentCRUD.listStudents(); break;
                case 2: insertStudentInput(); break;
                case 3: editStudentInput(); break;
                case 4: deleteStudentInput(); break;
                case 5: Backup.backupStudents(); break;
                case 6: Restore.restoreStudents(); break;
                case 7: CourseCRUD.listCourses(); break;
                case 8: insertCourseInput(); break;
                case 9: editCourseInput(); break;
                case 10: deleteCourseInput(); break;
                case 11: Backup.backupCourses(); break;
                case 12: Restore.restoreCourses(); break;
                case 13: GradesCRUD.listGrades(); break;
                case 14: insertGradeInput(); break;
                case 15: editGradeInput(); break;
                case 16: deleteGradeInput(); break;
                case 17: Backup.backupGrades(); break;
                case 18: Restore.restoreGrades(); break;
                case 19: AttendanceCRUD.listAttendance(); break;
                case 20: insertAttendanceInput(); break;
                case 21: editAttendanceInput(); break;
                case 22: deleteAttendanceInput(); break;
                case 23: Backup.backupAttendance(); break;
                case 24: Restore.restoreAttendance(); break;
                case 25: listAllDepartmentsInput(); break;          
                case 26: insertDepartmentInput(); break;             
                case 27: editDepartmentInput(); break;               
                case 28: deleteDepartmentInput(); break;              
                case 29: backupDepartmentsInput(); break;        
                case 30: restoreDepartmentsInput(); break;            
                case 31: System.out.println("Exiting..."); break;     
                default: System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 31);
    }

    // Student CRUD
    public static void insertStudentInput() {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter Student No: ");
    String stdNo = sc.next();

    System.out.print("Enter First Name: ");
    String name = sc.next();

    System.out.print("Enter Last Name: ");
    String surname = sc.next();

    System.out.print("Enter Gender (M/F): ");
    char gender = sc.next().charAt(0);

    System.out.print("Enter Nationality: ");
    String nationality = sc.next();

    System.out.print("Enter Date of Birth (YYYY-MM-DD): ");
    String birthday = sc.next();

    // Tarih formatını java.sql.Date'e dönüştür
    java.sql.Date sqlBirthday;
    try {
        sqlBirthday = java.sql.Date.valueOf(birthday); // yyyy-MM-dd formatını bekler
    } catch (IllegalArgumentException e) {
        System.out.println("Invalid date format. Please use YYYY-MM-DD.");
        return; // Hatalı girişte metottan çık
    }

    // Öğrenci oluştur ve ekle
    Student student = new Student(stdNo, name, surname, gender, nationality, sqlBirthday);
    StudentCRUD.insertStudent(student);
}

  public static void editStudentInput() {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter Student ID to edit: ");
    int id = sc.nextInt();

    System.out.print("Enter New Student No: ");
    String stdNo = sc.next();

    System.out.print("Enter New First Name: ");
    String name = sc.next();

    System.out.print("Enter New Last Name: ");
    String surname = sc.next();

    System.out.print("Enter New Gender (M/F): ");
    char gender = sc.next().charAt(0);

    System.out.print("Enter New Nationality: ");
    String nationality = sc.next();

    System.out.print("Enter New Date of Birth (YYYY-MM-DD): ");
    String birthday = sc.next();

    // Tarih formatını java.sql.Date'e dönüştür
    java.sql.Date sqlBirthday;
    try {
        sqlBirthday = java.sql.Date.valueOf(birthday); // yyyy-MM-dd formatını bekler
    } catch (IllegalArgumentException e) {
        System.out.println("Invalid date format. Please use YYYY-MM-DD.");
        return; // Hatalı girişte metottan çık
    }

    // Öğrenci oluştur ve güncelle
    Student student = new Student(stdNo, name, surname, gender, nationality, sqlBirthday);
    student.setId(id); // ID'yi ayarla
    StudentCRUD.editStudent(student);
}

    public static void deleteStudentInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Student ID to delete: ");
        int id = sc.nextInt();

        StudentCRUD.deleteStudent(id);
    }

    // Course CRUD
    public static void insertCourseInput() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Department ID: ");
        int deptId = sc.nextInt();

        System.out.print("Enter Course Code: ");
        String crsCode = sc.next();

        System.out.print("Enter Course Name: ");
        String crsName = sc.next();

        Course course = new Course(0, deptId, crsCode, crsName);
        CourseCRUD.insertCourse(course);
    }

    public static void editCourseInput() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Course ID to edit: ");
        int crsId = sc.nextInt();

        System.out.print("Enter New Department ID: ");
        int deptId = sc.nextInt();

        System.out.print("Enter New Course Code: ");
        String crsCode = sc.next();

        System.out.print("Enter New Course Name: ");
        String crsName = sc.next();

        Course course = new Course(crsId, deptId, crsCode, crsName);
        CourseCRUD.updateCourse(course);
    }

    public static void deleteCourseInput() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Course ID to delete: ");
        int crsId = sc.nextInt();

        CourseCRUD.deleteCourse(crsId);
    }

    // Grades CRUD
    public static void insertGradeInput() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Student ID: ");
        int stdId = sc.nextInt();

        System.out.print("Enter Course ID: ");
        int crsId = sc.nextInt();

        System.out.print("Enter Midterm Grade: ");
        float grdMt = sc.nextFloat();

        System.out.print("Enter Homework Grade: ");
        float grdHw = sc.nextFloat();

        System.out.print("Enter Final Grade: ");
        float grdFinal = sc.nextFloat();

        System.out.print("Enter Letter Grade: ");
        String grdLgrade = sc.next();

        Grades grade = new Grades(stdId, crsId, grdMt, grdHw, grdFinal, grdLgrade);
        GradesCRUD.insertGrade(grade);
    }

    public static void editGradeInput() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Grade ID to edit: ");
        int grdId = sc.nextInt();

        System.out.print("Enter New Midterm Grade: ");
        float grdMt = sc.nextFloat();

        System.out.print("Enter New Homework Grade: ");
        float grdHw = sc.nextFloat();

        System.out.print("Enter New Final Grade: ");
        float grdFinal = sc.nextFloat();

        System.out.print("Enter New Letter Grade: ");
        String grdLgrade = sc.next();

        Grades grade = new Grades(grdId, 0, 0, grdMt, grdHw, grdFinal, grdLgrade);
        GradesCRUD.updateGrade(grade);
    }

    public static void deleteGradeInput() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Grade ID to delete: ");
        int grdId = sc.nextInt();

        GradesCRUD.deleteGrade(grdId);
    }

    // Attendance CRUD
    public static void insertAttendanceInput() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Student ID: ");
        int stdId = sc.nextInt();

        System.out.print("Enter Course ID: ");
        int crsId = sc.nextInt();

        System.out.print("Enter Attendance Date (YYYY-MM-DD): ");
        String attDate = sc.next();

        Attendance attendance = new Attendance(stdId, crsId, attDate);
        AttendanceCRUD.insertAttendance(attendance);
    }

    public static void deleteAttendanceInput() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Attendance ID to delete: ");
        int attId = sc.nextInt();

        AttendanceCRUD.deleteAttendance(attId);
    }
    public static void editAttendanceInput() {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter Attendance ID to edit: ");
    int attId = sc.nextInt();

    System.out.print("Enter New Student ID: ");
    int stdId = sc.nextInt();

    System.out.print("Enter New Course ID: ");
    int crsId = sc.nextInt();

    System.out.print("Enter New Attendance Date (YYYY-MM-DD): ");
    String attDate = sc.next();

    Attendance attendance = new Attendance(attId, stdId, crsId, attDate);
    AttendanceCRUD.updateAttendance(attendance);

    System.out.println("Attendance successfully updated.");
}
    
    public static void insertDepartmentInput() {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter Department Name: ");
    String deptName = sc.next();

    Department department = new Department(deptName);
    DepartmentCRUD.addDepartment(department);

    System.out.println("Department successfully added.");
}

    public static void editDepartmentInput() {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter Department ID to edit: ");
    int deptId = sc.nextInt();

    System.out.print("Enter New Department Name: ");
    String deptName = sc.next();

    Department department = new Department(deptId, deptName);
    DepartmentCRUD.editDepartment(department);

    System.out.println("Department successfully updated.");
}

    public static void deleteDepartmentInput() {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter Department ID to delete: ");
    int deptId = sc.nextInt();

    DepartmentCRUD.deleteDepartment(deptId);

    System.out.println("Department successfully deleted.");
}

    
    public static void listAllDepartmentsInput() {
    System.out.println("Listing all departments:");
    DepartmentCRUD.listAllDepartments();
}


    public static void listDepartmentInput() {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter Department ID to view: ");
    int deptId = sc.nextInt();

    DepartmentCRUD.listDepartment(deptId);
}

    public static void backupDepartmentsInput() {
    DepartmentCRUD.backupDepartments();
    System.out.println("Departments successfully backed up.");
}

    public static void restoreDepartmentsInput() {
    DepartmentCRUD.restoreDepartments();
    System.out.println("Departments successfully restored.");
}

}