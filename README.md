# Conversor de Monedas

Este es un proyecto en Java que implementa un conversor de monedas utilizando una API de tasas de cambio. El conversor permite convertir entre diferentes monedas y ofrece una interfaz de usuario de consola con varias opciones predefinidas y la posibilidad de ingresar códigos de monedas personalizados.

## Tabla de Contenidos

- [Instalación](#instalación)
- [Uso](#uso)
- [Estructura del Proyecto](#estructura-del-proyecto)
- [Flujo del Programa](#flujo-del-programa)
- [Funcionalidades](#funcionalidades)
- [Extras](#extras)
- [Tecnologías Utilizadas](#tecnologías-utilizadas)
- [Contribuciones](#contribuciones)
- [Licencia](#licencia)

## Instalación

Sigue los pasos a continuación para configurar y ejecutar el proyecto en tu entorno local:

1. **Clonar el repositorio**:
   ```bash
   git clone https://github.com/IvanCodeRunner/ConversorDeMonedas.git
   ```

2. **Abrir el proyecto en IntelliJ IDEA o cualquier otro IDE compatible con Java.**

3. **Instalar dependencias:**
   - Asegúrate de tener instalado Java JDK (versión 11 o superior).
   - Añadir la biblioteca Gson para procesar datos en formato JSON:
     ```xml
     <!-- Si estás usando Maven, añádelo a tu archivo pom.xml -->
     <dependency>
       <groupId>com.google.code.gson</groupId>
       <artifactId>gson</artifactId>
       <version>2.10.1</version>
     </dependency>
     ```
   - Compilar el proyecto** y ejecutarlo desde la clase principal `PrincipalConversorMonedasApp`.

## Uso

Una vez que hayas instalado el proyecto, puedes ejecutarlo para comenzar a utilizar el conversor de monedas. 

1. **Ejecutar el programa**:
   - Inicia la clase `PrincipalConversorMonedasApp` desde tu IDE.

2. **Interacción con el menú**:
   - El programa mostrará un menú principal con varias opciones de conversión de monedas.
   - Selecciona una opción ingresando el número correspondiente y presiona **Enter**.
   - Sigue las instrucciones en pantalla para completar la conversión.

## Ejemplo de Uso

Supongamos que deseas convertir 100 dólares estadounidenses (USD) a pesos argentinos (ARS):

1. **Selecciona la opción 1** en el menú:
   ```
   1) Dólar => Peso argentino
   ```

2. **Ingresa la cantidad a convertir** cuando se te solicite:
   ```
   Ingrese el monto a convertir: 100
   ```

3. **El programa mostrará el resultado** de la conversión:
   ```
   El valor convertido es: 35000.00 ARS
   ```

Puedes seguir este procedimiento para otras conversiones disponibles en el menú.

## Estructura del Proyecto

El proyecto tiene la siguiente estructura de carpetas:

```
ConversorDeMonedas/
├── .idea/
├── src/
│   ├── com/
│   │   └── conversor/
│   │       └── monedas/
│   │           ├── api/
│   │           │   ├── Currency.java
│   │           │   ├── CurrencyConverter.java
│   │           │   ├── ExchangeRateClient.java
│   │           │   └── ExchangeRateResponse.java
│   │           └── ui/
│   │               └── Menu.java
│   └── PrincipalConversorMonedasApp.java
├── .gitignore
└── ConversionDeMonedas.iml
```

## Descripción de Archivos

- **Currency.java**: Clase que representa una moneda con su código, nombre y país.
- **CurrencyConverter.java**: Clase que maneja la lógica de conversión de monedas utilizando las tasas de cambio obtenidas.
- **ExchangeRateClient.java**: Clase responsable de realizar solicitudes a la API de tasas de cambio.
- **ExchangeRateResponse.java**: Clase que representa la respuesta de la API con las tasas de cambio.
- **Menu.java**: Clase que maneja la interacción con el usuario y el menú del programa.
- **PrincipalConversorMonedasApp.java**: Clase principal que inicia el programa.

## Flujo del Programa

1. Al ejecutar el programa, se inicia la clase `PrincipalConversorMonedasApp`.
2. Se muestra el menú principal al usuario.
3. El usuario selecciona una opción de conversión.
4. Se procesan las solicitudes y se muestran los resultados en pantalla.
5. El usuario puede realizar múltiples conversiones hasta decidir salir del programa.

## Funcionalidades

- Conversión entre varias monedas (USD, ARS, BRL, COP, etc.).
- Opción para ingresar códigos de monedas manualmente.
- Visualización de las monedas disponibles.
- Manejo de errores durante la conversión.

## Extras

- Historial de conversiones (pendiente de implementación).
- Soporte para más monedas en futuras versiones.

## Tecnologías Utilizadas

- Java (versión 11 o superior)
- API de tasas de cambio (para obtener las tasas de conversión)
- Gson (para procesar datos en formato JSON)

## Contribuciones

Las contribuciones son bienvenidas. Si deseas colaborar, por favor sigue estos pasos:

1. Haz un fork del repositorio.
2. Crea una nueva rama (`git checkout -b feature/nueva-funcionalidad`).
3. Realiza tus cambios y confirma (`git commit -m 'Añadir nueva funcionalidad'`).
4. Haz un push a la rama (`git push origin feature/nueva-funcionalidad`).
5. Abre un Pull Request.

## Licencia

Este proyecto está bajo la Licencia MIT. Consulta el archivo [LICENSE](LICENSE) para más detalles.

