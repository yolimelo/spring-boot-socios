package com.yolanda.socios.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.yolanda.socios.entities.Socio;

public interface SocioService {
	void addSocio(Socio socio);

	void removeSocio(Long socioId);

	List<Socio> getSocio();
	
	Optional<Socio> getSocioById(Long socioId);

	Socio updateSocio(Socio socio);
	
	List<Socio> getSocioBysocioBaja ();
	
	List<Socio> getSociosBajaDesdeFecha(LocalDate fecha);
	
	List<Socio> getSociosBajaHastaFecha(LocalDate fecha);
	
	
}
