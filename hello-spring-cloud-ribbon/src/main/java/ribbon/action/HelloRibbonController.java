package ribbon.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ribbon.service.HelloRibbonService;

import java.util.Map;

@RestController
@RequestMapping("/ribbon")
public class HelloRibbonController {

    @Autowired
    public HelloRibbonService service;

    @GetMapping("/print")
    public Map print(@RequestParam String name) {
        return this.service.hiService(name);
    }
}