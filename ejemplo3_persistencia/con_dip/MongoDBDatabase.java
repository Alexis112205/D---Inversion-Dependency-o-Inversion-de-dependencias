
/**
 * Implementación concreta 2: Base de datos NoSQL MongoDB.
 * Nueva tecnología añadida sin tocar la lógica de negocio (cumple OCP y DIP).
 */
public class MongoDBDatabase implements IBaseDeDatos {
    @Override
    public void guardar(Usuario usuario) {
        System.out.println("[MongoDB NoSQL] db.usuarios.insertOne({ _id: " 
                + usuario.getId() + ", nombre: '" + usuario.getNombre() + "', email: '" + usuario.getEmail() + "' });");
    }

    @Override
    public Usuario obtenerPorId(int id) {
        System.out.println("[MongoDB NoSQL] db.usuarios.findOne({ _id: " + id + " });");
        return new Usuario(id, "Erik Enriquez (Mongo)", "erik@unicamacho.edu.co");
    }

    @Override
    public String obtenerTipoMotor() {
        return "MongoDB NoSQL Document Store v7.0";
    }
}
