package fenign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author admin
 * @version 1.0.0
 */
@FeignClient("hello-spring-cloud-eureka-member")
public interface FenignService {

    @RequestMapping("/member")
    Map printPort(@RequestParam("id") String name);
}
