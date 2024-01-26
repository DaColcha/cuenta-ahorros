
package ec.edu.epn.modelo;

import ec.edu.epn.excepciones.ExcepcionCuentaNoCreada;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author Marcela
 */
public class CuentaAhorrosTest {

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    @Test //Test para validar el constructor
    public void testCuentaAhorros() throws ExcepcionCuentaNoCreada {
        double monto = 180; //entrada
        CuentaAhorros cuentaAhorrosObtenida = new CuentaAhorros(monto);
        String categoriaEsperada = "Normal";
        int antiguedadEsperada = 0;
        assertEquals(categoriaEsperada, cuentaAhorrosObtenida.getCategoria());
        assertEquals(antiguedadEsperada, cuentaAhorrosObtenida.getAntiguedad());
        assertEquals(monto, cuentaAhorrosObtenida.getMonto());
    }

    @Test //Test para validar el constructor
    public void testCuentaAhorro2() throws ExcepcionCuentaNoCreada {
        double monto = 181; //entrada
        CuentaAhorros cuentaAhorrosObtenida = new CuentaAhorros(monto);
        String categoriaEsperada = "Normal";
        int antiguedadEsperada = 0;
        assertEquals(categoriaEsperada, cuentaAhorrosObtenida.getCategoria());
        assertEquals(antiguedadEsperada, cuentaAhorrosObtenida.getAntiguedad());
        assertEquals(monto, cuentaAhorrosObtenida.getMonto());
    }
}
