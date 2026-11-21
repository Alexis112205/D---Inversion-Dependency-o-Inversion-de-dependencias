package ejemplo1_notificaciones.con_dip;

/**
 * Módulo de alto nivel desacoplado.
 * 
 * APLICANDO EL PRINCIPIO DIP:
 * 1. Depende únicamente de la abstracción (INotificador).
 * 2. No instancia dependencias con 'new'.
 * 3. Recibe la dependencia desde el exterior (Inyección de Dependencias por Constructor).
 */
public class NotificadorService {
    // Depende de la abstracción, NO de una clase concreta
    private final INotificador notificador;

    // Inyección de dependencias por constructor
    public NotificadorService(INotificador notificador) {
        if (notificador == null) {
            throw new IllegalArgumentException("El notificador no puede ser nulo.");
        }
        this.notificador = notificador;
    }

    public void alertarUsuario(String usuario, String mensaje) {
        System.out.println("Procesando notificación desacoplada para: " + usuario);
        // Delega la acción a través de la abstracción
        this.notificador.enviar(usuario, mensaje);
    }
}
