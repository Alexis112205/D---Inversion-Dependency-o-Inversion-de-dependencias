
/**
 * Ejemplo 3 - Responsable: Erik Johan Enriquez Vera
 * Demostración de SOLUCIÓN DIP según Diapositiva 6 de la exposición.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== EJEMPLO 3 (CON DIP) - Persistencia Desacoplada (Diapositiva 6) ===");

        // 1. Inyectando MySQL
        IBaseDeDatos mysql = new MySQLDatabase();
        UsuarioService servicioMySQL = new UsuarioService(mysql);
        servicioMySQL.registrarUsuario(101, "Erik Enriquez", "erik@unicamacho.edu.co");

        System.out.println("----------------------------------------------------------------------");

        // 2. Migrando a MongoDB sin modificar una sola línea de UsuarioService
        IBaseDeDatos mongo = new MongoDBDatabase();
        UsuarioService servicioMongo = new UsuarioService(mongo);
        servicioMongo.registrarUsuario(102, "Deiby Velasco", "deiby@unicamacho.edu.co");

        System.out.println("\n[VENTAJA DEMOSTRADA]:");
        System.out.println("El módulo de alto nivel (UsuarioService) y los de bajo nivel (MySQL, MongoDB)");
        System.out.println("dependen de la abstracción (IBaseDeDatos). Se cumple la regla de Robert C. Martin.");
    }
}
