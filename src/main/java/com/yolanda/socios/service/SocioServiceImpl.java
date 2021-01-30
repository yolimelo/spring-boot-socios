package com.yolanda.socios.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yolanda.socios.entities.Socio;
import com.yolanda.socios.repository.SocioRepository;

@Service
public class SocioServiceImpl implements SocioService {
	
	@Autowired 
	private SocioRepository socioRepository;
	
	@Override
	public void addSocio(Socio socio) {
		socio.setId(null);
		socioRepository.save(socio);
	}

	@Override
	public void removeSocio(Long socioId) {
		socioRepository.deleteById(socioId);	
	}

	@Override
	public List<Socio> getSocio() {
		return socioRepository.findAll();
	}

	@Override
	public Optional<Socio> getSocioById(Long socioId) {
		return socioRepository.findById(socioId);
	}

	@Override
	public Socio updateSocio(Socio socio) {
		Socio result = null;
		Optional<Socio> socioRead  = socioRepository.findById(socio.getId());
		
		if (socioRead.isPresent()) {
			Socio socioBd = socioRead.get();
			
			socioBd.setId(socio.getId());
			socioBd.setSocioId(socio.getSocioId());
			socioBd.setNombre(socio.getNombre());			
			socioBd.setApellido1(socio.getApellido1());
			socioBd.setApellido2(socio.getApellido2());
			socioBd.setDni(socio.getDni());
			socioBd.setEmail(socio.getEmail());
			socioBd.setNumeroTelefono(socio.getNumeroTelefono());
			socioBd.setFechaBaja(socio.getFechaBaja());
			
			socioRepository.save(socioBd);
			
			result = socioBd;
		}
		
		return result; 
		
	}

	@Override
	public List<Socio> getSocioBysocioBaja() {
		return socioRepository.findByFechaBajaNotNull();
	}

	@Override
	public List<Socio> getSociosBajaDesdeFecha(LocalDate fecha) {
		return socioRepository.findByFechaBajaGreaterThanEqual(fecha);
	}

	@Override
	public List<Socio> getSociosBajaHastaFecha(LocalDate fecha) {
		return socioRepository.findByFechaBajaLessThanEqual(fecha);
	}

}
