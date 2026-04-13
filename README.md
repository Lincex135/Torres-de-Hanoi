# 🏯 Torres de Hanoi

Proyecto de Java — Juego interactivo de las Torres de Hanoi desarrollado por [Ximena López](https://github.com/Lincex135)

## 🧾 Descripción

**Torres de Hanoi** es una implementación en Java del clásico puzzle matemático jugable desde la **consola**. El jugador puede elegir el número de discos con el que quiere jugar y moverlos manualmente entre los tres postes, respetando las reglas del juego. El proyecto hace uso de **herencia**, **polimorfismo**, **pilas con ArrayList** y **menús interactivos por consola**, siendo un ejercicio completo de Programación Orientada a Objetos en Java.

Una particularidad del juego es que los discos alternan entre dos tipos según su posición: los discos de posición impar se representan con `o` y los de posición par con `@` *(discos de piedra)*, dándole un toque visual diferenciador a la partida.

## 👩‍💻 Autora

- [Ximena López](https://github.com/Lincex135)

## 🎯 Objetivos del Proyecto

- Implementar el puzzle de las Torres de Hanoi de forma **interactiva** y **jugable** desde consola.
- Aplicar **herencia** y **polimorfismo** mediante las clases `Disco` y `DiscoDePiedra`.
- Gestionar la lógica de los postes con **ArrayList** como estructura de datos tipo pila.
- Controlar los errores de entrada del usuario con **mensajes de error claros**.
- Practicar el diseño de clases en **Programación Orientada a Objetos**.

## 🕹️ Cómo se juega

Al iniciar el programa, el jugador elige cuántos discos quiere usar. Todos los discos comienzan apilados en el **Poste 1** ordenados de mayor a menor. El objetivo es moverlos todos al **Poste 3** respetando estas reglas:

| Regla | Descripción |
|-------|-------------|
| 1️⃣ | Solo se puede mover **un disco** a la vez. |
| 2️⃣ | Solo se puede mover el disco que esté **en la cima** de un poste. |
| 3️⃣ | No se puede colocar un disco **más grande sobre uno más pequeño**. |

El número mínimo de movimientos para resolver el puzzle con **N discos** es **2ⁿ − 1**.

## 🏗️ Estructura del Proyecto

```
Torres-de-Hanoi/
└── src/
    ├── Main.java           # Punto de entrada. Menú principal e interacción con el usuario
    ├── Partida.java        # Lógica del juego: postes, movimientos y condición de victoria
    ├── Poste.java          # Gestión de la pila de discos de cada poste
    ├── Disco.java          # Clase base del disco (se dibuja con 'o')
    └── DiscoDePiedra.java  # Subclase de Disco (se dibuja con '@')
```

## 🧩 Diagrama de Clases

| Clase | Tipo | Descripción |
|-------|------|-------------|
| `Main` | Principal | Menú principal, recoge input del usuario y gestiona el flujo del programa |
| `Partida` | Lógica | Contiene los 3 postes, valida y ejecuta movimientos, detecta si la partida ha terminado |
| `Poste` | Estructura | Almacena los discos como una pila (`ArrayList<Disco>`), permite insertar, extraer y dibujar |
| `Disco` | Entidad base | Representa un disco con su diámetro; se dibuja con `o` |
| `DiscoDePiedra` | Hereda de `Disco` | Disco especial que se dibuja con `@` (los discos de posición par) |

## ⚠️ Validaciones y Mensajes de Error

El juego gestiona automáticamente los siguientes casos:

| Código | Situación |
|--------|-----------|
| ✅ `0` | Movimiento realizado con éxito |
| ❌ `1` | Número de poste no válido (debe ser 1, 2 o 3) |
| ❌ `2` | El poste de origen está vacío |
| ❌ `3` | El disco a mover es más grande que el disco cima del poste destino |

Además, al crear un disco con diámetro inválido:
- Si el diámetro es **menor que 3**, se le asigna automáticamente el valor `3`.
- Si el diámetro es **par**, se redondea al siguiente número impar.

## 🛠️ Compilación y Ejecución

<details>
<summary>🔧 Instrucciones</summary>

1. Clonar el repositorio:
   ```bash
   git clone https://github.com/Lincex135/Torres-de-Hanoi.git
   ```
2. Acceder al directorio del código fuente:
   ```bash
   cd Torres-de-Hanoi/src
   ```
3. Compilar todas las clases:
   ```bash
   javac *.java
   ```
4. Ejecutar el programa:
   ```bash
   java Main
   ```

</details>

## 🧰 Tecnologías Utilizadas

- **Lenguaje**: Java
- **Paradigma**: Programación Orientada a Objetos
- **Conceptos clave**: Herencia, Polimorfismo, ArrayList como pila
- **Interfaz**: Consola (Scanner)
- **Herramienta**: Visual Studio Code / IntelliJ IDEA

## 📚 Bibliografía

- [☕ Documentación oficial de Java](https://docs.oracle.com/en/java/)
- [🧱 ArrayList en Java — Documentación Oracle](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html)
- [🗼 Torres de Hanoi — Wikipedia](https://es.wikipedia.org/wiki/Torres_de_Han%C3%B3i)