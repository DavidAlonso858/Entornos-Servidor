package org.iesbelen.videoclub.repository;

import org.iesbelen.videoclub.domain.Idioma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface IdiomaRepository extends JpaRepository<Idioma, Long> {

}
