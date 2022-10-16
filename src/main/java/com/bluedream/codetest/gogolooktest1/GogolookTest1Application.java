package com.bluedream.codetest.gogolooktest1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class GogolookTest1Application {

    public static void main(String[] args) {
        SpringApplication.run(GogolookTest1Application.class, args);
    }

    @Value("${my-env-id}")
    private String strEnvId;

    @Value("${my-env-name}")
    private String strEnvName;

    @RestController
    public class HelloController {

        @GetMapping("/")
        public String index() {
            return "Greetings from Spring Boot! in Env: " + strEnvId + " Host Name: " + strEnvName;
        }

    }


}

