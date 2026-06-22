public class Main {
    public static void main(String[] args) {
        System.out.println("=== EXERCISE 4: Employee Management System ===\n");

        // Create Employee Manager
        EmployeeManager manager = new EmployeeManager();

        // ===== ADD EMPLOYEES =====
        System.out.println("--- Adding Employees ---");
        manager.addEmployee(new Employee(101, "John Doe", "Developer", 75000.00));
        manager.addEmployee(new Employee(102, "Jane Smith", "Manager", 90000.00));
        manager.addEmployee(new Employee(103, "Jack Wilson", "Analyst", 65000.00));
        manager.addEmployee(new Employee(104, "Emily Brown", "Designer", 70000.00));

        // ===== DISPLAY ALL =====
        manager.displayAllEmployees();

        // ===== SEARCH =====
        System.out.println("\n--- Searching for Employee 102 ---");
        Employee found = manager.searchEmployee(102);
        if (found != null) {
            System.out.println("Found: " + found);
        } else {
            System.out.println("Employee not found!");
        }

        System.out.println("\n--- Searching for Employee 999 (non-existent) ---");
        Employee notFound = manager.searchEmployee(999);
        if (notFound != null) {
            System.out.println("Found: " + notFound);
        } else {
            System.out.println("Employee not found!");
        }

        // ===== DELETE =====
        System.out.println("\n--- Deleting Employee 101 ---");
        manager.deleteEmployee(101);

        System.out.println("\n--- Deleting Employee 999 (non-existent) ---");
        manager.deleteEmployee(999);

        // ===== DISPLAY AFTER DELETE =====
        manager.displayAllEmployees();

        // ===== COMPLEXITY ANALYSIS =====
        System.out.println("\n=== Complexity Analysis ===");
        System.out.println("Array Operation Analysis:");
        System.out.println("1. Add Employee:");
        System.out.println("   - Best/Average Case: O(1) (add at end)");
        System.out.println("   - Worst Case: O(n) (when resizing)");
        System.out.println("   - Amortized: O(1)");
        System.out.println("\n2. Search Employee:");
        System.out.println("   - Best Case: O(1) (first element)");
        System.out.println("   - Worst Case: O(n) (last element or not found)");
        System.out.println("   - Average Case: O(n)");
        System.out.println("\n3. Delete Employee:");
        System.out.println("   - Best Case: O(1) (last element)");
        System.out.println("   - Worst Case: O(n) (first element - need to shift)");
        System.out.println("   - Average Case: O(n)");
        System.out.println("\n4. Traverse/Display:");
        System.out.println("   - Always O(n) (must visit all elements)");
        System.out.println("\n=== Array Limitations ===");
        System.out.println("1. Fixed size (though we resized dynamically)");
        System.out.println("2. O(n) for search and delete operations");
        System.out.println("3. Memory waste if array is large but data is small");
        System.out.println("\n=== When to Use Arrays ===");
        System.out.println("1. When you need fast O(1) access by index");
        System.out.println("2. When data size is known in advance");
        System.out.println("3. When you need memory-efficient storage");
        System.out.println("4. For static data that doesn't change often");
        System.out.println("5. When frequent search/delete operations are not needed");
    }
}
