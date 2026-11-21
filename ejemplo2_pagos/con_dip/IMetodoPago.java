package ejemplo2_pagos.con_dip;

/**
 * Abstracción (Interfaz)
 * Define el contrato estándar para cualquier método de pago.
 */
public interface IMetodoPago {
    void pagar(double monto);
    String obtenerNombre();
}
