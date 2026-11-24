
/**
 * Módulo de alto nivel (Lógica de negocio).
 * 
 * APLICANDO EL PRINCIPIO DIP:
 * - Depende exclusivamente de la abstracción IBaseDeDatos.
 * - Es 100% agnóstico al motor de base de datos utilizado.
 * - Recibe la dependencia por Inyección en el Constructor.
 */
public class UsuarioService {
    private final IBaseDeDatos baseDeDatos;

    // Inyección de dependencias por constructor
    public UsuarioService(IBaseDeDatos baseDeDatos) {
        if (baseDeDatos == null) {
            throw new IllegalArgumentException("La base de datos no puede ser nula.");
        }
        this.baseDeDatos = baseDeDatos;
    }

    public void registrarUsuario(int id, String nombre, String email) {
        System.out.println("Validando usuario [" + nombre + "] con motor: " + baseDeDatos.obtenerTipoMotor());
        Usuario nuevo = new Usuario(id, nombre, email);
        baseDeDatos.guardar(nuevo);
        System.out.println("¡Usuario registrado con éxito!");
    }

    public Usuario consultarUsuario(int id) {
        return baseDeDatos.obtenerPorId(id);
    }
}
