package library;

import java.util.*;

public class UserAuthentication {
    private Map<String, User> users;

    public UserAuthentication() {
        users = new HashMap<>();
        // Pre-adding some users (for demonstration)
        users.put("admin", new User("admin", "admin123"));
        users.put("shiva", new User("shiva", "shiva123"));
        users.put("sakshi", new User("sakshi", "sakshi123"));
        users.put("ram", new User("ram", "ram123"));
        users.put("sita", new User("sita", "sita123"));
    }

    public boolean authenticate(String username, String password) {
        User user = users.get(username);
        return user != null && user.getPassword().equals(password);
    }

    public void addUser(String username, String password) {
        users.put(username, new User(username, password));
    }
}
