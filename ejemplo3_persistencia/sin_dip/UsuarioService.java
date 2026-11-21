package ejemplo3_persistencia.sin_dip;

/**
 * Módulo de alto nivel (Lógica de negocio).
 * 
 * EXACTAMENTE EL CASO DE LA DIAPOSITIVA 5:
 * "UsuarioService (alto nivel) instancia directamente a MySQLDatabase (bajo nivel).
 * Esto genera un problema grave: si en el futuro la empresa decide migrar a MongoDB
 * o PostgreSQL, estaremos obligados a modificar el código interno de la lógica del negocio."
 */
public class UsuarioService {
    // Acoplamiento fuerte al detalle técnico
    private MySQLDatabase baseDeDatos;

    public UsuarioService() {
        // Violación DIP: 'new' directo de clase concreta de bajo nivel
        this.baseDeDatos = new MySQLDatabase();
    }

    public void registrarUsuario(int id, String nombre, String email) {
        System.out.println("Validando reglas de negocio para nuevo usuario...");
        Usuario nuevo = new Usuario(id, nombre, email);
        baseDeDatos.insertarUsuario(nuevo);
    }
}
