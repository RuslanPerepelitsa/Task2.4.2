package web.dao;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import web.models.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Role getRoleByName(String name) {
        Role role = null;
        try {
            role = entityManager.createQuery("select role from Role role where role.name=:name", Role.class)
                    .setParameter("name", name).getSingleResult();
        } catch (Exception e) {
            System.out.println("Role not found");
        }
        return role;
    }

    @Override
    public Role getRoleById(Long id) {
        return entityManager.find(Role.class, id);
    }

    @Override
    public void addRole(Role role) {
        entityManager.persist(role);
    }

    @Override
    public void changeRole(Role role) {
        entityManager.merge(role);
    }

    @Override
    public void removeRole(Role role) {
        if (role == null) {
            System.out.println("Role not found");
        } else {
            entityManager.remove(role);
        }
    }

    @Override
    public List<Role> getAllRoles() {
        return entityManager.createQuery("from Role", Role.class).getResultList();
    }
}
