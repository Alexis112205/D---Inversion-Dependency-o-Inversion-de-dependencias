"""
Ejemplo 2 (CON DIP) - Procesamiento de Pagos
Responsable: Deiby Alexander Velasco
Lenguaje: Python (OOP con abc.ABC)
"""
from abc import ABC, abstractmethod

# 1. Abstracción (Interfaz)
class IMetodoPago(ABC):
    @abstractmethod
    def pagar(self, monto: float) -> None:
        pass

    @abstractmethod
    def obtener_nombre(self) -> str:
        pass

# 2. Implementaciones concretas
class PagoTarjeta(IMetodoPago):
    def pagar(self, monto: float) -> None:
        print(f"[TARJETA] Transacción aprobada por ${monto:,.2f} COP.")

    def obtener_nombre(self) -> str:
        return "Tarjeta de Crédito"

class PagoPayPal(IMetodoPago):
    def __init__(self, email: str):
        self.email = email

    def pagar(self, monto: float) -> None:
        print(f"[PAYPAL] Pago de ${monto:,.2f} debitado de la cuenta {self.email}.")

    def obtener_nombre(self) -> str:
        return "PayPal"

class PagoNequi(IMetodoPago):
    def __init__(self, celular: str):
        self.celular = celular

    def pagar(self, monto: float) -> None:
        print(f"[NEQUI] Notificación enviada al móvil {self.celular} para confirmar ${monto:,.2f} COP.")

    def obtener_nombre(self) -> str:
        return "Nequi Colombia"

# 3. Módulo de alto nivel desacoplado
class ProcesadorOrden:
    def __init__(self, metodo_pago: IMetodoPago):
        self.metodo_pago = metodo_pago

    def cambiar_metodo_pago(self, nuevo_metodo: IMetodoPago) -> None:
        self.metodo_pago = nuevo_metodo

    def finalizar_compra(self, cliente: str, total: float) -> None:
        print(f"\nFacturando orden para: {cliente}")
        print(f"Método de pago: {self.metodo_pago.obtener_nombre()}")
        self.metodo_pago.pagar(total)

if __name__ == "__main__":
    print("=== EJEMPLO 2 (CON DIP) - Pagos Desacoplados y Polimorfismo ===")
    
    # Pago con tarjeta
    orden = ProcesadorOrden(PagoTarjeta())
    orden.finalizar_compra("Deiby Velasco", 280000.0)
    print("-" * 50)

    # Cambio en caliente a PayPal (Inyección por Setter)
    orden.cambiar_metodo_pago(PagoPayPal("deiby.velasco@gmail.com"))
    orden.finalizar_compra("Deiby Velasco", 95000.0)
    print("-" * 50)

    # Pago con Nequi
    orden_nequi = ProcesadorOrden(PagoNequi("318 4567890"))
    orden_nequi.finalizar_compra("Carlos Gomez", 45000.0)
