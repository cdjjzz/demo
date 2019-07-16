package ribbon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class HelloRibbonService {

    @Autowired
    public RestTemplate restTemplate;


    public Map hiService(String id) {
        return restTemplate.getForObject("http://hello-spring-cloud-eureka-member//member?id=" + id, Map.class);
    }

}