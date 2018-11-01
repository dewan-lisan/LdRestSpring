package se.lisanuld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApplicationClass {
    public static void main(String[] args) {
        System.out.println("=========SYSTEM STARTED=========");
        SpringApplication.run(MainApplicationClass.class, args);
    }
}
