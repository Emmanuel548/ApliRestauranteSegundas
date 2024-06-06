# Aplicación de Gestión para Restaurantes

## Patrón MVC Utilizado

### Modelo
**Descripción:** El componente de Modelo se encarga de gestionar la lógica de negocio y los datos de la aplicación. Incluye las clases que representan los objetos del dominio, como usuarios, productos y órdenes, así como las operaciones CRUD asociadas.

**Implementación:** Creamos clases como `Usuario`, `Producto`, `Orden` que contienen métodos específicos para cada entidad. Además, incluimos clases de consulta que encapsulan la lógica de negocio y las interacciones con la base de datos.

### Vista
**Descripción:** La Vista es responsable de la presentación de la interfaz de usuario (UI). Este componente muestra los datos al usuario y captura sus interacciones.

**Implementación:** Utilizamos JavaFX para construir la interfaz gráfica de usuario. Creamos diversas ventanas y paneles para diferentes funcionalidades, como formularios de registro, tablas de visualización de productos, y un dashboard con gráficos y reportes.

### Controlador
**Descripción:** El Controlador maneja la comunicación entre el Modelo y la Vista. Recibe entradas del usuario a través de la Vista, las procesa (utilizando la lógica del Modelo), y actualiza la Vista en consecuencia.

**Implementación:** Desarrollamos clases controladoras como `CtrlUsuario`, `CtrlProducto` y `CtrlOrden`, que contienen métodos para actualizar los datos del Modelo y la Vista dependiendo de los eventos de la UI que se manejen.

## Lógica de Negocio
El proyecto implementa lógica para calcular subtotales y totales, gestionar inventarios, y generar reportes de ventas. También incluye validaciones de integridad de datos y restricciones de negocio, como la verificación de nombres de usuario y contraseñas.

## Interfaz de Usuario
La interfaz de usuario fue desarrollada utilizando JavaFX, proporcionando una experiencia visual interactiva. Las principales vistas de la aplicación incluyen:
- **Pantalla de Inicio de Sesión:** Permite a los usuarios autenticarse.
- **Panel de Administración:** Ofrece un menú principal para acceder a las diferentes configuraciones de la aplicación.
- **Formularios CRUD:** Formularios específicos para la creación, actualización y eliminación de usuarios y productos.
- **Tablas de contenido:** Tablas que muestran el contenido de la aplicación, como son usuarios, productos, órdenes y detalles de orden.
- **Dashboard:** Muestra gráficos y estadísticas sobre los informes de las ventas que se realizan en la aplicación.

## Conexión a la Base de Datos
Para la gestión de la persistencia de datos, utilizamos una base de datos relacional (MySQL Workbench). La conexión a la base de datos y las operaciones CRUD fueron manejadas a través de una capa de acceso a datos (DAO):
- **Conexión a la Base de Datos:** Implementamos una clase `CConexion` que establece y gestiona la conexión con la base de datos.
- **Operaciones CRUD:** Creamos clases DAO específicas que contienen métodos para realizar operaciones de inserción, actualización, eliminación y consulta sobre la base de datos. Utilizamos consultas SQL parametrizadas para prevenir inyecciones SQL y asegurar la integridad de los datos.

## Instrucciones para Compilar y Ejecutar

### Requisitos
- Java JDK 11 o superior.
- MySQL Workbench.
- JavaFX SDK.

### Compilación
1. Asegúrate de tener instalado Java JDK y JavaFX SDK en tu sistema.
2. Configura la variable de entorno `PATH_TO_FX` para apuntar al directorio `lib` del JavaFX SDK.
3. Compila el código fuente utilizando el siguiente comando:
   ```bash
   javac --module-path $PATH_TO_FX --add-modules javafx.controls,javafx.fxml -d out src/*.java
   ```

### Ejecución
1. Para ejecutar la aplicación, utiliza el siguiente comando:
   ```bash
   java --module-path $PATH_TO_FX --add-modules javafx.controls,javafx.fxml -cp out Main
   ```

## Ejemplos de Uso
- **Iniciar Sesión:** Abre la aplicación y utiliza tus credenciales para acceder al sistema.


- **Agregar un Producto:** Navega al panel de administración, selecciona la pestaña de productos y utiliza el formulario de agregar producto.
- **Generar Reporte de Ventas:** Accede al dashboard y selecciona la opción para generar reportes desde la interfaz.

---

## Dependencias

La aplicación requiere las siguientes bibliotecas para su compilación y ejecución. Asegúrate de tener estas librerías en tu classpath o instalarlas correctamente antes de proceder:

- **MySQL Connector/J**: `mysql-connector-java-8.0.40.jar` - Necesario para conectar con la base de datos MySQL.
- **iText PDF**: `itextpdf-5.5.12.jar` - Utilizado para generar reportes en formato PDF.
- **JCommon**: `jcommon-1.0.23.jar` - Librería de utilidades comunes para Java, requerida por JFreeChart.
- **JFreeChart**: `jfreechart-1.0.19.jar` - Utilizado para crear gráficos y reportes visuales.
- **JavaX Activation**: `javax.activation-1.1.0.jar` - Proporciona clases para la activación de datos cuando se implementan funcionalidades de email.
- **JavaX Mail**: `mail.jar` - Necesario para enviar correos electrónicos desde la aplicación.
- **JavaX EJB and JavaX Inject**: Utilizados para la inyección de dependencias y la gestión de beans empresariales.
- **JavaX Faces API**: `javax.faces-api-2.0.jar` - Utilizado en aplicaciones Java para construir interfaces de usuario en Java EE.

### Instalación de Dependencias

Para instalar estas dependencias, puedes utilizar un gestor de dependencias como Maven o Gradle, o descargarlas manualmente de sus respectivos sitios web y agregarlas al classpath de tu proyecto. Aquí te mostramos cómo podrías agregarlas utilizando Maven añadiendo las dependencias en tu archivo `pom.xml`:

```xml
<dependencies>
    <!-- MySQL Connector/J -->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>8.0.40</version>
    </dependency>
    <!-- iText PDF -->
    <dependency>
        <groupId>com.itextpdf</groupId>
        <artifactId>itextpdf</artifactId>
        <version>5.5.12</version>
    </dependency>
    <!-- JCommon -->
    <dependency>
        <groupId>org.jfree</groupId>
        <artifactId>jcommon</artifactId>
        <version>1.0.23</version>
    </dependency>
    <!-- JFreeChart -->
    <dependency>
        <groupId>org.jfree</groupId>
        <artifactId>jfreechart</artifactId>
        <version>1.0.19</version>
    </dependency>
    <!-- JavaX Activation -->
    <dependency>
        <groupId>javax.activation</groupId>
        <artifactId>activation</artifactId>
        <version>1.1.0</version>
    </dependency>
    <!-- JavaX Mail -->
    <dependency>
        <groupId>javax.mail</groupId>
        <artifactId>mail</artifactId>
        <version>1.4.7</version>
    </dependency>
    <!-- Additional dependencies for JavaX EJB and Faces API -->
</dependencies>
```

---
