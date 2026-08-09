package com.interviewQuestions.paymentGateway.user;

public class UserController {
    private UserService userService;

    public UserController() {
        this.userService = new UserService();
    }

    public UserDO addUser(UserDO userDo) {
        return userService.addUser(userDo);
    }

    public UserDO getUserById(int userId) {
        return userService.getUserById(userId);
    }
}