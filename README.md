
# Proyecto de Calculadora en Java

Este proyecto implementa una calculadora básica y científica en Java, permitiendo realizar operaciones aritméticas y funciones matemáticas avanzadas. La calculadora puede usarse en modo interactivo mediante un menú o a través de comandos desde la línea de comandos.

## Estructura del Proyecto

El proyecto está organizado en los siguientes paquetes y clases:

- `mx.ipn.upiicsa.poo.calcHerencia.App`: Clase principal que inicia la aplicación y permite seleccionar el modo de uso.
- `mx.ipn.upiicsa.poo.calcHerencia.Calculator.Calculator`: Define métodos básicos de una calculadora, como suma, resta, multiplicación, y división.
- `mx.ipn.upiicsa.poo.calcHerencia.Calculator.ScientificCalculator`: Extiende `Calculator` para añadir funciones matemáticas avanzadas como potencias, raíces, trigonometría y factorial.
- `mx.ipn.upiicsa.poo.calcHerencia.UI.Menu`: Interfaz de usuario para el modo interactivo, donde se despliega un menú con las operaciones disponibles.
- `mx.ipn.upiicsa.poo.calcHerencia.UI.CommandControl`: Controlador para el modo de línea de comandos que interpreta los argumentos y ejecuta las operaciones correspondientes.

## Cómo Usar la Calculadora

### Modo Interactivo (Menú)

1. Ejecuta la clase `App` sin pasar argumentos. 
2. Selecciona `-m` cuando se te pida que elijas el modo.
3. El menú mostrará una lista de operaciones disponibles. Puedes ingresar el código de la operación deseada y luego el número o números requeridos.
4. Escribe `exit` para salir del menú.

### Modo Línea de Comandos

1. Ejecuta la clase `App` pasando `-p` seguido de los argumentos necesarios.
2. Estructura del comando:
   ```bash
   java App -p [operación] [número1] [número2]
   ```
   Ejemplo:
   ```bash
   java App -p -s 10 5  # Realiza la suma de 10 + 5
   ```

3. Para ver todas las operaciones disponibles, usa:
   ```bash
   java App -help
   ```

### Operaciones Disponibles

| Operación         | Código  | Argumentos |
|-------------------|---------|------------|
| Suma              | `-s`    | `a`, `b`   |
| Resta             | `-r`    | `a`, `b`   |
| Multiplicación    | `-m`    | `a`, `b`   |
| División          | `-d`    | `a`, `b`   |
| Porcentaje        | `-p`    | `a`, `b`   |
| Piso              | `-pi`   | `a`        |
| Techo             | `-t`    | `a`        |
| Redondeo          | `-re`   | `a`        |
| Potencia al Cuadrado | `-x2` | `a`        |
| Potencia al Cubo  | `-x3`   | `a`        |
| Potencia `n`      | `-xn`   | `a`, `n`   |
| Raíz Cuadrada     | `-x_2`  | `a`        |
| Raíz Cúbica       | `-x_3`  | `a`        |
| Raíz `n`          | `-x_n`  | `a`, `n`   |
| Seno              | `-sin`  | `a`        |
| Coseno            | `-cos`  | `a`        |
| Tangente          | `-tan`  | `a`        |
| Factorial         | `-fact` | `n` (entero no negativo) |

## Descripción de Clases

### `App.java`

Esta clase principal permite seleccionar el modo de uso de la calculadora. Se puede elegir entre el modo interactivo (`-m`) y el modo de línea de comandos (`-p`). Si no se pasa ningún argumento, se usa el modo de línea de comandos.

### `Calculator.java`

Define operaciones básicas de la calculadora:
- `suma(a, b)`: Devuelve la suma de `a` y `b`.
- `resta(a, b)`: Devuelve la resta de `b` de `a`.
- `multiplicacion(a, b)`: Devuelve la multiplicación de `a` y `b`.
- `division(a, b)`: Devuelve la división de `a` entre `b` (muestra un error si `b` es cero).
- `porcentaje(a, b)`: Calcula el `b%` de `a`.

### `ScientificCalculator.java`

Extiende la clase `Calculator` para ofrecer operaciones científicas avanzadas:
- `piso(a)`: Devuelve el valor de `a` redondeado hacia abajo.
- `techo(a)`: Devuelve el valor de `a` redondeado hacia arriba.
- `redondeo(a)`: Redondea `a` al entero más cercano.
- `potenciaCuadrado(a)`, `potenciaCubo(a)`, `potenciaN(a, n)`: Calcula la potencia de `a` al cuadrado, al cubo, o a la potencia `n`.
- `raizCuadrada(a)`, `raizCubica(a)`, `raizN(a, n)`: Calcula la raíz cuadrada, cúbica o `n`-ésima de `a`.
- `seno(a)`, `coseno(a)`, `tangente(a)`: Calcula el seno, coseno, o tangente de `a` en grados.
- `factorial(n)`: Calcula el factorial de un número entero no negativo `n`.

### `Menu.java`

Clase que implementa el modo interactivo de la calculadora. Utiliza un `Scanner` para leer las entradas del usuario y llama a los métodos correspondientes de `ScientificCalculator` para realizar las operaciones.

### `CommandControl.java`

Clase que implementa el modo de línea de comandos. Procesa los argumentos pasados, ejecuta la operación correspondiente en `ScientificCalculator` y muestra el resultado.

## Ejemplos de Uso

Ejemplo para realizar una suma en modo interactivo:
```bash
java App
Seleccione modo de uso:
-m -> menú
-p -> uso de argumentos
# Escribe -m y luego selecciona 's' para la suma
```

Ejemplo para realizar una resta en modo de línea de comandos:
```bash
java App -p -r 15 5
```

Este comando devolverá:
```
Resultado de la resta: 10.0
```

## Requisitos

- Java JDK 8 o superior

## Ejecución de Pruebas

Para ejecutar pruebas unitarias, asegúrate de tener [JUnit](https://junit.org/junit5/) configurado en tu proyecto.

## Licencia

Este proyecto está bajo la Licencia MIT. Puedes ver más detalles en el archivo `LICENSE`.
