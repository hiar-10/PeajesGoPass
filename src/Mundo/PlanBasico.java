package Mundo;

public class PlanBasico extends Plan {

	public PlanBasico(double descuento) {
		super(descuento);
	}

	@Override
	public double calcularTarifa(double valorPeaje) {

		return valorPeaje * (1 - descuento);
	}
}
