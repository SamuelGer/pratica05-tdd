import org.gqs.aula.tdd.CalculadoraNota;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraNotaTest {
    @Test
    void deveSomarAsTresNotas() {
        CalculadoraNota calc = new CalculadoraNota();
        double resultado = calc.calcularNotaFinal(10, 15, 25);
        assertEquals(50, resultado);
    }
    @Test
    void deveAprovarComNota70() {
        CalculadoraNota calc = new CalculadoraNota();
        assertTrue(calc.estaAprovadoPorNota(70));
    }

    @Test
    void deveReprovarComNota69() {
        CalculadoraNota calc = new CalculadoraNota();
        assertFalse(calc.estaAprovadoPorNota(69));
    }

    @Test
    void deveRejeitarA1MaiorQue30() {
        CalculadoraNota calc = new CalculadoraNota();
        assertThrows(IllegalArgumentException.class,
                () -> calc.calcularNotaFinal(35, 20, 30));

    }

    @Test
    void deveAprovarComNotaEFrequenciaSuficientes() {
        CalculadoraNota calc = new CalculadoraNota();
        String resultado = calc.situacao(80, 90);
        assertEquals("APROVADO", resultado);
    }

    @Test
    void deveReprovarComNotaBaixa() {
        CalculadoraNota calc = new CalculadoraNota();
        String resultado = calc.situacao(60, 90);
        assertEquals("REPROVADO", resultado);
    }

    @Test
    void deveReprovarPorFrequenciaMesmoComNotaAlta() {
        CalculadoraNota calc = new CalculadoraNota();
        String resultado = calc.situacao(95, 74);
        assertEquals("REPROVADO", resultado);
    }

    @Test
    void deveAprovarComFrequenciaExatamente75() {
        CalculadoraNota calc = new CalculadoraNota();
        String resultado = calc.situacao(70, 75);
        assertEquals("APROVADO", resultado);
    }
    @Test
    void devePermitirFazerAIPorA1MaisA3() {
        CalculadoraNota calc = new CalculadoraNota();
        boolean resultado = calc.podeFazerAI(10, 20, 30, 80);
        assertTrue(resultado);
    }

    @Test
    void devePermitirFazerAILimiteExato() {
        CalculadoraNota calc = new CalculadoraNota();
        boolean resultado = calc.podeFazerAI(10, 5, 30, 80);
        assertTrue(resultado);
    }

    @Test
    void naoDevePermitirFazerAISeJaAprovado() {
        CalculadoraNota calc = new CalculadoraNota();
        boolean resultado = calc.podeFazerAI(25, 25, 30, 80);
        assertFalse(resultado);
    }

    @Test
    void naoDevePermitirFazerAIComFrequenciaBaixa() {
        CalculadoraNota calc = new CalculadoraNota();
        boolean resultado = calc.podeFazerAI(10, 20, 30, 70);
        assertFalse(resultado);
    }

    @Test
    void naoDevePermitirFazerAISeSomasInsuficientes() {
        CalculadoraNota calc = new CalculadoraNota();
        boolean resultado = calc.podeFazerAI(5, 5, 30, 80);
        assertFalse(resultado);
    }
    @Test
    void deveSubstituirA1PelaAI() {
        CalculadoraNota calc = new CalculadoraNota();
        double resultado = calc.aplicarAI(10, 20, 30, 25);
        assertEquals(75.0, resultado);
    }

    @Test
    void deveSubstituirA2PelaAI() {
        CalculadoraNota calc = new CalculadoraNota();
        double resultado = calc.aplicarAI(20, 10, 30, 25);
        assertEquals(75.0, resultado);
    }

    @Test
    void naoDeveSubstituirSeAIBaixa() {
        CalculadoraNota calc = new CalculadoraNota();
        double resultado = calc.aplicarAI(10, 20, 30, 5);
        assertEquals(60.0, resultado);
    }

    @Test
    void deveRejeitarAIMaiorQue30() {
        CalculadoraNota calc = new CalculadoraNota();
        assertThrows(IllegalArgumentException.class, () -> {
            calc.aplicarAI(10, 20, 30, 35);
        });
    }

}
