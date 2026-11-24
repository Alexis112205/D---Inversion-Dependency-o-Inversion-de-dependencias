
/**
 * Implementación concreta de pago con Tarjeta de Crédito.
 */
public class PagoTarjeta implements IMetodoPago {
    @Override
    public void pagar(double monto) {
        System.out.println("[TARJETA] Transacción aprobada por $" + monto + " COP.");
    }

    @Override
    public String obtenerNombre() {
        return "Tarjeta de Crédito";
    }
}
