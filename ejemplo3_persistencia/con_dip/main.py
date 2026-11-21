"""
Ejemplo 3 (CON DIP) - Persistencia y Bases de Datos
Responsable: Erik Johan Enriquez Vera
Lenguaje: Python (OOP con abc.ABC)
Conexión directa con Diapositivas 5 y 6 de la exposición.
"""
from abc import ABC, abstractmethod

class Usuario:
    def __init__(self, id_usuario: int, nombre: str, email: str):
        self.id = id_usuario
        self.nombre = nombre
        self.email = email

# 1. Abstracción (Interfaz según Diapositiva 6)
class IBaseDeDatos(ABC):
    @abstractmethod
    def guardar(self, usuario: Usuario) -> None:
        pass

    @abstractmethod
    def obtener_tipo_motor(self) -> str:
        pass

# 2. Implementaciones concretas (Bajo nivel)
class MySQLDatabase(IBaseDeDatos):
    def guardar(self, usuario: Usuario) -> None:
        print(f"[MySQL SQL] INSERT INTO usuarios VALUES ({usuario.id}, '{usuario.nombre}', '{usuario.email}');")

    def obtener_tipo_motor(self) -> str:
        return "MySQL RDBMS v8.0"

class MongoDBDatabase(IBaseDeDatos):
    def guardar(self, usuario: Usuario) -> None:
        print(f"[MongoDB NoSQL] db.usuarios.insertOne({{ _id: {usuario.id}, nombre: '{usuario.nombre}', email: '{usuario.email}' }});")

    def obtener_tipo_motor(self) -> str:
        return "MongoDB NoSQL Document Store v7.0"

# 3. Módulo de alto nivel (Lógica de negocio)
class UsuarioService:
    def __init__(self, db: IBaseDeDatos):
        self._db = db

    def registrar_usuario(self, id_u: int, nombre: str, email: str) -> None:
        print(f"Validando usuario [{nombre}] con motor: {self._db.obtener_tipo_motor()}")
        usuario = Usuario(id_u, nombre, email)
        self._db.guardar(usuario)
        print("¡Usuario registrado con éxito!")

if __name__ == "__main__":
    print("=== EJEMPLO 3 (CON DIP) - Persistencia Desacoplada (Diapositiva 6) ===")

    # Inyectando MySQL
    servicio_mysql = UsuarioService(MySQLDatabase())
    servicio_mysql.registrar_usuario(101, "Erik Enriquez", "erik@unicamacho.edu.co")
    print("-" * 50)

    # Migrando a MongoDB sin tocar UsuarioService
    servicio_mongo = UsuarioService(MongoDBDatabase())
    servicio_mongo.registrar_usuario(102, "Deiby Velasco", "deiby@unicamacho.edu.co")
