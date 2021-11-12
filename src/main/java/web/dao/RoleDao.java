package web.dao;

import web.models.Role;
import web.models.User;

import java.util.List;

public interface RoleDao {

    Role getRoleByName(String name);

    Role getRoleById(Long id);

    void addRole(Role role);

    void changeRole(Role role);

    void removeRole(Role role);

    List<Role> getAllRoles();
}
