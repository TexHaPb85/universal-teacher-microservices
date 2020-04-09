package edu.practice.authservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.Arrays;

//@SpringBootTest
class AuthServiceApplicationTests {

    @Test
    void contextLoads() {
        final String h = "he";
        String h1 = "hello";
        System.out.println(h1==h+"llo");
    }

    @Test
    void arrayDeclatarionTest(){
        int array[]={1,3,2,1};
        Arrays.stream(array).forEach(System.out::print);
    }

    @Test
    void tryTest(){
        try {
            System.out.println("c1");
            throw new IOException();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void inheritanseTest(){

    }

    @Test
    void switchCaseTest(){
        switch (4){
            case 1:
                System.out.println(1);
            case 2:
            default:
                System.out.println("def");
            case 4:
                System.out.println("win");
        }
    }
}
