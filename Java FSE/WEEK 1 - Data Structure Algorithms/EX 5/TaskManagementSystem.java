import java.util.*;
class Task {
    int taskId;
    String taskName;
    String status;
    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }
    @Override
    public String toString() {
        return "Tasks{" +"taskId=" + taskId +", taskName='" + taskName + '\''+", status='" + status + '\'' +'}';
    }
}
class Node {
    Task task;
    Node next;
    public Node(Task task) {
        this.task = task;
        this.next = null;
    }
}
//Linked List class
class TaskLinkedList {
    private Node head;
    public void add(Task task) {
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
    }
    public Task search(int taskId) {
        Node current = head;
        while (current != null) {
            if (current.task.taskId == taskId) {
                return current.task;
            }
            current = current.next;
        }
        return null;
    }
    public void traverse() {
        Node current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }
    public boolean delete(int taskId) {
        if (head == null) {
            return false;
        }
        if (head.task.taskId == taskId) {
            head = head.next;
            return true;
        }
        Node current = head;
        while (current.next != null && current.next.task.taskId != taskId) {
            current = current.next;
        }
        if (current.next == null) {
            return false;
        }
        current.next = current.next.next;
        return true;
    }
}
public class TaskManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskLinkedList taskList = new TaskLinkedList();
        while (true) {
            System.out.println("\n Task Management System");
            System.out.println("1. Add Task");
            System.out.println("2. Delete Task");
            System.out.println("4. Search Task");
            System.out.println("4. Traverse Tasks");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter task ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter task name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter task status: ");
                    String status = scanner.nextLine();
                    taskList.add(new Task(id, name, status));
                    System.out.println("Task added successfully.");
                    break;
                case 2:
                    System.out.print("Enter task ID to delete: ");
                    int Id = scanner.nextInt();
                    boolean deletedId = taskList.delete(Id);
                    if (deletedId) {
                        System.out.println("Task deleted successfully.");
                    } else {
                        System.out.println("Task not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter task ID to search: ");
                    int search = scanner.nextInt();
                    Task found = taskList.search(search);
                    if (found != null) {
                        System.out.println("Task found: " + found);
                    } else {
                        System.out.println("Task not found.");
                    }
                    break;
                case 4:
                    System.out.println("All tasks:");
                    taskList.traverse();
                    break;
                
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}