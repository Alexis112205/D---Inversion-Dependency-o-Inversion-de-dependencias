
/**
 * Módulo de bajo nivel - Implementación concreta de Email.
 */
public class EmailNotificador implements INotificador {
    @Override
    public void enviar(String destinatario, String mensaje) {
        System.out.println("[EMAIL enviado a " + destinatario + "]: " + mensaje);
    }
}
