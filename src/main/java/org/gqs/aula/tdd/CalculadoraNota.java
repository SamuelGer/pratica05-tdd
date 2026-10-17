package org.gqs.aula.tdd;

public class CalculadoraNota {
    public static final double NOTA_MINIMA_APROVACAO = 70;

    public double calcularNotaFinal(double a1, double a2, double a3) {
        if (a1 < 0 || a1 > 30) {
            throw new IllegalArgumentException("A1 deve estar entre 0 e 30");
        }
        return a1 + a2 + a3;
    }

    public boolean estaAprovadoPorNota(double notaFinal) {
        return notaFinal >= NOTA_MINIMA_APROVACAO;
    }
}
