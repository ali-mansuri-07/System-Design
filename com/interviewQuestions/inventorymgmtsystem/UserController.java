package com.interviewQuestions.inventorymgmtsystem;

import java.util.List;

public class UserController {
    List<User> userList;

    public UserController(List<User> userList) {
        this.userList = userList;
    }

    public void addUser(User user) {
        userList.add(user);
    }

    public void removeUser(User user) {
        userList.remove(user);
    }

    public User getUserById(int userId) {
        for (User user : userList) {
            if (user.userId == userId) {
                return user;
            }
        }
        return null;
    }

}
