package cuenta;

/**
 * Clase que simula una cuenta de ahorro donde se puede reservar saldo en una
 * especie de saldo secundario siempre y cuando haya un saldo que reservar,
 * también se puede reintegrar el dinero cuando el usuario lo requiera de su
 * saldo secundario o reservado a su saldo principal.
 * 
 * @author Facundo Paz
 *
 */
public class CuentaDeAhorro extends Cuenta {
	private double saldoReservado;

	/**
	 * Método que permite ver el saldo actual que esté reservado.
	 * 
	 * @return El total del saldo reservado.
	 */
	public double getSaldoReservado() {
		return saldoReservado;
	}

	/**
	 * Método para pasar una cierta cantidad de saldo disponible a un saldo
	 * secundario o reservado.
	 * 
	 * @param monto cantidad de saldo a reservar.
	 * @throws Error Si no hay saldo o lo que se quiere reservar es mayor al saldo
	 *               actual se lanzará un error.
	 */
	public void reservarSaldo(double monto) {
		if (dineroValido(monto) && this.saldo >= monto) {
			this.saldo -= monto;
			this.saldoReservado += monto;
		} else {
			throw new Error("Saldo insuficiente para realizar operación.");
		}

	}

	/**
	 * Método que permite reintegrar la totalidad del saldo reservado al saldo
	 * principal.
	 * 
	 * @throws Error Fallará si se quiere reintegrar un saldo reservado inexistente.
	 */
	public void reintegrarSaldo() {
		if (this.saldoReservado > 0) {
			this.depositar(saldoReservado);
			this.saldoReservado = 0;
		} else {
			throw new Error("No hay saldo reservado para reintegrar.");
		}

	}
	
	/**
	 * Método que permite reintegrar parte del saldo reservado al saldo principal.
	 * @param monto Dinero a reintegrar.
	 * @throws Error Fallará si el monto a reintegrar es mayor al saldo reservado
	 */
	public void reintegrarParteDelSaldo(double monto) {
		if (this.saldoReservado >= monto) {
			this.depositar(monto);
			this.saldoReservado -= monto;
		} else {
			throw new Error("No se ha podido reintegrar por saldo reservado insuficiente");
		}
	}

}
