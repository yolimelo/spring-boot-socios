package com.yolanda.socios.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yolanda.socios.entities.Socio;
import com.yolanda.socios.service.SocioService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class SocioController {
	
	@Autowired
	private SocioService socioSevice;
	
	@GetMapping("/socio")
	List<Socio> socio() {
		System.out.println("Consultando todos los socios.\n");
		return socioSevice.getSocio();
	}

	@GetMapping("/socio/{id}")
	ResponseEntity<Socio> socio(@PathVariable Long id) {
		Optional<Socio> socio = socioSevice.getSocioById(id);
		System.out.println("Consultando un nuevo socio.\n");
		return socio.isPresent() ? ResponseEntity.ok().body(socio.get()) : ResponseEntity.notFound().build();
	}

	@PostMapping("/socio")
	void nuevoSocio(@RequestBody @Valid Socio socio) {
		socioSevice.addSocio(socio);
		System.out.println("Añadiendo un nuevo socio.\n");
	}

	@DeleteMapping("/socio/{id}")
	void borrarSocio(@PathVariable Long id) {
		socioSevice.removeSocio(id);
		System.out.println("Borrando un nuevo socio.\n");
	}

	@PutMapping("/socio")
	ResponseEntity<Socio> modificarSocio(@RequestBody Socio socio) {
		Socio result = socioSevice.updateSocio(socio);
		
		System.out.println("Modificando un socio.\n");
		
		return ResponseEntity.ok(result);
	}

	@GetMapping("/socio/baja")
	ResponseEntity <List<Socio>> socioBajaDesdeFecha(@RequestParam (required = false) @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate fechaDesde,@RequestParam (required = false) @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate fechaHasta) {
		List<Socio> result = null;
		
		if (fechaDesde == null) {
			System.out.println("Consultando todos los socios dados de baja.\n");
			result = socioSevice.getSocioBysocioBaja();
		}
		else {
			System.out.println("Consultando todos los socios dados de baja a partir de la fecha dada.\n");

			result = socioSevice.getSociosBajaDesdeFecha(fechaDesde);
		}
		
		if (fechaHasta == null) {
			System.out.println("Consultando todos los socios dados de baja.\n");
			result = socioSevice.getSocioBysocioBaja();
		}
		else {
			System.out.println("Consultando todos los socios dados de baja hasta la fecha dada.\n");

			result = socioSevice.getSociosBajaHastaFecha(fechaHasta);
		}

		return ResponseEntity.ok(result); 
	}

}
