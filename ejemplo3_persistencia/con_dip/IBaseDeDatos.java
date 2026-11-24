
/**
 * Abstracción (Interfaz)
 * EXACTAMENTE LA SOLUCIÓN DE LA DIAPOSITIVA 6:
 * "Invertimos la dependencia creando una interfaz llamada BaseDeDatos.
 * Ahora, tanto MySQL como MongoDB están obligados a implementar esa interfaz,
 * y UsuarioService solo se comunica con ella."
 */
public interface IBaseDeDatos {
    void guardar(Usuario usuario);
    Usuario obtenerPorId(int id);
    String obtenerTipoMotor();
}
