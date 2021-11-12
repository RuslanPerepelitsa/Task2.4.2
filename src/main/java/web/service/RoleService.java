package web.service;

import web.models.Role;

import java.util.List;

public interface RoleService {

    Role getRoleByName(String name);

    Role getRoleById(Long id);

    void addRole(Role role);

    void changeRole(Role role);

    void removeRole(Role role);

    List<Role> getAllRoles();
}
