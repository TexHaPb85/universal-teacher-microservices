package edu.practice.englishstudyservice;

import edu.practice.englishstudyservice.domain.serving.RegistrationForm;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ReflectionApiTest {
    @Test
    void test(){
        String s = "add";
        RegistrationForm registrationForm = new RegistrationForm();
        System.out.println(Arrays.toString(registrationForm.getClass().getFields()));
        try {
            System.out.println(registrationForm.getClass().getField("username"));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        Object o;

    }
}
