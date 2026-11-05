# ICC-Practica02-ECervantes

**Introducción a Ciencias de la Computación — Práctica 2: Simulación de inversión**

**Alumno:** Cervantes Fabela Edgar Leonardo


## Descripción

En una institución bancaria se requiere manejar fechas para calcular, por ejemplo, la duración de una inversión. Esta práctica implementa:

- **`Fecha`**: una clase para crear y manipular fechas en formato `dd/mes/aaaa`, donde el mes puede darse como número o como nombre en español.
- **`TiempoDeInversion`**: un programa interactivo que, con la clase `Fecha`, calcula los días de una inversión y su rendimiento al 12 %.

**Objetivo:** ejercitar el uso de instrucciones condicionales y bucles, así como la creación y el uso de objetos de clases existentes.

## Estructura del repositorio

```
ICC-Practica02-ECervantes/
├── README.md
└── ECervantes/
    └── practica02/
        └── src/
            └── icc/
                ├── Fecha.java
                └── TiempoDeInversion.java
```

## Requisitos

- Java Development Kit (JDK) 8 o superior.

## Compilación y ejecución

Desde la raíz del repositorio:

```bash
cd ECervantes/practica02/src/icc
javac Fecha.java TiempoDeInversion.java
java TiempoDeInversion
```

## Clase `Fecha`

Atributos privados: `day`, `month` y `year`. Los métodos `set` validan los valores recibidos; si no son válidos, muestran un mensaje en pantalla.

### Constructores

| Constructor | Descripción |
|---|---|
| `Fecha()` | Construye la fecha por omisión `01/01/2026`. |
| `Fecha(int d, int m, int y)` | Construye una fecha con día, mes (número) y año. |
| `Fecha(int d, String m, int y)` | Construye una fecha con día, mes (nombre) y año. |

### Métodos

| Método | Descripción |
|---|---|
| `getDay()`, `getMonth()`, `getYear()` | Obtienen los campos de la fecha. |
| `setDay(int)`, `setMonth(int)`, `setYear(int)` | Asignan los campos, validando el valor. |
| `difference(Fecha x)` | Diferencia en días entre la fecha actual y `x`. |
| `modDate(int d)` | Devuelve una nueva `Fecha` sumando o restando `d` días. |
| `dateFromDays(int dd, int yy)` | Devuelve la `Fecha` correspondiente a `dd` días transcurridos del año `yy`. |
| `equal(Fecha x)` | Indica si dos fechas son iguales. |
| `monthToNum(String)` | Convierte el nombre de un mes en su número (no distingue mayúsculas ni espacios sobrantes). |
| `numToMonth(int)` | Convierte el número de un mes en su nombre. |
| `daysPassed()` | Días transcurridos del año hasta la fecha. |
| `format()` | Representa la fecha como `dd/mes/aaaa`, por ejemplo `05/noviembre/2026`. |

Métodos privados de apoyo: `daysInMonth(int)` (días de un mes, considerando años bisiestos) e `isLeap(int)` (indica si un año es bisiesto).

## Programa `TiempoDeInversion`

Flujo del programa:

1. Da la bienvenida y solicita el nombre del inversionista.
2. Saluda al inversionista y solicita el monto a invertir.
3. Solicita la fecha de inicio de la inversión (día, nombre del mes y año).
4. Solicita la fecha de fin de la inversión (día, nombre del mes y año).
5. Muestra los días de inversión y el rendimiento generado.
6. Pregunta si desea realizar otra simulación (`s`/`n`). Si responde `s`, regresa al paso 2; en otro caso, termina.

### Cálculo del rendimiento

El rendimiento se calcula con una tasa anual del 12 %, sobre los días de inversión:

```
rendimiento = monto × (0.12 / 365) × díasDeInversión
```
### Ejemplo de uso
 
Dos simulaciones seguidas (lo que escribe el usuario aparece después de cada pregunta, en la misma línea de entrada):
 
```
Sea bienvenid@ al simulador de inversión
¿Cuál es su nombre?
Edgar
Hola Edgar. Dime, ¿cuál es el monto que deseas invertir?
10000
Ingresa la fecha del inicio de inversión:
Día:
15
Nombre del mes:
enero
Año:
2026
Ingresa la fecha del fin de inversión:
Día:
15
Nombre del mes:
julio
Año:
2026
Días de inversión: 181
Rendimiento generado: 595.068493150685
¿Desea realizar otra simulación? (s/n)
s
Hola Edgar. Dime, ¿cuál es el monto que deseas invertir?
5000
Ingresa la fecha del inicio de inversión:
Día:
1
Nombre del mes:
marzo
Año:
2026
Ingresa la fecha del fin de inversión:
Día:
1
Nombre del mes:
marzo
Año:
2027
Días de inversión: 365
Rendimiento generado: 600.0
¿Desea realizar otra simulación? (s/n)
n
```
 
### Notas de uso

- El mes se escribe con su nombre en español (`enero`, `febrero`, ..., `diciembre`).
- El monto se captura como número decimal, por ejemplo `10000` o `2500.50`.
- La fecha de fin debe ser posterior a la fecha de inicio.

## Documentación

Todo el código está documentado con formato Javadoc. Para generar la documentación HTML:

```bash
cd ECervantes/practica02/src/icc
javadoc -private -d docs Fecha.java TiempoDeInversion.java
```

El resultado queda en la carpeta `docs/`.
