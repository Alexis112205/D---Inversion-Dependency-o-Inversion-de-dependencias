
/**
 * Ejemplo 3 - Responsable: Erik Johan Enriquez Vera
 * Demostración de violación de DIP según Diapositiva 5
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== EJEMPLO 3 (SIN DIP) - Diapositiva 5 de la Expo ===");
        UsuarioService servicio = new UsuarioService();
        servicio.registrarUsuario(101, "Erik Enriquez", "erik@unicamacho.edu.co");

        System.out.println("\n[PROBLEMA]: Si la universidad decide migrar a MongoDB NoSQL,");
        System.out.println("debemos modificar UsuarioService.java y reescribir la lógica.");
    }
}
