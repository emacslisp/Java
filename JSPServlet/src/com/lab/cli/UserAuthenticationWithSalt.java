package com.lab.cli;

import com.lab.User;

public class UserAuthenticationWithSalt {
    public static void main(String[] args) {
        User user = new User("java.gdb@gmail.com", "123456789");
       
        if(user.validate()) {
        	System.out.println("Bean validates OK.");
        }
        else {
        	System.out.println(user.getMessage());
        }
    }
}
