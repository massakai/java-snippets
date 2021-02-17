package com.github.massakai.snippets.configurationpropertiesdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@ConfigurationPropertiesScan("com.github.massakai.snippets.configurationpropertiesdemo")
public class ConfigurationPropertiesDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigurationPropertiesDemoApplication.class, args);
	}

}
