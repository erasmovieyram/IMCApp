1. Propósito de la Aplicación
La aplicación es un sistema web diseñado para:

Registrar usuarios : Los usuarios pueden registrarse proporcionando sus datos personales (nombre, edad, sexo, estatura, peso, nombre de usuario y contraseña).
Iniciar sesión : Los usuarios pueden autenticarse con su nombre de usuario y contraseña.
Calcular el IMC (Índice de Masa Corporal) : Los usuarios pueden ingresar su masa corporal para calcular su IMC, el cual se guarda en la base de datos.
Ver el historial de IMC : Los usuarios pueden consultar su historial de mediciones de IMC a través de una página dedicada.
2. Arquitectura y Patrón MVC
La aplicación sigue el patrón MVC (Modelo-Vista-Controlador) , que separa claramente las responsabilidades del sistema:

a. Modelo
El modelo representa los datos y la lógica de negocio. Las clases principales son:

Usuario :
Representa a un usuario registrado.
Contiene atributos como id, nombreCompleto, edad, sexo, estatura, peso, nombreUsuario y contrasena.
IMC :
Representa una medición de Índice de Masa Corporal.
Contiene atributos como id, usuarioId, imc y fecha.
b. Vista
Las vistas son las interfaces gráficas con las que interactúan los usuarios. Se implementan como archivos JSP:

registro.jsp : Formulario para registrar nuevos usuarios.
login.jsp : Formulario para iniciar sesión.
calculo.jsp : Formulario para ingresar la masa corporal y calcular el IMC.
resultado.jsp : Muestra el resultado del cálculo del IMC.
historial.jsp : Muestra el historial de mediciones de IMC del usuario.
c. Controlador
Los controladores manejan las solicitudes HTTP y coordinan la interacción entre el modelo y las vistas. Se implementan como Servlets:

RegistroUsuarioServlet :
Procesa el formulario de registro.
Valida los datos y guarda al usuario en la base de datos usando UsuarioDAO.
LoginServlet :
Procesa el formulario de inicio de sesión.
Autentica al usuario usando UsuarioDAO y crea una sesión si las credenciales son válidas.
CalcularIMCServlet :
Calcula el IMC a partir de la masa corporal ingresada por el usuario.
Guarda la medición en la base de datos usando IMCDAO.
HistorialIMCServlet :
Consume un servicio REST para recuperar el historial de IMC del usuario.
Pasa los datos a la vista (historial.jsp) para mostrarlos.
3. Servicio REST
El servicio REST expone los datos del historial de IMC a través de un endpoint HTTP. Su funcionalidad incluye:

Endpoint : /rest/api/imc?usuario_id=X
Método : GET
Funcionalidad : Devuelve el historial de IMC de un usuario en formato JSON.
4. Base de Datos
La base de datos almacena los datos de los usuarios y sus mediciones de IMC. La estructura incluye:

Tabla Usuario :
id: Identificador único del usuario.
nombre_completo, edad, sexo, estatura, peso, nombre_usuario, contrasena: Datos del usuario.
Tabla IMC :
id: Identificador único de la medición.
usuario_id: Clave foránea que referencia al usuario.
imc: Valor del IMC calculado.
fecha: Fecha de la medición.
5. DAOs (Data Access Objects)
Los DAOs encapsulan la lógica de acceso a la base de datos:

UsuarioDAO :
Métodos: registrar(Usuario usuario) y autenticar(String nombreUsuario, String contrasena).
IMCDAO :
Métodos: guardar(IMC imc) y obtenerHistorial(int usuarioId).
6. Dependencias
Para desarrollar la aplicación, se utilizaron las siguientes dependencias:

a. Bibliotecas Principales
Jakarta EE :
jakarta.servlet-api: Para trabajar con Servlets y JSP.
jakarta.servlet.jsp.jstl-api y jakarta.servlet.jsp.jstl: Para usar etiquetas JSTL en las vistas.
MySQL Connector :
mysql-connector-j: Para conectarse a la base de datos MySQL.
GSON :
com.google.code.gson: Para manejar JSON en el servicio REST.
b. Configuración en Maven
Si usas Maven, estas dependencias están declaradas en el archivo pom.xml:

<dependencies>
    <!-- Jakarta Servlet API -->
    <dependency>
        <groupId>jakarta.servlet</groupId>
        <artifactId>jakarta.servlet-api</artifactId>
        <version>6.0.0</version>
        <scope>provided</scope>
    </dependency>

    <!-- Jakarta JSP JSTL -->
    <dependency>
        <groupId>jakarta.servlet.jsp.jstl</groupId>
        <artifactId>jakarta.servlet.jsp.jstl-api</artifactId>
        <version>3.0.0</version>
    </dependency>
    <dependency>
        <groupId>org.glassfish.web</groupId>
        <artifactId>jakarta.servlet.jsp.jstl</artifactId>
        <version>3.0.0</version>
    </dependency>

    <!-- MySQL Connector -->
    <dependency>
        <groupId>com.mysql</groupId>
        <artifactId>mysql-connector-j</artifactId>
        <version>8.0.33</version>
    </dependency>

    <!-- GSON -->
    <dependency>
        <groupId>com.google.code.gson</groupId>
        <artifactId>gson</artifactId>
        <version>2.10.1</version>
    </dependency>
</dependencies>

7. Funcionalidad General
La aplicación funciona de la siguiente manera:

Registro de Usuarios :
El usuario completa el formulario en registro.jsp.
El RegistroUsuarioServlet procesa los datos y guarda al usuario en la base de datos usando UsuarioDAO.
Inicio de Sesión :
El usuario ingresa sus credenciales en login.jsp.
El LoginServlet verifica las credenciales usando UsuarioDAO y crea una sesión si son válidas.
Cálculo del IMC :
El usuario ingresa su masa corporal en calculo.jsp.
El CalcularIMCServlet calcula el IMC, lo guarda en la base de datos usando IMCDAO y muestra el resultado en resultado.jsp.
Historial de IMC :
El HistorialIMCServlet consume el servicio REST para recuperar el historial de IMC del usuario.
Los datos se muestran en historial.jsp usando etiquetas JSTL.
8. Resumen Final
La aplicación está diseñada siguiendo el patrón MVC para separar claramente las responsabilidades de modelo, vista y controlador. Utiliza:

Clases del Modelo : Usuario e IMC.
Vistas : Archivos JSP para las interfaces de usuario.
Controladores : Servlets para manejar las solicitudes HTTP.
Base de Datos : Tablas Usuario e IMC en MySQL.
Servicio REST : Para exponer el historial de IMC.
Dependencias : Jakarta EE, MySQL Connector y GSON.
Con esta estructura, la aplicación es modular, mantenible y escalable.
