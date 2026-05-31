package com.github.massakai.snippets.performancestub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class PerformanceStubApplication {

    public static void main(String[] args) {
        SpringApplication.run(PerformanceStubApplication.class, args);
    }
}
