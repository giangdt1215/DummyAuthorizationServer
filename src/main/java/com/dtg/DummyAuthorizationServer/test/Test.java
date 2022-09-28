package com.dtg.DummyAuthorizationServer.test;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Test {

    public static void main(String[] args) {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("secret"));
        //$2a$10$mSbALyXgz0SkI7SeeWYXieR9Pt94/gy7qTMbBywAHKUcb8DOYlsKq
    }
}
