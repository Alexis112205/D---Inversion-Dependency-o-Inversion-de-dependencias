"""
Ejemplo 1 (CON DIP) - Notificaciones Desacopladas
Responsable: Jhon Alexis Correa
Lenguaje: Python (OOP con abc.ABC)
"""
from abc import ABC, abstractmethod

# 1. Abstracción (Interfaz)
class INotificador(ABC):
    @abstractmethod
    def enviar(self, destinatario: str, mensaje: str) -> None:
        pass

# 2. Implementaciones concretas de bajo nivel
class EmailNotificador(INotificador):
    def enviar(self, destinatario: str, mensaje: str) -> None:
        print(f"[EMAIL enviado a {destinatario}]: {mensaje}")

class SmsNotificador(INotificador):
    def enviar(self, destinatario: str, mensaje: str) -> None:
        print(f"[SMS enviado al móvil {destinatario}]: {mensaje}")

class WhatsAppNotificador(INotificador):
    def enviar(self, destinatario: str, mensaje: str) -> None:
        print(f"[WHATSAPP enviado al contacto {destinatario}]: {mensaje}")

# 3. Módulo de alto nivel (Lógica de negocio)
class NotificadorService:
    def __init__(self, notificador: INotificador):
        self._notificador = notificador

    def alertar_usuario(self, usuario: str, mensaje: str) -> None:
        print(f"Procesando notificación desacoplada para: {usuario}")
        self._notificador.enviar(usuario, mensaje)

if __name__ == "__main__":
    print("=== EJEMPLO 1 (CON DIP) - Notificaciones Desacopladas ===")
    
    # Inyección de Email
    servicio_email = NotificadorService(EmailNotificador())
    servicio_email.alertar_usuario("jhon.correa@unicamacho.edu.co", "Tu entrega ha sido recibida.")
    print("-" * 50)

    # Inyección de SMS
    servicio_sms = NotificadorService(SmsNotificador())
    servicio_sms.alertar_usuario("+57 315 1234567", "Tu código de verificación es 482910.")
    print("-" * 50)

    # Inyección de WhatsApp
    servicio_wa = NotificadorService(WhatsAppNotificador())
    servicio_wa.alertar_usuario("+57 320 7654321", "¡Tu paquete ya está en camino!")
