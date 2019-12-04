package ie.com.Conor.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ie.com.Conor.entities.Role;

public interface RoleDao extends JpaRepository<Role, Integer> {

}
