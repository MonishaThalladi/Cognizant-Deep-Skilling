public class Main {
    public static void main(String[] args) {
        System.out.println("=== EXERCISE 5: Task Management System ===\n");

        // Create Task Manager
        TaskManager manager = new TaskManager();

        // ===== ADD TASKS =====
        System.out.println("--- Adding Tasks ---");
        manager.addTask(new Task(101, "Complete Project", "In Progress"));
        manager.addTask(new Task(102, "Review Code", "Pending"));
        manager.addTask(new Task(103, "Fix Bugs", "Not Started"));
        manager.addTask(new Task(104, "Write Documentation", "Pending"));
        manager.addTask(new Task(105, "Deploy to Server", "Not Started"));

        // ===== DISPLAY ALL =====
        manager.displayAllTasks();

        // ===== SEARCH =====
        System.out.println("\n--- Searching for Task 102 ---");
        Task found = manager.searchTask(102);
        if (found != null) {
            System.out.println("Found: " + found);
        }

        System.out.println("\n--- Searching for Task 999 (non-existent) ---");
        manager.searchTask(999);

        // ===== DELETE =====
        System.out.println("\n--- Deleting Task 101 ---");
        manager.deleteTask(101);

        System.out.println("\n--- Deleting Task 104 ---");
        manager.deleteTask(104);

        System.out.println("\n--- Deleting Task 999 (non-existent) ---");
        manager.deleteTask(999);

        // ===== DISPLAY AFTER DELETE =====
        manager.displayAllTasks();

        // ===== ADD AT END =====
        System.out.println("\n--- Adding Task at End ---");
        manager.addTaskAtEnd(new Task(106, "Testing", "Pending"));

        manager.displayAllTasks();

        // ===== COMPLEXITY ANALYSIS =====
        System.out.println("\n=== Complexity Analysis ===");
        System.out.println("Singly Linked List Operations:");
        System.out.println("1. Add at Beginning:");
        System.out.println("   - Time Complexity: O(1)");
        System.out.println("   - Just change head pointer");
        System.out.println("\n2. Add at End:");
        System.out.println("   - Time Complexity: O(n)");
        System.out.println("   - Must traverse to find last node");
        System.out.println("\n3. Search Task:");
        System.out.println("   - Time Complexity: O(n)");
        System.out.println("   - Must traverse until found or end");
        System.out.println("\n4. Delete Task:");
        System.out.println("   - Time Complexity: O(n)");
        System.out.println("   - Must find previous node to update pointer");
        System.out.println("\n5. Traverse/Display:");
        System.out.println("   - Time Complexity: O(n)");
        System.out.println("   - Must visit all nodes");

        System.out.println("\n=== Advantages of Linked Lists over Arrays ===");
        System.out.println("1. Dynamic Size: Can grow/shrink as needed");
        System.out.println("2. O(1) Insert/Delete at beginning: No shifting required");
        System.out.println("3. Efficient Memory: Only uses what it needs");
        System.out.println("4. No Size Limitation: Not fixed like arrays");
        System.out.println("5. Easy to Insert/Delete: Just change pointers");

        System.out.println("\n=== Disadvantages of Linked Lists ===");
        System.out.println("1. O(n) Access Time: No random access");
        System.out.println("2. Extra Memory: Each node needs a pointer");
        System.out.println("3. Cache Unfriendly: Nodes are scattered in memory");
        System.out.println("4. More Complex: Requires pointer management");

        System.out.println("\n=== When to Use Linked Lists ===");
        System.out.println("1. When you frequently insert/delete at beginning");
        System.out.println("2. When data size is unknown or changes frequently");
        System.out.println("3. When you don't need random access by index");
        System.out.println("4. When memory is a concern (only use what you need)");
        System.out.println("5. For implementing stacks, queues, and graphs");
    }
}
