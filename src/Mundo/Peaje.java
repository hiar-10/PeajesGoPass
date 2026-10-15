package Mundo;

import java.util.Arrays;

public class Peaje
{
	private String nombre;
	private Double[] tarifas;
	
	
	// Construtor
	public Peaje(String nombre, Double[] tarifas)
	{
		this.nombre = nombre;
		this.tarifas = tarifas;
	}
	
	
	// ToString
	@Override
	public String toString() 
	{
		return "Peaje [nombre=" + nombre + ", tarifas=" + Arrays.toString(tarifas) + ", peajes="
				+ Arrays.toString(peajes) + "]";
	}
	
	
	// Peajes de Colombia
	Peaje[] peajes = 
		{
		};

}
