package role.service;

import org.springframework.stereotype.Service;
import role.entity.Role;

/**
 * @author admin
 * @version 1.0.0
 */
@Service
public class RoleService {

    public Role getRole(){
        Role role=new Role();
        role.setRoleId(1);
        role.setRoleName("明教");
        return role;
    }
}
