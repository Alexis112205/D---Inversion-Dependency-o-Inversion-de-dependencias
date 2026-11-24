
/**
 * Ejemplo 2 - Responsable: Deiby Alexander Velasco
 * Demostración de código RÍGIDO (Violando DIP)
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== EJEMPLO 2 (SIN DIP) - Procesamiento de Pagos ===");
        ProcesadorOrden orden = new ProcesadorOrden();
        orden.procesarCompra("Deiby Velasco", 150000.0);

        System.out.println("\n[PROBLEMA]: Si el cliente quiere pagar con Nequi o PayPal,");
        System.out.println("ProcesadorOrden está atado a tarjeta de crédito y debe modificarse.");
    }
}
