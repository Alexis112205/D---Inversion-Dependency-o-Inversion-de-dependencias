
/**
 * Implementación concreta de pago con PayPal.
 */
public class PagoPayPal implements IMetodoPago {
    private String emailUsuario;

    public PagoPayPal(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    @Override
    public void pagar(double monto) {
        System.out.println("[PAYPAL] Pago de $" + monto + " debitado de la cuenta " + emailUsuario + ".");
    }

    @Override
    public String obtenerNombre() {
        return "PayPal";
    }
}
