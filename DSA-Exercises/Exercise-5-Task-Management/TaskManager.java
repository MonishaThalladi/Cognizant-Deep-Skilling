public class TaskManager {
    // ===== NODE CLASS =====
    private class Node {
        Task task;
        Node next;

        Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    private Node head;  // First node in the list
    private int size;   // Number of tasks

    public TaskManager() {
        this.head = null;
        this.size = 0;
    }

    // ===== ADD TASK =====
    // Time Complexity: O(1) - add at beginning
    public void addTask(Task task) {
        Node newNode = new Node(task);
        newNode.next = head;
        head = newNode;
        size++;
        System.out.println("Added (at beginning): " + task);
    }

    // Alternative: Add at end - O(n)
    public void addTaskAtEnd(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
        System.out.println("Added (at end): " + task);
    }

    // ===== SEARCH TASK =====
    // Time Complexity: O(n)
    public Task searchTask(int taskId) {
        Node current = head;
        int position = 0;
        while (current != null) {
            if (current.task.getTaskId() == taskId) {
                System.out.println("Found at position: " + position);
                return current.task;
            }
            current = current.next;
            position++;
        }
        System.out.println("Task with ID " + taskId + " not found!");
        return null;
    }

    // ===== TRAVERSE/DISPLAY ALL =====
    // Time Complexity: O(n)
    public void displayAllTasks() {
        System.out.println("\n=== Task List (" + size + " tasks) ===");
        if (head == null) {
            System.out.println("No tasks in the system.");
            return;
        }

        Node current = head;
        int position = 0;
        while (current != null) {
            System.out.println((position + 1) + ". " + current.task);
            current = current.next;
            position++;
        }
    }

    // ===== DELETE TASK =====
    // Time Complexity: O(n)
    public void deleteTask(int taskId) {
        if (head == null) {
            System.out.println("Task list is empty!");
            return;
        }

        // If head is the task to delete
        if (head.task.getTaskId() == taskId) {
            System.out.println("Deleted: " + head.task);
            head = head.next;
            size--;
            return;
        }

        // Search for the task to delete
        Node current = head;
        while (current.next != null && current.next.task.getTaskId() != taskId) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Task with ID " + taskId + " not found!");
        } else {
            System.out.println("Deleted: " + current.next.task);
            current.next = current.next.next;
            size--;
        }
    }

    // ===== GET SIZE =====
    public int getSize() {
        return size;
    }

    // ===== CHECK IF EMPTY =====
    public boolean isEmpty() {
        return head == null;
    }
}
