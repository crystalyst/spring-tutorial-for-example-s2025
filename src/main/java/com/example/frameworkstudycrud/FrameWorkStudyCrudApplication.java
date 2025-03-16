package com.example.frameworkstudycrud;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FrameWorkStudyCrudApplication {

    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
        // ✅ .env 값이 정상적으로 로드되는지 출력
        System.out.println("DB_NAME: " + dotenv.get("DB_NAME"));
        System.out.println("USER_NAME: " + dotenv.get("USER_NAME"));
        System.out.println("USER_PASSWORD: " + dotenv.get("USER_PASSWORD"));

        dotenv.entries().forEach(entry -> System.setProperty(entry.getKey(), entry.getValue()));
        SpringApplication.run(FrameWorkStudyCrudApplication.class, args);
    }

}
