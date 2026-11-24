
/**
 * Implementación concreta 1: Base de datos Relacional MySQL.
 * Los detalles dependen de la abstracción IBaseDeDatos.
 */
public class MySQLDatabase implements IBaseDeDatos {
    @Override
    public void guardar(Usuario usuario) {
        System.out.println("[MySQL Server SQL] INSERT INTO usuarios VALUES (" 
                + usuario.getId() + ", '" + usuario.getNombre() + "', '" + usuario.getEmail() + "');");
    }

    @Override
    public Usuario obtenerPorId(int id) {
        System.out.println("[MySQL Server SQL] SELECT * FROM usuarios WHERE id = " + id);
        return new Usuario(id, "Erik Enriquez (MySQL)", "erik@unicamacho.edu.co");
    }

    @Override
    public String obtenerTipoMotor() {
        return "MySQL RDBMS v8.0";
    }
}
