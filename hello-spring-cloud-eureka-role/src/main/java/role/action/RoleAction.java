package role.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import role.entity.Role;
import role.service.RoleService;

/**
 * @author admin
 * @version 1.0.0
 */
@RestController
@RequestMapping
public class RoleAction {

    @Autowired
    private RoleService roleService;

    public Role getRole(){
            return roleService.getRole();
    }
}
