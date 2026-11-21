package ejemplo1_notificaciones.sin_dip;

/**
 * Módulo de bajo nivel concreto.
 * Dependencia rígida.
 */
public class EmailService {
    public void enviarEmail(String receptor, String mensaje) {
        System.out.println("[EMAIL] Enviando correo a " + receptor + ": " + mensaje);
    }
}
