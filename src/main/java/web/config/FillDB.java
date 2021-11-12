package web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.models.Role;
import web.models.User;
import web.service.RoleService;
import web.service.UserService;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class FillDB {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public FillDB(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void addTestUsers() {
        Role roleAmin = new Role("ROLE_ADMIN");
        Role roleUser = new Role("ROLE_USER");
        Set<Role> adminRoles = new HashSet<>();
        Set<Role> userRoles = new HashSet<>();
        adminRoles.add(roleAmin);
        adminRoles.add(roleUser);
        userRoles.add(roleUser);
        roleService.addRole(roleAmin);
        roleService.addRole(roleUser);
        User user1 = new User("Ruslan", "Perepelitsa", "Ruslan0709", "admin","ruslan@gmail.com");
        User user2 = new User("Petr", "Ivanov", "Petr227", "user","petr777@mail.ru");
        user1.setRoles(adminRoles);
        user2.setRoles(userRoles);
        userService.addUser(user1);
        userService.addUser(user2);
    }
}
