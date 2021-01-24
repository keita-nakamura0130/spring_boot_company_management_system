package com.keita.nakamura.service;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class A {

    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("password"));
    }
}