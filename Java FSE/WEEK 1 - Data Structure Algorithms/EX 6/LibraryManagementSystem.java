import java.util.*;
class Book implements Comparable<Book> {
    int bookId;
    String title;
    String author;
    Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }
    @Override
    public int compareTo(Book other) {
        return this.title.compareTo(other.title);
    }
    @Override
    public String toString() {
        return "BookId: " + bookId + ", Title: " + title + ", Author: " + author;
    }
}
class LMS {
    private Book[] books;
    private int size;
    private int capacity;
    LMS(int capacity) {
        this.capacity = capacity;
        this.books = new Book[capacity];
        this.size = 0;
    }
    public void add(Book book) {
        if (size < capacity) {
            books[size] = book;
            size++;
        } 
        else {
            System.out.println("Array is full. Cannot add more books.");
        }
    }
    public Book linearsearch(String title) {
        for (int i = 0; i < size; i++) {
            if (books[i].title.equalsIgnoreCase(title)) {
                return books[i];
            }
        }
        return null;
    }
    public Book binarysearch(String title) {
        int left = 0;
        int right = size - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int compare = books[mid].title.compareToIgnoreCase(title);
            if (compare == 0) {
                return books[mid];
            } else if (compare < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }
    public void sort() {
        Arrays.sort(books, 0, size);
    }
    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.println(books[i]);
        }
    }
}
public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LMS lms = new LMS(10);
        while (true) {
            System.out.println("\n Library Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Linear Search");
            System.out.println("3. Binary Search");
            System.out.println("4. Display Books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter book ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    Book book = new Book(id, title, author);
                    lms.add(book);
                    lms.sort();
                    break;
                case 2:
                    System.out.print("Enter title to search: ");
                    String Lsearch = scanner.nextLine();
                    Book Lfound = lms.linearsearch(Lsearch);
                    if (Lfound != null) {
                        System.out.println("Book found: " + Lfound);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter title to search: ");
                    String Bsearch = scanner.nextLine();
                    Book Bfound = lms.binarysearch(Bsearch);
                    if (Bfound != null) {
                        System.out.println("Book found: " + Bfound);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 4:
                    lms.display();
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