
package ec.edu.epn.modelo;

import ec.edu.epn.excepciones.ExcepcionCuentaNoCreada;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Grupo 4
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

    @Test
    public void testCuentaAhorros_crear() throws ExcepcionCuentaNoCreada {
        double monto = 179;
        String resultadoEsperado = "La cuenta no se puede crear con menos de $180";
        ExcepcionCuentaNoCreada resultadoObtenido
                = assertThrows(ExcepcionCuentaNoCreada.class, () -> new CuentaAhorros(monto));

        assertEquals(resultadoEsperado, resultadoObtenido.getMessage());
    }

    @Test //Test para validar el constructor
    public void test_categoria_normal1() throws ExcepcionCuentaNoCreada {
        double monto = 180; //entrada
        CuentaAhorros cuentaAhorrosObtenida = new CuentaAhorros(monto);
        String categoriaEsperada = "NORMAL";
        int antiguedadEsperada = 0;
        assertEquals(categoriaEsperada, cuentaAhorrosObtenida.getCategoria());
        assertEquals(antiguedadEsperada, cuentaAhorrosObtenida.getAntiguedad());
        assertEquals(monto, cuentaAhorrosObtenida.getMonto());
    }

    @Test //Test para validar el constructor
    public void test_categoria_normal2() throws ExcepcionCuentaNoCreada {
        double monto = 2500; //entrada
        CuentaAhorros cuentaAhorrosObtenida = new CuentaAhorros(monto);
        String categoriaEsperada = "NORMAL";
        int antiguedadEsperada = 0;
        assertEquals(categoriaEsperada, cuentaAhorrosObtenida.getCategoria());
        assertEquals(antiguedadEsperada, cuentaAhorrosObtenida.getAntiguedad());
        assertEquals(monto, cuentaAhorrosObtenida.getMonto());
    }

    @Test
    public void test_categoria_vip1() throws ExcepcionCuentaNoCreada {
        double monto = 2501; //entrada
        CuentaAhorros cuentaAhorrosObtenida = new CuentaAhorros(monto);
        String categoriaEsperada = "VIP";
        int antiguedadEsperada = 0;
        assertEquals(categoriaEsperada, cuentaAhorrosObtenida.getCategoria());
        assertEquals(antiguedadEsperada, cuentaAhorrosObtenida.getAntiguedad());
        assertEquals(monto, cuentaAhorrosObtenida.getMonto());
    }

    @Test
    public void test_categoria_vip2() throws ExcepcionCuentaNoCreada {
        double monto = 3000; //entrada
        CuentaAhorros cuentaAhorrosObtenida = new CuentaAhorros(monto);
        String categoriaEsperada = "VIP";
        int antiguedadEsperada = 0;
        assertEquals(categoriaEsperada, cuentaAhorrosObtenida.getCategoria());
        assertEquals(antiguedadEsperada, cuentaAhorrosObtenida.getAntiguedad());
        assertEquals(monto, cuentaAhorrosObtenida.getMonto());
    }

    @Test
    public void test_incrementar_Antiguedad1() throws ExcepcionCuentaNoCreada {
        double monto = 190;
        CuentaAhorros cuentaAhorrosObtenida = new CuentaAhorros(monto);
        int antiguedadEsperada = 1;
        cuentaAhorrosObtenida.incrementarAntiguedad();
        assertEquals(antiguedadEsperada, cuentaAhorrosObtenida.getAntiguedad());
    }

    public void test_incrementar_Antiguedad2() throws ExcepcionCuentaNoCreada {
        double monto = 190;
        CuentaAhorros cuentaAhorrosObtenida = new CuentaAhorros(monto);
        int antiguedadAComparar = 0;
        cuentaAhorrosObtenida.incrementarAntiguedad();
        //assertFalse(antiguedadAComparar, cuentaAhorrosObtenida.getAntiguedad());
    }

}
