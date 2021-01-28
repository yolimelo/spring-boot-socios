package com.yolanda.socios.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yolanda.socios.entities.Socio;

@Repository
public interface SocioRepository extends JpaRepository<Socio,Long>{
	List<Socio> findByFechaBajaNotNull();
}
