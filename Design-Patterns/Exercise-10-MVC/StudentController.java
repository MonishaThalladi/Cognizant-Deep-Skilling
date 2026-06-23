public class StudentController {
    private Student model;
    private StudentView view;

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    // Update student name
    public void setStudentName(String name) {
        model.setName(name);
        view.displayMessage("Student name updated to: " + name);
    }

    // Update student grade
    public void setStudentGrade(String grade) {
        model.setGrade(grade);
        view.displayMessage("Student grade updated to: " + grade);
    }

    // Get student details
    public Student getStudent() {
        return model;
    }

    // Update view
    public void updateView() {
        view.displayStudentDetails(model);
    }

    // Display student details with custom message
    public void displayStudentWithMessage(String message) {
        view.displayMessage(message);
        view.displayStudentDetails(model);
    }

    // Bulk update
    public void bulkUpdate(String name, String grade) {
        model.setName(name);
        model.setGrade(grade);
        view.displayMessage("Student details updated successfully!");
        updateView();
    }
}
