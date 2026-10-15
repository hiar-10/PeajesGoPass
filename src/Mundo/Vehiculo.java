package Mundo;

public class Vehiculo
{
	private String placa;
	private int categoria;


	// Constructor
	public Vehiculo(String placa, int categoria)
	{
		if (placa == null || placa.isBlank())
		{
			throw new IllegalArgumentException("La placa no puede estar vacía");
		}
		this.placa = placa;


		if (categoria < 1 || categoria > 7)
		{
			throw new IllegalArgumentException("La categoría debe estar entre 1 y 7");
		}
		this.categoria = categoria;
	}


	// ToString
	@Override
	public String toString() {
		return "Vehiculo [placa=" + placa + ", categoria=" + categoria + "]";
	}


	// Categoria de acuerdo a tipo de vehiculo
	public int obtenerCategoria()
	{
		return categoria;
	}

}