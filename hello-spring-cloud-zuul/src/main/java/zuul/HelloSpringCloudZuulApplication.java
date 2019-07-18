package zuul;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
public class HelloSpringCloudZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloSpringCloudZuulApplication.class, args);
    }

    @Bean
    public ServletRegistrationBean getServlet() {
        HystrixMetricsStreamServlet streamServlet =
                new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean =
                new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }

    /**
     * 为zuul 设置路由规则
     * @return
     */
    @Bean
    public PatternServiceRouteMapper serviceRouteMapper(){
        return new
                PatternServiceRouteMapper("(?<name>^.+)-(?<version>.+$)"
                ,"${version}/${name}");
    }


}
