package zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import zipkin2.server.internal.EnableZipkinServer;

@SpringBootApplication
/**
 * zipkin 链路追踪
 */
@EnableZipkinServer
@EnableDiscoveryClient
public class HelloSpringCloudZipkinApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloSpringCloudZipkinApplication.class, args);
    }

}
