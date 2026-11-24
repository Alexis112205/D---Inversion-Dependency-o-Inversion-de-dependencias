
/**
 * Módulo de bajo nivel - Acceso a datos relacional (MySQL).
 */
public class MySQLDatabase {
    public void insertarUsuario(Usuario usuario) {
        System.out.println("[MySQL Server] INSERT INTO usuarios VALUES (" 
                + usuario.getId() + ", '" + usuario.getNombre() + "', '" + usuario.getEmail() + "');");
    }

    public Usuario consultarUsuario(int id) {
        System.out.println("[MySQL Server] SELECT * FROM usuarios WHERE id = " + id);
        return new Usuario(id, "Erik Enriquez", "erik.enriquez@unicamacho.edu.co");
    }
}
