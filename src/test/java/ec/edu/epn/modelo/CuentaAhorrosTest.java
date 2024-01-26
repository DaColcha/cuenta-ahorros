/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ec.edu.epn.modelo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;


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
    public void testCuentaAhorro1() throws ExcepcionCuentaNoCreada {
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
