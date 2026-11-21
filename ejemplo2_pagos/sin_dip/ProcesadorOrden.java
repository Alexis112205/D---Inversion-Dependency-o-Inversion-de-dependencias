package ejemplo2_pagos.sin_dip;

/**
 * Módulo de alto nivel que gestiona pedidos de la tienda.
 * 
 * VIOLACIÓN DEL PRINCIPIO DIP:
 * Esta clase depende rígidamente de 'PagoTarjeta'. Si la tienda quiere permitir
 * pagos con PayPal o Nequi, hay que modificar esta clase de negocio.
 */
public class ProcesadorOrden {
    // Acoplamiento directo a la implementación
    private PagoTarjeta medioPago;

    public ProcesadorOrden() {
        // La clase de negocio crea directamente la dependencia concreta
        this.medioPago = new PagoTarjeta();
    }

    public void procesarCompra(String cliente, double total) {
        System.out.println("Procesando compra para el cliente: " + cliente);
        medioPago.cobrarTarjeta(total);
    }
}
