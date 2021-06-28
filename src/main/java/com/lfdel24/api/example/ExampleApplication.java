package com.lfdel24.api.example;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExampleApplication.class, args);
        openChromeLinux();
    }

    private static void openChromeLinux() {
        try {
            URI url = new URI("http://localhost:8080/");
            Runtime rt = Runtime.getRuntime();
            rt.exec("/usr/bin/google-chrome-stable %U " + url);
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
    }
}
