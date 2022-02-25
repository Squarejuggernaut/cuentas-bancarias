package cuenta;

/**
 * Clase que permite retirar todo el saldo disponible y un préstamo de cierta cantidad de dinero que se indica al momento de crear una nueva Cuenta Corriente
 * @author Facundo Paz
 *
 */

public class CuentaCorriente extends Cuenta {
	private double prestamoDisponible;

	/**
	 * Constructor que permite instanciar cuentas corrientes.
	 * @param prestamoDisponible indicar de cuánto va a ser el préstamo disponible.
	 * @throws Error si se indica dinero en negativo.
	 */
	public CuentaCorriente(double prestamoDisponible) {
		super();
		setPrestamoDisponible(prestamoDisponible);
	}
	
	/**
	 * Constructor para instanciar cuentas corrientes por defecto, sin préstamo disponible.
	 */
	public CuentaCorriente() {
		this(0);
	}

	/**
	 * Método que indica cuánto queda saldo queda de préstamo para retirar.
	 * @return prestamo disponible.
	 */
	public double getPrestamoDisponible() {
		return prestamoDisponible;
	}
	
	/**
	 * Método para validar que al momento de instanciar una cuenta no lleguen números negativos
	 * @param prestamoDisponible indicar la cantidad
	 */
	public void setPrestamoDisponible(double prestamoDisponible) {
		if (prestamoDisponible < 0) {
			throw new Error("El préstamo debe ser mayor a uno");
		}
		this.prestamoDisponible = prestamoDisponible;
	}
	
	/**
	 * Método que permite retirar todo el saldo disponible y todo el préstamo que haya disponible.
	 */
	public void retirarTodo() {
		this.depositar(prestamoDisponible);
		this.prestamoDisponible = 0;
	}
	
	
	
}
