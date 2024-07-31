import java.util.*;
class Employee {
    int employeeId;
    String name;
    String position;
    double salary;
    Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }
    @Override
    public String toString() {
        return "ID: " + employeeId + ", Name: " + name + ", Position: " + position + ", Salary: " + salary;
    }
}
class EMS {
    private Employee[] employees;
    private int size;
    private int capacity;

    EMS(int capacity) {
        this.capacity = capacity;
        this.employees = new Employee[capacity];
        this.size = 0;
    }
    // Adding new employee
    public void add(Employee emp) {
        if (size < capacity) {
            employees[size] = emp;
            size++;
        } else {
            System.out.println("Array is full. Cannot add more employees.");
        }
    }
    // Searching a employee
    public Employee search(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].employeeId == employeeId) {
                return employees[i];
            }
        }
        return null;
    }
    // Display all employees
    public void traverse() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }
    // Deleting an employee
    public void delete(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].employeeId == employeeId) {
                employees[i] = employees[size - 1];
                employees[size - 1] = null;
                size--;
                return;
            }
        }
        System.out.println("Employee with ID " + employeeId + " not found.");
    }
}
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EMS ems = new EMS(10);
        while (true) {
            System.out.println("\n Employee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. Delete Employee");
            System.out.println("3. Search Employee");
            System.out.println("4. Traverse Employees");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter employee ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter position: ");
                    String position = scanner.nextLine();
                    System.out.print("Enter salary: ");
                    double salary = scanner.nextDouble();
                    Employee emp = new Employee(id, name, position, salary);
                    ems.add(emp);
                    break;
                case 2:
                    System.out.print("Enter employee ID to delete: ");
                    int deleteId = scanner.nextInt();
                    ems.delete(deleteId);
                    break;
                case 3:
                    System.out.print("Enter employee ID to search: ");
                    int searchId = scanner.nextInt();
                    Employee found = ems.search(searchId);
                    if (found != null) {
                        System.out.println("Employee found: " + found);
                    } else {
                        System.out.println("Employee not found.");
                    }
                    break;
                case 4:
                    ems.traverse();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}