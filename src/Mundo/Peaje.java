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
	
	
	// Peajes de Colombia
	Peaje[] peajes = 
		{
			new Peaje("Alto Pino", new Double[] {14800.00, 22900.00, 18400.00, 29100.00, 42500.00, 68300.00, 86200.00}),
			new Peaje("Los Patios", new Double[] {14800.00, 23100.00, 35700.00, 52300.00, 71700.00, 72100.00, null}),
			new Peaje("Andes", new Double[] {15200.00, 26400.00, 17500.00, 37100.00, 54500.00, 68900.00, 75900.00}),
			new Peaje("Gualanday", new Double[] {15300.00, 18000.00, 42400.00, 57000.00, 62500.00, null, null}),
			new Peaje("Siberia", new Double[] {15300.00, 21800.00, 18300.00, 24400.00, 42600.00, 57000.00, 62700.00}),
			new Peaje("Chinauta", new Double[] {16100.00, 17900.00, 38000.00, 61700.00, 70700.00, null, null}),
			new Peaje("Chusaca", new Double[] {16100.00, 17900.00, 38000.00, 61700.00, 70700.00, null, null}),
			new Peaje("Chicoral", new Double[] {16600.00, 18300.00, 16600.00, 21500.00, 43700.00, 58000.00, 64000.00}),
			new Peaje("Flandes", new Double[]{18900.00, 23400.00, 28900.00, 36600.00, 55800.00, 70000.00, 81000.00}),
			new Peaje("Pamplonita", new Double[]{21800.00, 27100.00, 32200.00, 45800.00, 64700.00, 81500.00, 94400.00})
		};

}
