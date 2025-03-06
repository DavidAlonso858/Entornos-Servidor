package org.iesbelen.examenSpringJPA.repository;

import org.iesbelen.examenSpringJPA.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
