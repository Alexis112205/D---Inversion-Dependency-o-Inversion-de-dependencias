package ejemplo1_notificaciones.sin_dip;

/**
 * Módulo de alto nivel que contiene la lógica de negocio.
 * 
 * VIOLACIÓN DEL PRINCIPIO DIP:
 * 1. Depende directamente de una clase concreta de bajo nivel (EmailService).
 * 2. Instancia la dependencia con 'new', quedando fuertemente acoplado.
 * 3. Si se desea cambiar o añadir SMS o WhatsApp, esta clase debe ser modificada.
 */
public class NotificadorService {
    // Acoplamiento fuerte a una clase concreta
    private EmailService emailService;

    public NotificadorService() {
        // La clase de alto nivel controla la creación de la dependencia
        this.emailService = new EmailService();
    }

    public void alertarUsuario(String usuario, String mensaje) {
        System.out.println("Procesando notificación para usuario: " + usuario);
        emailService.enviarEmail(usuario + "@correo.com", mensaje);
    }
}
