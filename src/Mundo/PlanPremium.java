package Mundo;

public class PlanPremium extends Plan {

	public PlanPremium(double descuento) {
		super(descuento);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calcularTarifa(double valorPeaje) {
		// TODO Auto-generated method stub
		return valorPeaje * (1 - descuento);
	}

}
