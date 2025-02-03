# swapi-java

### Integracion con la api de Star Wars

Esta api es un client desarrollado en springboot para consumir la api de star wars, contiene los metodos para GetAll() y GetById() de las entidades People, Starship, Vehicle, Specie y Planet, posee un metodo de login con autenticacion y autorizacion con jwt, con un token valido por 1 hora, todo lo mencionado anteriormente esta desarrollado con spring security 6 y springboot 3

##Primeros pasos
para poder levantar el proyecto es necesario tener java 17-correto y maven 3.9, ademas de eso se debe tener configurado JAVA-HOME Y MAVEN-HOME en las variables del sistema

Para poder clonar el proyecto solo necesitar determinar en que path de archivos vas clonar el proyecto y ubicarte en tu consola en ese patch y ejecutar git clone https://github.com/crispuca/swapi-java.git 

Luego de haner hecho los pasos anteriores ya podes buildear el proyecto, con tu ide predilecto, en mi caso intellij IDEA, abrimos el proyecto clonado y ejecutamos mvn install, esto hara que se ejecute la instalacion de las dependencias, ya que es el manejador de dependencias que utiliza este proyecto

Antes de poder levantar el proyecto es necesario verificar que el sdk quen esta utilizando el IDE sea el de java 17, esto lo puede verificar en Project Structure > Project tiene que estar seteado java-17-correto

Otra cosa a tener en cuenta es un error que puede pasar al levantar la aplicacion es una notacion que utilice, en este caso "log" que el ide no lo reconoce, pero esto se solucionar dirigiendose a Settings > Build, Execution, Deployment > Compiler > Annotation Processors y pararte en el nombre dela proyecto que es swapi-java y tildar la opcion Obtain Processors from project classpath, se guarda y ya estaria configurado para arrancar la app

Cabe recordar que esta seteada por defecto que funcione en el puerto 8080, se puede setear en otro puerto si asi lo quisiera

Una vez definido eso se puede levantar la aplicacion

Para poder usar la aplicacion podemos usar postman

En este caso para iniciar la prueba de demas endpoints se debe hacer el login en la aplicacion, para ello se definio un login basico que incluyera un usuario en memoria, para poder hacer el login podemos importar el siguiente curl 

curl --location 'http://localhost:8080/auth/login' \
--header 'Content-Type: application/json' \
--data '{
    "username": "admin",
    "password": "password"
}'

el cual usa un metodo POST, el cual al enviarlo nos devolvera por respuesta un token, la respuesta vendra en este formato


{
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTczODQ2ODA4MSwiZXhwIjoxNzM4NDcxNjgxfQ.ebDNDoBFcnSkeAQnZIWs1pSo27WYbDaPdEYVBg8U6qI"
}

el token que nos de nos servirar para poder probar los demas endpoints, que spring security estaria protegiendo, es necesario agregar el header Authorization = Bearer <token> para probar los siguientes endpoints

A continuacion se dan ejemplos de cUrls para People, Specie, Starships, Vehicle y Film, todos los metodos son GET, reemplazar <token> con el token obtenido en el login

##Enpoints para People

GetAll

curl --location 'http://localhost:8080/swapi/people' \
--header 'Content-Type: application/json' \
--header 'Authorization: Bearer <token>'

GetById

curl --location 'http://localhost:8080/swapi/people/2' \
--header 'Content-Type: application/json' \
--header 'Authorization: Bearer <token>'

##Endpoints para Specie

GetAll

curl --location 'http://localhost:8080/swapi/species' \
--header 'Content-Type: application/json' \
--header 'Authorization: Bearer <token>'

GetById

curl --location 'http://localhost:8080/swapi/species/2' \
--header 'Content-Type: application/json' \
--header 'Authorization: Bearer <token>'

##Endpoint para Film

GetAll

curl --location 'http://localhost:8080/swapi/films' \
--header 'Content-Type: application/json' \
--header 'Authorization: Bearer <token>'

