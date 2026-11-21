package ejemplo2_pagos.con_dip;

/**
 * Módulo de alto nivel desacoplado.
 * 
 * APLICANDO EL PRINCIPIO DIP:
 * - Depende de la interfaz IMetodoPago.
 * - Permite inyección por Constructor Y TAMBIÉN inyección por Setter (para cambiar de método en caliente).
 */
public class ProcesadorOrden {
    private IMetodoPago metodoPago;

    // Inyección de dependencias por constructor
    public ProcesadorOrden(IMetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    // Inyección de dependencias por Setter (permite cambiar la dependencia en tiempo de ejecución)
    public void setMetodoPago(IMetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public void finalizarCompra(String cliente, double total) {
        System.out.println("\nFacturando orden para: " + cliente);
        System.out.println("Método de pago seleccionado: " + metodoPago.obtenerNombre());
        metodoPago.pagar(total);
    }
}
