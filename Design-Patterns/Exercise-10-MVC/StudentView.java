public class StudentView {
    public void displayStudentDetails(Student student) {
        System.out.println("\n=== Student Details ===");
        System.out.println("Student ID: " + student.getId());
        System.out.println("Student Name: " + student.getName());
        System.out.println("Student Grade: " + student.getGrade());
        System.out.println("=======================");
    }

    public void displayMessage(String message) {
        System.out.println("Message: " + message);
    }
}
