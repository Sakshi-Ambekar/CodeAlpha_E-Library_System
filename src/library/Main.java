package library;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();
        Scanner scanner = new Scanner(System.in);

        // Sample data
        librarySystem.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", "Fiction"));
        librarySystem.addBook(new Book("1984", "George Orwell", "Dystopian"));
        librarySystem.addBook(new Book("To Kill a Mockingbird", "Harper Lee", "Fiction"));
        librarySystem.addBook(new Book("Brave New World", "Aldous Huxley", "Dystopian"));
        librarySystem.addBook(new Book("Moby Dick", "Herman Melville", "Adventure"));

        // Pre-adding users to the authentication system
        librarySystem.getUserAuth().addUser("admin", "admin123");
        librarySystem.getUserAuth().addUser("shiva", "shiva123");
        librarySystem.getUserAuth().addUser("sakshi", "sakshi123");
        librarySystem.getUserAuth().addUser("ram", "ram123");
        librarySystem.getUserAuth().addUser("sita", "sita123");

        // User login
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (librarySystem.getUserAuth().authenticate(username, password)) {
            User user = new User(username, password);  // This should ideally be fetched from the authentication system
            System.out.println("Login successful!");

            // Library operations
            System.out.println("Enter a command (borrow/return/search/exit): ");
            while (scanner.hasNext()) {
                String command = scanner.nextLine();
                if (command.equalsIgnoreCase("exit")) break;

                switch (command.toLowerCase()) {
                    case "borrow":
                        System.out.print("Enter book title to borrow: ");
                        String borrowTitle = scanner.nextLine();
                        librarySystem.borrowBook(borrowTitle, user);
                        break;
                    case "return":
                        System.out.print("Enter book title to return: ");
                        String returnTitle = scanner.nextLine();
                        librarySystem.returnBook(returnTitle, user);
                        break;
                    case "search":
                        System.out.print("Enter category to search: ");
                        String category = scanner.nextLine();
                        List<Book> books = librarySystem.searchByCategory(category);
                        if (books.isEmpty()) {
                            System.out.println("No books found in the " + category + " category.");
                        } else {
                            books.forEach(book -> System.out.println(book.getTitle() + " by " + book.getAuthor()));
                        }
                        break;
                    default:
                        System.out.println("Unknown command. Try again.");
                }

                System.out.println("Enter a command (borrow/return/search/exit): ");
            }
        } else {
            System.out.println("Login failed!");
        }

        scanner.close();
    }
}

