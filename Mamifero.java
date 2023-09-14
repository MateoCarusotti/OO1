package ar.edu.unlp.info.oo1.ejercicio5;

import java.util.Date;

public class Mamifero {
	private String identificador;
	private Mamifero padre ;
	private Mamifero madre ;
	private String especie;
	private Date fechaNacimiento;
	
	public Mamifero(String identificador) {
		this.identificador = identificador;
	}
	
	public Mamifero() {}
	
	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	public Mamifero getPadre() {
		return padre;
	}
	public void setPadre(Mamifero padre) {
		this.padre = padre;
	}
	public Mamifero getMadre() {
		return madre;
	}
	public void setMadre(Mamifero madre) {
		this.madre = madre;
	}
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public Mamifero getAbuelaMaterna() {
		if(this.getMadre() == null) {
			return null;
		}else {
			return this.getMadre().getMadre();
		}
	}
	public Mamifero getAbueloMaterno() {
		if(this.getMadre() == null) {
			return null;
		}else {
			return this.getMadre().getPadre();
		}
		
	}
	public Mamifero getAbueloPaterno() {
		if(this.getPadre() == null) {
			return null;
		}else{
			return this.getPadre().getPadre();
		}
	}
	public Mamifero getAbuelaPaterna() {
		if(this.getPadre() == null) {
			return null;
		}else{
			return this.getPadre().getMadre();
		}
		
	}
	
	public boolean tieneComoAncestroA(Mamifero ancestro) {
		boolean encontrado = false;
		if(this.getIdentificador().equals(ancestro.getIdentificador())) {
			encontrado = true;
		}else {
			if(this.getMadre() != null) {
				encontrado = this.getMadre().tieneComoAncestroA(ancestro);
			}
			if(this.getPadre() != null && encontrado == false) {
				encontrado = this.getPadre().tieneComoAncestroA(ancestro);
			}
		}
		return encontrado;
	}
}
