package org.iesbelen.examenSpringJPA.repository;

import org.iesbelen.examenSpringJPA.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
