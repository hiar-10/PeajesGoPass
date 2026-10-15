package Mundo;

public class PlanPlus extends Plan
{
	public PlanPlus(double descuento) 
	{
		super(descuento);
	}


	@Override
	public double calcularTarifa(double valorPeaje)
	{

		return valorPeaje * (1-descuento);
	}
}
