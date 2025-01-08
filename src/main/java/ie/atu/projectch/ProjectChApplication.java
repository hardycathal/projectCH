package ie.atu.projectch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ProjectChApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectChApplication.class, args);
    }

}
