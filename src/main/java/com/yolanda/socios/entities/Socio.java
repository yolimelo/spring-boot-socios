package com.yolanda.socios.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(uniqueConstraints=
	@UniqueConstraint(name = "unique_socioId", columnNames={"socioId"}))
public class Socio {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column
	@NotNull (message = "El campo socioId es obligatorio, no debe estar vacío")
	private Long socioId; 
	
	@Column
	@NotNull (message = "El campo dni es obligatorio, no debe estar vacío")
	private String dni;
	
	@Column
	private String nombre;
	
	@Column
	private String apellido1;
	
	@Column
	private String apellido2;
	
	@Column
	private String email;
	
	@Column
	private String numeroTelefono;
	
}
