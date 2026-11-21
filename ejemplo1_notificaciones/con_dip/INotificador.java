package ejemplo1_notificaciones.con_dip;

/**
 * Abstracción (Interfaz)
 * Define el contrato que deben cumplir todas las formas de notificación.
 * Tanto el módulo de alto nivel como los de bajo nivel dependen de esta abstracción.
 */
public interface INotificador {
    void enviar(String destinatario, String mensaje);
}
