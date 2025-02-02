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



















