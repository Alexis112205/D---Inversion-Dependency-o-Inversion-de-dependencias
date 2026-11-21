# Principio de Inversión de Dependencias (DIP) - SOLID
## Programación II | Institución Universitaria Antonio José Camacho (UNICAMACHO)

---

### 👥 Integrantes (Grupo 5 - Fila 6)
* **Jhon Alexis Correa**
* **Deiby Alexander Velasco**
* **Erik Johan Enriquez Vera**

**Materia:** Programación II  
**Tema:** D - Inversion Dependency o Inversión de Dependencias (SOLID)  
**Fecha de Entrega:** 23 de Noviembre de 2026  

---

## 📖 1. ¿Qué es el Principio de Inversión de Dependencias (DIP)?

El **Principio de Inversión de Dependencias** (*Dependency Inversion Principle* o **DIP**) es el quinto y último de los principios **SOLID**, formulado por **Robert C. Martin ("Uncle Bob")**. Su objetivo principal es reducir el acoplamiento entre los módulos de software para lograr sistemas más mantenibles, flexibles, escalables y testeables.

### Las Dos Reglas Fundamentales:
1. **Los módulos de alto nivel no deben depender de los módulos de bajo nivel.** Ambos deben depender de **abstracciones** (interfaces o clases abstractas).
2. **Las abstracciones no deben depender de los detalles.** Los detalles (implementaciones concretas) deben depender de las abstracciones.

```
       CÓDIGO TRADICIONAL (ACOPLADO)
┌───────────────────────────────┐
│ Módulo Alto Nivel (Negocio)   │ ──(depende de)──> ┌───────────────────────────────┐
└───────────────────────────────┘                   │ Módulo Bajo Nivel (Detalle)   │
                                                    └───────────────────────────────┘

       CÓDIGO CON DIP (DESACOPLADO)
┌───────────────────────────────┐                   ┌───────────────────────────────┐
│ Módulo Alto Nivel (Negocio)   │ ──(depende de)──> │     ABSTRACCIÓN (Interfaz)    │
└───────────────────────────────┘                   └───────────────────────────────┘
                                                                    ▲
                                                                    │ (implementa)
                                                    ┌───────────────────────────────┐
                                                    │ Módulo Bajo Nivel (Detalle)   │
                                                    └───────────────────────────────┘
```

---

## ⚖️ 2. DIP vs. DI (Inyección de Dependencias)

Es muy común confundir estos dos términos:
* **Principio de Inversión de Dependencias (DIP):** Es el **principio de diseño conceptual y arquitectónico**. Nos dice *qué regla seguir* ("depende de abstracciones, no de concreciones").
* **Inyección de Dependencias (DI):** Es el **patrón de diseño o técnica práctica**. Nos dice *cómo entregarle* la dependencia a una clase desde el exterior en lugar de que la clase la cree internamente con `new`.

### Métodos de Inyección de Dependencias:
1. **Por Constructor (Recomendada):** La dependencia se inyecta al momento de instanciar el objeto. Garantiza que el objeto siempre esté en un estado válido e inmutable.
2. **Por Setter (Modificador):** Permite cambiar o reconfigurar la dependencia en tiempo de ejecución (en caliente).
3. **Por Interfaz:** La clase implementa una interfaz que define un método para recibir la dependencia.

---

## 📂 3. Estructura del Repositorio y Ejemplos Prácticos

El repositorio contiene **3 ejemplos completos**, asignados a cada integrante del grupo, organizados en sus versiones **Sin DIP** (violando el principio) y **Con DIP** (solución desacoplada mediante interfaces e inyección):

