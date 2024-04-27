package io.github.tiagoadmstz.eddz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@Profile("!docker-compose")
@SpringBootApplication
@EnableJpaRepositories
public class EddzApplication {

    public static void main(String[] args) {
        SpringApplication.run(EddzApplication.class, args);
    }

}
