package services;

import sub.*;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public void displayAllUsers() {
        for (User user : users) {
            user.displayDetails();
        }
    }
}
