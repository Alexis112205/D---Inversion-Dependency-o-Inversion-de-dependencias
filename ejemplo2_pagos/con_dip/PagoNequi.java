package ejemplo2_pagos.con_dip;

/**
 * Implementación concreta de pago con Nequi.
 */
public class PagoNequi implements IMetodoPago {
    private String celular;

    public PagoNequi(String celular) {
        this.celular = celular;
    }

    @Override
    public void pagar(double monto) {
        System.out.println("[NEQUI] Notificación push enviada al celular " + celular + " para confirmar $" + monto + ".");
    }

    @Override
    public String obtenerNombre() {
        return "Nequi Colombia";
    }
}
