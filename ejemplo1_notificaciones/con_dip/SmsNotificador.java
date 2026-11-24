
/**
 * Módulo de bajo nivel - Implementación concreta de SMS.
 */
public class SmsNotificador implements INotificador {
    @Override
    public void enviar(String destinatario, String mensaje) {
        System.out.println("[SMS enviado al móvil " + destinatario + "]: " + mensaje);
    }
}
