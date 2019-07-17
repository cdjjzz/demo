package ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class HelloRibbonService {

    @Autowired
    public RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod ="hysError" )
    public Map hiService(String id) {
        return restTemplate.getForObject("http://hello-spring-cloud-eureka-member//member?id=" + id, Map.class);
    }


    public Map hysError(String id){
      Map map=new HashMap();
      map.put("error", "400");
      map.put("msg", "错误");
      return  map;
    }

}