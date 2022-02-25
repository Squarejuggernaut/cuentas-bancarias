package cuentaTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cuenta.CuentaCorriente;

public class CuentaCorrienteTests {

	CuentaCorriente conPrestamoDisponible;
	CuentaCorriente sinPrestamoDisponible;
	
	@Before
	public void setUp() {
		conPrestamoDisponible = new CuentaCorriente(2000);
		sinPrestamoDisponible = new CuentaCorriente();
	}
	
	@Test(expected = Error.class)
	public void noConstruyeCuentaConPrestamoInvalido() {
		@SuppressWarnings("unused")
		CuentaCorriente cuenta = new CuentaCorriente(-10);
	}
	
	@Test
	public void creacion() {
		assertNotNull(conPrestamoDisponible);
		assertNotNull(sinPrestamoDisponible);
		assertEquals(2000, conPrestamoDisponible.getPrestamoDisponible(), 0);
		assertEquals(0, sinPrestamoDisponible.getPrestamoDisponible(), 0);
	}
	
	@Test
	public void puedeRetirarTodoLoDisponible() {
		conPrestamoDisponible.depositar(1500);
		conPrestamoDisponible.retirarTodo();
		assertEquals(3500, conPrestamoDisponible.getSaldo(), 0);
		assertEquals(0, conPrestamoDisponible.getPrestamoDisponible(), 0);
	}

}
