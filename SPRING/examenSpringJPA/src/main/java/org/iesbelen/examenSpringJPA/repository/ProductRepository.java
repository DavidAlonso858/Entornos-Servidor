package org.iesbelen.examenSpringJPA.repository;

import org.iesbelen.examenSpringJPA.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
