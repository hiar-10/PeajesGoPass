package Mundo;

import java.util.Arrays;

public class Peaje {
	private String nombre;
	private Double[] tarifas;

	// Construtor
	public Peaje(String nombre, Double[] tarifas) {
		this.nombre = nombre;
		this.tarifas = tarifas;
	}

	// ToString
	@Override
	public String toString() {
		return "Información del peaje: " + nombre + " | Tarifas: " + Arrays.toString(tarifas);
	}
}