GetById

curl --location 'http://localhost:8080/swapi/films/2' \
--header 'Content-Type: application/json' \
--header 'Authorization: Bearer <token>'

##Endpoints para Starship 

GetAll

curl --location 'http://localhost:8080/swapi/starships' \
--header 'Content-Type: application/json' \
--header 'Authorization: Bearer <token>'

GetById

curl --location 'http://localhost:8080/swapi/starships/2' \
--header 'Content-Type: application/json' \
--header 'Authorization: Bearer <token>'


##Endpoints para Vehicle

GetAll

curl --location 'http://localhost:8080/swapi/vehicles' \
--header 'Content-Type: application/json' \
--header 'Authorization: Bearer <token>'

GetById

curl --location 'http://localhost:8080/swapi/vehicles/2' \
--header 'Content-Type: application/json' \
--header 'Authorization: Bearer <token>'

Con estos cUrls podemos consumir la api swapi 

Otra manera de consumir la aplicacion es pegandole a este dominio http://swapi-java-ab5008a6b3eb.herokuapp.com agregando las rutas necesarias, como probarlo de manera local, osea en principio obteniendo el token y luego agregandolo en el header

Este es el dominio de la aplicacion levantada en Heroku



Aquí tienes una versión mejorada de tu README con algunas correcciones y sugerencias de formato y claridad:

---

# swapi-java

### Integración con la API de Star Wars

Esta API es un cliente desarrollado en Spring Boot para consumir la API pública de Star Wars. Implementa métodos para obtener todas las entidades (GetAll) y obtener entidades por ID (GetById) de **People**, **Starships**, **Vehicles**, **Species** y **Planets**. Además, incluye un sistema de autenticación y autorización mediante **JWT** con un token válido por 1 hora. Todo esto está implementado con **Spring Security 6** y **Spring Boot 3**.

## Primeros pasos

Para levantar este proyecto, es necesario tener instalados **Java 17 (Corretto)** y **Maven 3.9**. Además, debes configurar las variables del sistema **JAVA_HOME** y **MAVEN_HOME**.

### Clonar el proyecto

1. Dirígete al directorio en el que deseas clonar el proyecto.
2. Ejecuta el siguiente comando en la terminal para clonar el repositorio:

   ```bash
   git clone https://github.com/crispuca/swapi-java.git
   ```

### Construir el proyecto

1. Una vez clonado el proyecto, abre el directorio en tu IDE favorito (se recomienda **IntelliJ IDEA**).
2. Ejecuta el siguiente comando en la terminal del IDE para instalar las dependencias:

   ```bash
   mvn install
   ```

   Esto instalará todas las dependencias definidas en el archivo `pom.xml`.

### Verificar la configuración de Java

Antes de levantar la aplicación, asegúrate de que tu IDE esté configurado para usar **Java 17**. En IntelliJ IDEA, puedes verificarlo en **Project Structure > Project**, y asegurarte de que el **SDK** esté configurado como **Java 17**.

### Error común en la compilación

Si encuentras un error relacionado con la anotación `log`, dirígete a **Settings > Build, Execution, Deployment > Compiler > Annotation Processors**. Selecciona el nombre de tu proyecto (`swapi-java`) y marca la opción **Obtain processors from project classpath**. Guarda la configuración y vuelve a intentar levantar la aplicación.

### Configuración del puerto

Por defecto, la aplicación está configurada para ejecutarse en el puerto `8080`. Puedes cambiar este puerto en el archivo `application.properties` si lo necesitas.

### Levantar la aplicación

Una vez completados los pasos anteriores, puedes levantar la aplicación ejecutando:

```bash
mvn spring-boot:run
```

## Uso de la aplicación

Puedes probar la aplicación usando **Postman** o **cURL**. Primero, debes autenticarte y obtener un **token JWT** para acceder a los demás endpoints.

### Autenticación