```text
├── README.md
├── ejemplo1_notificaciones/          # Integrante: Jhon Alexis Correa
│   ├── sin_dip/                      # Alto acoplamiento con EmailService
│   │   ├── EmailService.java
│   │   ├── NotificadorService.java
│   │   └── Main.java
│   └── con_dip/                      # Desacoplado con INotificador
│       ├── INotificador.java
│       ├── EmailNotificador.java
│       ├── SmsNotificador.java
│       ├── WhatsAppNotificador.java
│       ├── NotificadorService.java
│       └── Main.java
│
├── ejemplo2_pagos/                   # Integrante: Deiby Alexander Velasco
│   ├── sin_dip/                      # Dependencia rígida de PagoTarjeta
│   │   ├── PagoTarjeta.java
│   │   ├── ProcesadorOrden.java
│   │   └── Main.java
│   └── con_dip/                      # Desacoplado con IMetodoPago (Constructor + Setter)
│       ├── IMetodoPago.java
│       ├── PagoTarjeta.java
│       ├── PagoPayPal.java
│       ├── PagoNequi.java
│       ├── ProcesadorOrden.java
│       └── Main.java
│
└── ejemplo3_persistencia/            # Integrante: Erik Johan Enriquez Vera
    ├── sin_dip/                      # Caso Diapositiva 5: UsuarioService acoplado a MySQL
    │   ├── Usuario.java
    │   ├── MySQLDatabase.java
    │   ├── UsuarioService.java
    │   └── Main.java
    └── con_dip/                      # Caso Diapositiva 6: Desacoplado con IBaseDeDatos
        ├── Usuario.java
        ├── IBaseDeDatos.java
        ├── MySQLDatabase.java
        ├── MongoDBDatabase.java
        ├── UsuarioService.java
        └── Main.java
```

---

## 💻 4. Explicación Detallada de los Ejemplos

### 🔹 Ejemplo 1: Servicio de Notificaciones (Jhon Alexis Correa)
* **Problema (Sin DIP):** La clase de negocio `NotificadorService` instancia directamente `new EmailService()`. Si el negocio requiere notificar vía SMS o WhatsApp, es mandatorio abrir y alterar el código de `NotificadorService`, arriesgando errores.
* **Solución (Con DIP):** 
  * Se define el contrato `INotificador`.
  * Se crean implementaciones concretas intercambiables: `EmailNotificador`, `SmsNotificador`, `WhatsAppNotificador`.
  * `NotificadorService` recibe cualquier notificador por **constructor**.

### 🔹 Ejemplo 2: Pasarela de Pagos Multicanal (Deiby Alexander Velasco)
* **Problema (Sin DIP):** `ProcesadorOrden` está atado a `PagoTarjeta`. No se puede pagar con PayPal ni transferencias móviles como Nequi sin modificar la lógica del pedido.
* **Solución (Con DIP):**
  * Se crea la abstracción `IMetodoPago`.
  * Se implementan `PagoTarjeta`, `PagoPayPal` y `PagoNequi`.
  * `ProcesadorOrden` soporta inyección por **constructor** y también por **setter**, lo que permite cambiar el método de pago dinámicamente en caliente durante la ejecución del programa.

### 🔹 Ejemplo 3: Persistencia y Bases de Datos (Erik Johan Enriquez Vera)
* **Caso real de las Diapositivas 5 y 6 de la exposición:**
  * **Problema (Sin DIP):** `UsuarioService` (alto nivel) hace `new MySQLDatabase()`. Al migrar a MongoDB o PostgreSQL, se rompe la arquitectura.
  * **Solución (Con DIP):** Se introduce la interfaz `IBaseDeDatos`. Tanto `MySQLDatabase` como `MongoDBDatabase` dependen de ella. `UsuarioService` trabaja exclusivamente contra la abstracción, logrando un desacoplamiento total.

---

## 🚀 5. Cómo Compilar y Ejecutar

Puedes abrir y ejecutar el proyecto en cualquier IDE (**VS Code**, **IntelliJ IDEA**, **Eclipse** o **NetBeans**) abriendo la carpeta raíz.

También puedes compilar y ejecutar directamente desde la terminal con el JDK de Java:

```bash
# Compilar y ejecutar Ejemplo 1 (Con DIP)
javac ejemplo1_notificaciones/con_dip/*.java
java ejemplo1_notificaciones.con_dip.Main

# Compilar y ejecutar Ejemplo 2 (Con DIP)
javac ejemplo2_pagos/con_dip/*.java
java ejemplo2_pagos.con_dip.Main

# Compilar y ejecutar Ejemplo 3 (Con DIP)
javac ejemplo3_persistencia/con_dip/*.java
java ejemplo3_persistencia.con_dip.Main
```

---

## 🏆 6. Beneficios de Aplicar DIP

1. **Bajo Acoplamiento:** Los módulos pueden evolucionar o ser reemplazados de forma independiente.
2. **Facilidad de Pruebas Unitarias (Testing):** Permite inyectar *Mocks* o *Stubs* para probar la lógica de negocio sin depender de bases de datos reales o servicios externos.
3. **Sinergia con SOLID:** Permite cumplir **OCP** (Abierto a la extensión, cerrado a la modificación) y **LSP** (Sustitución de Liskov).
