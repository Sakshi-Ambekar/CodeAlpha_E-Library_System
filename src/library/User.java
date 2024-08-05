package library;

import java.util.*;
public class User {
    private String username;
    private String password;
    private List<Book> borrowedBooks;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.borrowedBooks = new ArrayList<>();
    }

    // Getters and Setters
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public List<Book> getBorrowedBooks() { return borrowedBooks; }
}
