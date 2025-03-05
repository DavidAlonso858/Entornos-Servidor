package org.iesbelen.videoclub.repository;

import jdk.jfr.Registered;
import org.iesbelen.videoclub.domain.Socio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocioRepository extends JpaRepository<Socio, Long> {

}
