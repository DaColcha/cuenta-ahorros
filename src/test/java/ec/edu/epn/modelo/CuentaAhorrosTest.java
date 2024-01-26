
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

    /*
    * PRUEBAS PARA DEPOSITAR
    */
    @Test
    public void testCuentaAhorrosDepositar_Invalido() throws ExcepcionCuentaNoCreada {
        CuentaAhorros cuentaAhorros = new CuentaAhorros(180);
        cuentaAhorros.depositar(-1);
        assertEquals(180, cuentaAhorros.getMonto());
    }

    @Test
    public void testCuentaAhorrosDepositar_Valido() throws ExcepcionCuentaNoCreada {
        CuentaAhorros cuentaAhorros = new CuentaAhorros(180);
        cuentaAhorros.depositar(10);
        assertEquals(190, cuentaAhorros.getMonto());
    }

    /*
    * PRUEBAS PARA RETIRAR
     */
    @Test
    public void testCuentaAhorrosRetirar_Valido() throws ExcepcionCuentaNoCreada {
        CuentaAhorros cuentaAhorros = new CuentaAhorros(3000);
        for (int i = 0; i < 5; i ++) {
            cuentaAhorros.incrementarAntiguedad();
        }
        cuentaAhorros.retirar(2500);
        assertEquals(500, cuentaAhorros.getMonto());
        assertEquals("NORMAL", cuentaAhorros.getCategoria());
    }

    @Test
    public void testCuentaAhorrosRetirar_Invalido() throws ExcepcionCuentaNoCreada {
        CuentaAhorros cuentaAhorros = new CuentaAhorros(3000);

        // No tiene la antiguedad requerida
        cuentaAhorros.retirar(2500);
        assertEquals(3000, cuentaAhorros.getMonto());

        // Cantidad mayor al monto de la cuenta
        for (int i = 0; i < 5; i ++) {
            cuentaAhorros.incrementarAntiguedad();
        }
        cuentaAhorros.retirar(3500);
        assertEquals(3000, cuentaAhorros.getMonto());

        // No se modifica la categoría de la cuenta
        assertEquals("VIP", cuentaAhorros.getCategoria());
    }

    /*
    * PRUEBAS PARA VERIFICAR CATEGORIA
    */
    @Test
    public void test_categoria_normal1() throws ExcepcionCuentaNoCreada {
        double monto = 180; //entrada
        CuentaAhorros cuentaAhorrosObtenida = new CuentaAhorros(monto);
        String categoriaEsperada = "NORMAL";
        int antiguedadEsperada = 0;
        assertEquals(categoriaEsperada, cuentaAhorrosObtenida.getCategoria());
        assertEquals(antiguedadEsperada, cuentaAhorrosObtenida.getAntiguedad());
        assertEquals(monto, cuentaAhorrosObtenida.getMonto());
    }

    @Test
    public void test_categoria_normal2() throws ExcepcionCuentaNoCreada {
        double monto = 2500;
        CuentaAhorros cuentaAhorrosObtenida = new CuentaAhorros(monto);
        String categoriaEsperada = "NORMAL";
        int antiguedadEsperada = 0;
        assertEquals(categoriaEsperada, cuentaAhorrosObtenida.getCategoria());
        assertEquals(antiguedadEsperada, cuentaAhorrosObtenida.getAntiguedad());
        assertEquals(monto, cuentaAhorrosObtenida.getMonto());
    }

    @Test
    public void test_categoria_vip1() throws ExcepcionCuentaNoCreada {
        double monto = 2501;
        CuentaAhorros cuentaAhorrosObtenida = new CuentaAhorros(monto);
        String categoriaEsperada = "VIP";
        int antiguedadEsperada = 0;
        assertEquals(categoriaEsperada, cuentaAhorrosObtenida.getCategoria());
        assertEquals(antiguedadEsperada, cuentaAhorrosObtenida.getAntiguedad());
        assertEquals(monto, cuentaAhorrosObtenida.getMonto());
    }

    @Test
    public void test_categoria_vip2() throws ExcepcionCuentaNoCreada {
        double monto = 3000;
        CuentaAhorros cuentaAhorrosObtenida = new CuentaAhorros(monto);
        String categoriaEsperada = "VIP";
        int antiguedadEsperada = 0;
        assertEquals(categoriaEsperada, cuentaAhorrosObtenida.getCategoria());
        assertEquals(antiguedadEsperada, cuentaAhorrosObtenida.getAntiguedad());
        assertEquals(monto, cuentaAhorrosObtenida.getMonto());
    }

    /*
     * PRUEBAS PARA VERIFICAR SI SE PUEDE RETIRAR
     */

    @Test
    public void test_puede_retirar_invalido() throws ExcepcionCuentaNoCreada {
        double monto = 190;
        CuentaAhorros cuentaAhorrosObtenida = new CuentaAhorros(monto);
        assertEquals(false, cuentaAhorrosObtenida.puedeRetirar());
    }

    @Test
    public void test_puede_retirar_valido() throws ExcepcionCuentaNoCreada {
        double monto = 190;
        CuentaAhorros cuentaAhorrosObtenida = new CuentaAhorros(monto);
        for(int i = 0; i < 5; i++){
            cuentaAhorrosObtenida.incrementarAntiguedad();
        }
        assertEquals(true, cuentaAhorrosObtenida.puedeRetirar());
    }

    /*
     * PRUEBAS PARA INCREMENTAR ANTIGUEDAD
     */

    @Test
    public void test_incrementar_Antiguedad1() throws ExcepcionCuentaNoCreada {
        double monto = 190;
        CuentaAhorros cuentaAhorrosObtenida = new CuentaAhorros(monto);
        int antiguedadEsperada = 1;
        cuentaAhorrosObtenida.incrementarAntiguedad();
        assertEquals(antiguedadEsperada, cuentaAhorrosObtenida.getAntiguedad());
    }

    @Test
    public void test_incrementar_Antiguedad2() throws ExcepcionCuentaNoCreada {
        double monto = 190;
        CuentaAhorros cuentaAhorrosObtenida = new CuentaAhorros(monto);
        cuentaAhorrosObtenida.incrementarAntiguedad();
        assertFalse(cuentaAhorrosObtenida.getAntiguedad() == 0);
    }

}
