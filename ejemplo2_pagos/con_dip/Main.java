package ejemplo2_pagos.con_dip;

/**
 * Ejemplo 2 - Responsable: Deiby Alexander Velasco
 * Demostración de CÓDIGO DESACOPLADO (Cumpliendo DIP)
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== EJEMPLO 2 (CON DIP) - Pagos Desacoplados y Polimorfismo ===");

        // 1. Cliente paga con Tarjeta
        IMetodoPago tarjeta = new PagoTarjeta();
        ProcesadorOrden orden = new ProcesadorOrden(tarjeta);
        orden.finalizarCompra("Deiby Velasco", 280000.0);

        // 2. Cliente decide pagar con PayPal (Inyección por Setter)
        System.out.println("--------------------------------------------------");
        IMetodoPago paypal = new PagoPayPal("deiby.velasco@gmail.com");
        orden.setMetodoPago(paypal);
        orden.finalizarCompra("Deiby Velasco", 95000.0);

        // 3. Otro cliente paga con Nequi (Inyección por Constructor)
        System.out.println("--------------------------------------------------");
        IMetodoPago nequi = new PagoNequi("318 4567890");
        ProcesadorOrden ordenNequi = new ProcesadorOrden(nequi);
        ordenNequi.finalizarCompra("Carlos Gomez", 45000.0);

        System.out.println("\n[VENTAJA]: Nuevos métodos de pago (DaviPlata, Cripto, Efectivo)");
        System.out.println("se agregan simplemente creando una clase nueva con IMetodoPago.");
    }
}