Para iniciar sesión, realiza una solicitud `POST` al endpoint de login con las credenciales predefinidas:

```bash
curl --location 'http://localhost:8080/auth/login' \
--header 'Content-Type: application/json' \
--data '{
    "username": "admin",
    "password": "password"
}'
```

La respuesta será un **token JWT** similar a este:

```json
{
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTczODQ2ODA4MSwiZXhwIjoxNzM4NDcxNjgxfQ.ebDNDoBFcnSkeAQnZIWs1pSo27WYbDaPdEYVBg8U6qI"
}
```

Este token se usará para autenticar las solicitudes a los demás endpoints.

### Endpoints protegidos con JWT

Para realizar pruebas en los endpoints, debes agregar el **header** `Authorization: Bearer <token>` con el token obtenido en el login.

#### Endpoints para **People**

- **GetAll**:

  ```bash
  curl --location 'http://localhost:8080/swapi/people' \
  --header 'Content-Type: application/json' \
  --header 'Authorization: Bearer <token>'
  ```

- **GetById**:

  ```bash
  curl --location 'http://localhost:8080/swapi/people/2' \
  --header 'Content-Type: application/json' \
  --header 'Authorization: Bearer <token>'
  ```

#### Endpoints para **Species**

- **GetAll**:

  ```bash
  curl --location 'http://localhost:8080/swapi/species' \
  --header 'Content-Type: application/json' \
  --header 'Authorization: Bearer <token>'
  ```

- **GetById**:

  ```bash
  curl --location 'http://localhost:8080/swapi/species/2' \
  --header 'Content-Type: application/json' \
  --header 'Authorization: Bearer <token>'
  ```

#### Endpoint para **Film**

- **GetAll**:

  ```bash
  curl --location 'http://localhost:8080/swapi/films' \
  --header 'Content-Type: application/json' \
  --header 'Authorization: Bearer <token>'
  ```

- **GetById**:

  ```bash
  curl --location 'http://localhost:8080/swapi/films/2' \
  --header 'Content-Type: application/json' \
  --header 'Authorization: Bearer <token>'
  ```

#### Endpoints para **Starship**

- **GetAll**:

  ```bash
  curl --location 'http://localhost:8080/swapi/starships' \
  --header 'Content-Type: application/json' \
  --header 'Authorization: Bearer <token>'
  ```

- **GetById**:

  ```bash
  curl --location 'http://localhost:8080/swapi/starships/2' \
  --header 'Content-Type: application/json' \
  --header 'Authorization: Bearer <token>'
  ```

#### Endpoints para **Vehicle**

- **GetAll**:

  ```bash
  curl --location 'http://localhost:8080/swapi/vehicles' \
  --header 'Content-Type: application/json' \
  --header 'Authorization: Bearer <token>'
  ```

- **GetById**:

  ```bash
  curl --location 'http://localhost:8080/swapi/vehicles/2' \
  --header 'Content-Type: application/json' \
  --header 'Authorization: Bearer <token>'
  ```

### Heroku

Puedes probar la aplicación en **Heroku** a través del siguiente dominio:

[http://swapi-java-ab5008a6b3eb.herokuapp.com](http://swapi-java-ab5008a6b3eb.herokuapp.com)

Agrega las rutas necesarias a este dominio, igual que lo harías en la versión local. Recuerda obtener el token primero, y luego usarlo en el header `Authorization: Bearer <token>` para acceder a los endpoints protegidos.

---

### Mejoras y sugerencias

- **Documentación**: Asegúrate de incluir ejemplos de todos los endpoints principales.
- **Pruebas**: Incluye más detalles sobre cómo ejecutar las pruebas de integración y cómo medir la cobertura de código.
- **Manejo de errores**: Explica cómo se gestionan los errores en la API (por ejemplo, respuestas 404 o 401).

Con estos cambios, tu README será más claro y completo para los desarrolladores que utilicen o colaboren en tu proyecto.












