package Mundo;

public class PlanPremium extends Plan {

	public PlanPremium(double descuento) {
		super(descuento);

	}

	@Override
	public double calcularTarifa(double valorPeaje) {
		// TODO Auto-generated method stub
		return valorPeaje * (1-descuento);
	}
	@Override
	public String toString()
	{
    return "Premium (20% descuento)";
	}

}
