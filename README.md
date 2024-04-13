# lab7

Luego de clonar la aplicacion se debe agregar el plugin Lombok.

![image](https://github.com/Mauricio-A-Monroy/lab7/assets/111905757/c6741201-3665-489f-be54-407ce089be16)

Abrimos Docker y luego ejecutamos el código `docker run -p 3306:3306 --name some-mysql -e MYSQL_ROOT_PASSWORD=my-secret-pw -d mysql:latest`, despues veremos el contenedor en Docker.

![image](https://github.com/Mauricio-A-Monroy/lab7/assets/111905757/b13e9021-a5cd-422a-8346-92c6c88bcfed)

Luego abrimos un cliente hacia la base de datos usando DBeaver.

![image](https://github.com/Mauricio-A-Monroy/lab7/assets/111905757/1c851ede-90a9-4d4b-91e2-a1873a086442)

Ahora, vamos a al archivo applicatio.propertie y en la linea `spring.datasource.url=${MYSQLCONNSTR_MyDatabase:jdbc:mysql://localhost:3306/cvds?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&user=root&password=my-secret-pw}
` cambiamos el "cvds" por "sys" (esto porque no existe una base de datos llamada cvds) y deberia ejecutar la aplicación.

![image](https://github.com/Mauricio-A-Monroy/lab7/assets/111905757/38f25f2d-62a3-4a4e-85b4-30e9eb7d3030)

Podria crear la base de datos con el nombre "cvds", para esto debemos ir a DBeaver y crearla:

![image](https://github.com/Mauricio-A-Monroy/lab7/assets/111905757/452720cb-6e51-485a-b481-5b6fb1130cd9)

luego dejamos el archivo applicatio.propertie como estaba y volvemos a ejecutar.

# Front-end en Reack
- Lo primero que debemos hacer es descargar e instalar Node.js
  ![image](https://github.com/Mauricio-A-Monroy/lab7/assets/111905757/a4cc5e19-7403-4d4f-b3eb-ff1a684899d3)
- Para verificar que se haya descargado e instalado correctamente usamos los comando `node -v` y `npm -v` para que nos muestre las versiones.
![image](https://github.com/Mauricio-A-Monroy/lab7/assets/111905757/58d55b77-2e96-4c02-8d98-8f1acf3281fd)
- Crear app de react en el proyecto de maven usando el comando `npx create-react-app mynewapp`
![image](https://github.com/Mauricio-A-Monroy/lab7/assets/111905757/10623b16-e9cd-40a7-aa09-759ceb5c0485)

- Despues de usar el comando `npm install` en caso de no descargarlo anteriormente
  
- ingresar a la carpeta donde se creo la aplicacion e iniciar el servidor con `npm strat`

![image](https://github.com/Mauricio-A-Monroy/lab7/assets/111905757/7c24a545-9078-493f-9efd-af1859db8ffb)
![image](https://github.com/Mauricio-A-Monroy/lab7/assets/111905757/ea1d6c96-d617-43e3-a948-fca73497ced2)

. Ya con la app de react creada empezaremos con la implementacion del front 
. como primer paso se listaran los usuarios de manera estatica para verificar el correcto funcionamiento 

![image](https://github.com/andreec2/cvds-lab7/assets/99145156/326fb9d1-bc18-4c05-a98d-496321e561b6)

-Ahora ya confirmado su funcionamiento nos conectaremos al back 
-como primer paso usaremos el comando `mpn install axios --save`
.Ya instalado nos vamos a conectar al back y quitaremos los datos estaticos

![image](https://github.com/andreec2/cvds-lab7/assets/99145156/d96e6bce-b1df-4793-904a-c8071403ffea)

-Ahora se empezaran a crear las funciones/pantallas para adduser, updateuser y deleteUser












