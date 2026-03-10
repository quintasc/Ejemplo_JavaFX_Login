# Ejemplo_JavaFX_Login

Un proyecto educativo desarrollado para aprender a crear aplicaciones de escritorio modernas utilizando **JavaFX**, **Maven** y el patrón de diseño **MVC (Modelo-Vista-Controlador)**.

## Características

* **Interfaz Gráfica Moderna:** Diseñada visualmente con *Scene Builder* y separada de la lógica utilizando archivos `.fxml`.
* **Arquitectura MVC:** Código limpio y organizado separando las responsabilidades (Modelo, Vista y Controlador).
* **Validaciones Seguras:** Comprobación de campos vacíos y longitud de contraseñas simulando un entorno real.
* **Empaquetado Profesional:** Configurado para exportarse como un ejecutable independiente (`.exe`) sin depender de instalaciones previas de Java.

## Estructura del Proyecto

El código fuente está organizado de la siguiente manera para mantener el orden:

```text
src/main/
├── java/com/miempresa/login/
│   ├── Launcher.java          # Punto de entrada seguro (Evita errores de módulos JavaFX)
│   ├── App.java               # Configuración inicial de la aplicación JavaFX
│   ├── controller/            # Controladores (ej. LoginController.java)
│   └── model/                 # Lógica de negocio (ej. UserDataValidations.java)
└── resources/com/miempresa/login/
    └── Login.fxml             # Diseño de la interfaz (Vista)
```

## Cómo ejecutar el código (Para Desarrolladores)

Si quieres descargar el código fuente y modificarlo en tu propio equipo:

1. Clona este repositorio:
   `git clone https://github.com/tu-usuario/Ejemplo_JavaFX_Login.git`
2. Abre el proyecto en tu IDE favorito (recomendado NetBeans con soporte Maven).
3. **¡Importante!** Para evitar el error *"JavaFX runtime components are missing"*, ejecuta siempre el proyecto haciendo clic derecho sobre el archivo **`Launcher.java`** y seleccionando *Run File*.

## Descarga la Aplicación (Para Usuarios Finales)

Si solo quieres probar el programa sin instalar Java ni lidiar con el código fuente:

Ve a la sección de **[Releases](../../releases)** (en la columna derecha de GitHub) y descarga la última versión en `.zip`. Simplemente descomprímelo en tu ordenador y haz doble clic en el `.exe` para iniciar el sistema.
