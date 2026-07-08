package com.sudharsan;

public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
        System.out.println("UserService object created");
    }
    public void printRepository(){
        System.out.println(userRepository);
    }
}
