
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











