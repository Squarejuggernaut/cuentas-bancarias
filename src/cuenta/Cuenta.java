package cuenta;

/**
 * Manejo super básico de una cuenta bancaria se puede depositar dinero, retirar
 * dinero y consultar el saldo.
 * 
 * @author Facundo Paz
 *
 */

public class Cuenta {
	private double saldo;

	/**
	 * Construye un objeto Cuenta con un saldo = 0.
	 */
	public Cuenta() {
	}

	/**
	 * Obtener saldo actual
	 * 
	 * @return el saldo actual del objeto cuenta.
	 */
	public double getSaldo() {
		return saldo;
	}

	/**
	 * Método para sumar dinero al saldo.
	 * 
	 * @param dinero - monto a ingresar.
	 * @throws Error No recibe un monto que sea menor a uno.
	 */
	public void depositar(double dinero) {
		if (dineroValido(dinero)) {
			this.saldo += dinero;
		}
	}

	/**
	 * Método para restar dinero al saldo.
	 * 
	 * @param dinero - monto a sacar.
	 * @throws Error No se debe ingresar un monto a retirar mayor al saldo actual.
	 */
	public void retirar(double dinero) {
		if (this.saldo >= dinero && dineroValido(dinero)) {
			this.saldo -= dinero;
		} else {
			throw new Error("Saldo insuficiente");
		}
	}

	/**
	 * Corrobora que lo que se ingrese sea un valor positivo.
	 * 
	 * @param dinero - monto.
	 * @return verdadero si el saldo es mayor a 0.
	 * @throws Error si encuentra un valor negativo lanzará el Error.
	 */
	private boolean dineroValido(double dinero) {
		if (dinero > 0) {
			return true;
		}
		throw new Error("No se admiten montos negativos");

	}

}
