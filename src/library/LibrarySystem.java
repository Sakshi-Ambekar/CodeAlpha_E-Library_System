package library;

import java.util.*;


public class LibrarySystem {
    private List<Book> books;
    private UserAuthentication userAuth;

    public LibrarySystem() {
        books = new ArrayList<>();
        userAuth = new UserAuthentication();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void borrowBook(String title, User user) {
        for (Book book : books) {
            if (book.getTitle().equals(title) && !book.isBorrowed()) {
                book.setBorrowed(true);
                user.getBorrowedBooks().add(book);
                System.out.println("Book borrowed: " + title);
                return;
            }
        }
        System.out.println("Book not available: " + title);
    }

    public void returnBook(String title, User user) {
        for (Book book : user.getBorrowedBooks()) {
            if (book.getTitle().equals(title)) {
                book.setBorrowed(false);
                user.getBorrowedBooks().remove(book);
                books.add(book);
                System.out.println("Book returned: " + title);
                return;
            }
        }
        System.out.println("Book not found in user's borrowed list: " + title);
    }

    public List<Book> searchByCategory(String category) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getCategory().equalsIgnoreCase(category)) {
                result.add(book);
            }
        }
        return result;
    }

    public UserAuthentication getUserAuth() {
        return userAuth;
    }
}

