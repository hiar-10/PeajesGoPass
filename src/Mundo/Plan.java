package Mundo;

public abstract class Plan {
    protected double descuento;

    public Plan(double descuento) {
        this.descuento = descuento;
    }

    public abstract double calcularTarifa(double valorPeaje);
}