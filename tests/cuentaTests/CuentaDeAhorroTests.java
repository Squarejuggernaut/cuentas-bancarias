package cuentaTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cuenta.CuentaDeAhorro;

public class CuentaDeAhorroTests {
	CuentaDeAhorro cuenta1;
	
	@Before
	public void setUp() {
		cuenta1 = new CuentaDeAhorro();
	}

	@Test
	public void creacionTest() {
		assertNotNull(cuenta1);
	}
	
	@Test
	public void reservarSaldo() {
		cuenta1.depositar(1000);
		assertEquals(1000, cuenta1.getSaldo(), 0);
		assertEquals(0, cuenta1.getSaldoReservado(), 0);
		cuenta1.reservarSaldo(700);
		assertEquals(300, cuenta1.getSaldo(), 0);
		assertEquals(700, cuenta1.getSaldoReservado(), 0);
	}
	
	@Test (expected = Error.class)
	public void reservarSaldoIncorrecto() {
		cuenta1.depositar(200);
		cuenta1.reservarSaldo(1000);
	}
	
	@Test
	public void reintegrarSaldo() {
		cuenta1.depositar(2000);
		cuenta1.reservarSaldo(500);
		cuenta1.reintegrarSaldo();
		
		assertEquals(0, cuenta1.getSaldoReservado(), 0);
		assertEquals(2000, cuenta1.getSaldo(), 0);
	}
	
	@Test(expected = Error.class)
	public void reintegrarSaldoNoValido() {
		cuenta1.reintegrarSaldo();
	}
	
	@Test
	public void reintegrarParteDelSaldo() {
		cuenta1.depositar(1500);
		cuenta1.reservarSaldo(900);
		cuenta1.reintegrarParteDelSaldo(400);
		
		assertEquals(1000, cuenta1.getSaldo(), 0);
		assertEquals(500, cuenta1.getSaldoReservado(), 0);
	}

	@Test(expected = Error.class)
	public void fallaReintegracionPorSaldoReservadoInsuficiente() {
		cuenta1.depositar(500);
		cuenta1.reservarSaldo(400);
		cuenta1.reintegrarParteDelSaldo(8000);
	}
}
