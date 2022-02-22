package cuentaTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cuenta.Cuenta;

public class CuentaTests {
	Cuenta cuenta1;
	
	@Before
	public void setUp() {
		cuenta1 = new Cuenta();
	}

	@Test
	public void creacionPorDefectoEnCero() {
		assertNotNull(cuenta1);
		assertEquals(0, cuenta1.getSaldo(), 0);
	}
	
	@Test
	public void depositaDinero() {
		cuenta1.depositar(1000);
		assertEquals(1000, cuenta1.getSaldo(), 0.001);
		cuenta1.depositar(500);
		assertEquals(1500, cuenta1.getSaldo(), 0.001);
	}
	
	@Test(expected = Error.class)
	public void NoDejaDepositarDineroNegativo() {
		cuenta1.depositar(-200);
		assertEquals(-200, cuenta1.getSaldo(), 0.001);
	}
	
	@Test
	public void retiraDinero() {
		cuenta1.depositar(1000);
		cuenta1.retirar(550);
		assertEquals(450, cuenta1.getSaldo(), 0.001);
	}
	
	@Test(expected = Error.class)
	public void noPermiteRetirarMasDineroDelQueSeTiene() {
		cuenta1.retirar(100);
	}
	
	@Test
	public void transferenciaExitosa() {
		Cuenta cuentaOrigen = new Cuenta();
		cuentaOrigen.depositar(10_000);
		assertEquals(10_000, cuentaOrigen.getSaldo(), 0);
		
		Cuenta cuentaDestino = new Cuenta();
		assertEquals(0, cuentaDestino.getSaldo(), 0);
		
		cuentaOrigen.transferir(550, cuentaDestino);
		assertEquals(9_450, cuentaOrigen.getSaldo(), 0);
		assertEquals(550, cuentaDestino.getSaldo(), 0);
	}

}
