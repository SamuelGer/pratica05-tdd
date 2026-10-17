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


}
