package ie.com.Conor.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ie.com.Conor.entities.UserDetails;

public interface UserDao extends JpaRepository<UserDetails, Integer>{
}