public class Main {
    public static void main(String[] args) {
        System.out.println("=== EXERCISE 10: MVC Pattern ===\n");

        // ===== STUDENT 1 =====
        System.out.println("--- Student 1: John Doe ---");

        // Create Model
        Student student1 = new Student("John Doe", 101, "A");

        // Create View
        StudentView view1 = new StudentView();

        // Create Controller
        StudentController controller1 = new StudentController(student1, view1);

        // Display initial state
        controller1.updateView();

        // Update student details
        System.out.println("\nUpdating student details...");
        controller1.setStudentName("John Smith");
        controller1.setStudentGrade("A+");

        // Display updated state
        controller1.updateView();

        // ===== STUDENT 2 =====
        System.out.println("\n--- Student 2: Jane Doe ---");

        Student student2 = new Student("Jane Doe", 102, "B");
        StudentView view2 = new StudentView();
        StudentController controller2 = new StudentController(student2, view2);

        controller2.updateView();

        System.out.println("\nUpdating student details...");
        controller2.bulkUpdate("Jane Smith", "A");

        // ===== STUDENT 3 =====
        System.out.println("\n--- Student 3: Bob Johnson ---");

        Student student3 = new Student("Bob Johnson", 103, "C");
        StudentView view3 = new StudentView();
        StudentController controller3 = new StudentController(student3, view3);

        controller3.updateView();

        System.out.println("\nUpdating student details...");
        controller3.displayStudentWithMessage("Updating Bob's grade...");
        controller3.setStudentGrade("B+");
        controller3.updateView();

        // ===== INTERACT WITH CONTROLLER =====
        System.out.println("\n--- Interacting with Controller ---");
        System.out.println("Current student name: " + controller1.getStudent().getName());
        System.out.println("Current student grade: " + controller1.getStudent().getGrade());

        System.out.println("\n=== Benefits of MVC Pattern ===");
        System.out.println("1. Separation of concerns (Model, View, Controller)");
        System.out.println("2. Multiple views can display same model");
        System.out.println("3. Code reusability");
        System.out.println("4. Maintainability");
        System.out.println("5. Testability");

        System.out.println("\n=== Real-world Use Cases ===");
        System.out.println("1. Web frameworks (Spring MVC, Django, Ruby on Rails)");
        System.out.println("2. Desktop applications");
        System.out.println("3. Mobile applications");
        System.out.println("4. User interfaces");
        System.out.println("5. Dashboard applications");
    }
}
