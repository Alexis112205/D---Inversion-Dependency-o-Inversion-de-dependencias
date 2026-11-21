package ejemplo2_pagos.sin_dip;

/**
 * Módulo concreto de bajo nivel.
 */
public class PagoTarjeta {
    public void cobrarTarjeta(double total) {
        System.out.println("[TARJETA] Cobrando $" + total + " pesos colombianos con Tarjeta de Crédito.");
    }
}
