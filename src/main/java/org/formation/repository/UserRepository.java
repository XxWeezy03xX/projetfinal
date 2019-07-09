package org.formation.repository;

import java.util.Optional;

import org.formation.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, String>
{
//	@Query("select distinct u from User u left join fetch u.role where u.username=:username")
//	Optional<User> findByIdWithRoles(String username);

}
