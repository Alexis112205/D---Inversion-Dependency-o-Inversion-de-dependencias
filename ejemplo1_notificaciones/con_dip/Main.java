
/**
 * Ejemplo 1 - Responsable: Jhon Alexis Correa
 * Demostración de CÓDIGO DESACOPLADO (Cumpliendo DIP)
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== EJEMPLO 1 (CON DIP) - Notificaciones Desacopladas ===");

        // Creamos las implementaciones concretas
        INotificador email = new EmailNotificador();
        INotificador sms = new SmsNotificador();
        INotificador whatsapp = new WhatsAppNotificador();

        // Inyectamos Email al servicio
        NotificadorService servicioEmail = new NotificadorService(email);
        servicioEmail.alertarUsuario("jhon.correa@unicamacho.edu.co", "Tu entrega ha sido recibida.");

        System.out.println("--------------------------------------------------");

        // Inyectamos SMS sin cambiar una sola línea de NotificadorService
        NotificadorService servicioSMS = new NotificadorService(sms);
        servicioSMS.alertarUsuario("+57 315 1234567", "Tu código de verificación es 482910.");

        System.out.println("--------------------------------------------------");

        // Inyectamos WhatsApp fácilmente
        NotificadorService servicioWhatsApp = new NotificadorService(whatsapp);
        servicioWhatsApp.alertarUsuario("+57 320 7654321", "¡Tu paquete ya está en camino!");

        System.out.println("\n[VENTAJA]: Podemos crear infinitos canales (Slack, Telegram, Push)");
        System.out.println("sin tocar ni una sola línea de NotificadorService.java.");
    }
}
