import java.util.Arrays;

public class EmployeeManager {
    private Employee[] employees;
    private int count;
    private static final int INITIAL_CAPACITY = 10;

    public EmployeeManager() {
        employees = new Employee[INITIAL_CAPACITY];
        count = 0;
    }

    // ===== ADD EMPLOYEE =====
    // Time Complexity: O(1) amortized
    public void addEmployee(Employee emp) {
        if (count == employees.length) {
            employees = Arrays.copyOf(employees, employees.length * 2);
            System.out.println("Array resized to: " + employees.length);
        }
        employees[count++] = emp;
        System.out.println("Added: " + emp);
    }

    // ===== SEARCH EMPLOYEE =====
    // Time Complexity: O(n)
    public Employee searchEmployee(int employeeId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

    // ===== TRAVERSE/DISPLAY ALL =====
    // Time Complexity: O(n)
    public void displayAllEmployees() {
        System.out.println("\n=== Employee List (" + count + " employees) ===");
        if (count == 0) {
            System.out.println("No employees in the system.");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + employees[i]);
        }
    }

    // ===== DELETE EMPLOYEE =====
    // Time Complexity: O(n)
    public void deleteEmployee(int employeeId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                System.out.println("Deleted: " + employees[i]);
                employees[i] = employees[count - 1];
                employees[count - 1] = null;
                count--;
                return;
            }
        }
        System.out.println("Employee with ID " + employeeId + " not found!");
    }

    // ===== GET CURRENT SIZE =====
    public int getSize() {
        return count;
    }
}
