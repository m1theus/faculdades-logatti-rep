package io.m1theus.medicamentos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MedicamentosApplication {

    private static final Logger log = LoggerFactory.getLogger(MedicamentosApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MedicamentosApplication.class, args);
        log.info("App: http://localhost:1337");
        log.info("Swagger: http://localhost:1337/swagger-ui.html");
    }

}
