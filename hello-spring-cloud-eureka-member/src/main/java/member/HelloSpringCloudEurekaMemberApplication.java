package member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class HelloSpringCloudEurekaMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloSpringCloudEurekaMemberApplication.class, args);
    }

}
