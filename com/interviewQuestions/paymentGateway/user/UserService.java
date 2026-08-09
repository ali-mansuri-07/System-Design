package com.interviewQuestions.paymentGateway.user;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    static List<User> users = new ArrayList<>();

    public UserDO addUser(UserDO userDo) {
        User userObj = new User();
        userObj.setUserId(userDo.getUserId());
        userObj.setUserName(userDo.getUserName());
        userObj.setEmail(userDo.getEmail());
        users.add(userObj);
        return convertUserDOToUser(userObj);
    }

    private UserDO convertUserDOToUser(User userObj) {
        UserDO userDo = new UserDO(userObj.getUserId(), userObj.getUserName(), userObj.getEmail());
        return userDo;
    }

    public UserDO getUserById(int userId) {
        for (User user : users) {
            if (user.getUserId() == userId) {
                return convertUserDOToUser(user);
            }
        }
        return null; // User not found
    }
}
