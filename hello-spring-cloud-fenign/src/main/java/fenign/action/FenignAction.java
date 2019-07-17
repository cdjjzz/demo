package fenign.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import fenign.service.FenignService;

import java.util.Map;

/**
 * @author admin
 * @version 1.0.0
 */
@RestController
@RequestMapping("/fenign")
public class FenignAction {

    @Autowired
    private FenignService fenignService;

    @GetMapping("/print")
    public Map print(String name){
        return fenignService.printPort(name);
    }

}
