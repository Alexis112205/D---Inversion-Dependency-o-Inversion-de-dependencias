
/**
 * Ejemplo 1 - Responsable: Jhon Alexis Correa
 * Demostración de código con ALTO ACOPLAMIENTO (Violando DIP)
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== EJEMPLO 1 (SIN DIP) - Notificaciones ===");
        NotificadorService notificador = new NotificadorService();
        notificador.alertarUsuario("jhon_correa", "Tu pedido ha sido despachado.");

        System.out.println("\n[PROBLEMA]: Si el cliente ahora quiere notificación por SMS o WhatsApp,");
        System.out.println("estamos forzados a abrir y modificar NotificadorService.java.");
    }
}
