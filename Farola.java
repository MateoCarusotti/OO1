package ar.edu.unlp.info.oo1.ejercicio6;

import java.util.List;
import java.util.ArrayList;
public class Farola {
	private boolean on;
	private List<Farola> vecinas;
	
	public Farola() {
		this.on = false;
		vecinas = new ArrayList<>();
	}
	
	
	
	public boolean isOn() {
		return on;
	}



	public void setOn(boolean on) {
		this.on = on;
	}



	public List<Farola> getNeighbors() {
		return vecinas;
	}



	public void setVecinas(List<Farola> vecinas) {
		this.vecinas = vecinas;
	}



	public void pairWithNeighbor (Farola otraFarola) {
		this.vecinas.add(otraFarola);
		if(!otraFarola.getNeighbors().contains(this)) {
			otraFarola.pairWithNeighbor(this);
		}
		
	}
	
	public void turnOn() { 
		if(!this.isOn()) {
			this.setOn(true);
			List<Farola> neighbors = this.getNeighbors();
			neighbors.stream().filter(farola -> !farola.isOn()) .forEach(Farola::turnOn);
		}
	}
	
	public void turnOff() { 
		if(this.isOn()) {
			this.setOn(false);
			List<Farola> neighbors = this.getNeighbors();
			neighbors.stream().filter(farola -> farola.isOn()).forEach(Farola::turnOff);
		}
	}
	
}
