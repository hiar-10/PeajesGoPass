package Mundo;

public class Usuario {
	private String userId;
	private String nombre;
	private double saldo;
	private Vehiculo vehiculo; // Objeto vehiculo con los atributos correspondientes
	private Plan plan; // Objeto plan con los atributos correspondientes

	// Constructor
	public Usuario(String userId, String nombre, double saldo, Vehiculo vehiculo, Plan plan) {
		this.userId = userId;
		
		if(nombre == null || nombre.isBlank())
		{
			throw new IllegalArgumentException("El nombre no puede ser nulo o estar vacío");
		}
		this.nombre = nombre;

		// Validación de saldo
		if (saldo >= 0) {
			this.saldo = saldo;
		} 
		else 
		{
			this.saldo = 0;
		}

		// No null 
		if (vehiculo == null)
		{
			throw new IllegalArgumentException("El vehículo no puede ser nulo");
		}
		this.vehiculo = vehiculo;

		this.plan = plan;
	}

	// Getters and setters
	public String getUserId() 
	{
		return userId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}

	public double getSaldo() {
		return saldo;
	}

	public Vehiculo getVehiculo() 
	{
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) 
	{
		this.vehiculo = vehiculo;
	}

	public Plan getPlan() 
	{
		return plan;
	}

	public void setPlan(Plan plan) 
	{
		this.plan = plan;
	}

	// To String
	@Override
	public String toString()
	{
		return "Información de Usuario. User ID: " + userId + 
				" | Nombre: " + nombre + 
				" | Saldo: " + saldo + 
				" | Vehiculo: " + vehiculo + 
				" | Plan: " + plan;
	}

	// Recargar
	public void recargarSaldo(double valorRecarga) {
		if (valorRecarga > 0) {
			this.saldo += valorRecarga;
		}
	}

	// Descontar / Pagar peaje
	public void descontarSaldo(double tarifa) {
		if (this.saldo >= tarifa) {
			this.saldo -= tarifa;
		} else {
			System.out.println("Saldo insuficiente. Por favor recargue o utilice un método de pago alternativo");
		}
	}
}