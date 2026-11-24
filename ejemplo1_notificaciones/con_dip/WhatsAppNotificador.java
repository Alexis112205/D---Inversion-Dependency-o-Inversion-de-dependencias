
/**
 * Módulo de bajo nivel - Implementación concreta de WhatsApp.
 */
public class WhatsAppNotificador implements INotificador {
    @Override
    public void enviar(String destinatario, String mensaje) {
        System.out.println("[WHATSAPP enviado al contacto " + destinatario + "]: " + mensaje);
    }
}
