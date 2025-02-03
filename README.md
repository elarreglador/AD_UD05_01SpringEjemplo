# Proyecto de Gestión de Empleados con Spring Boot y Hibernate

Este proyecto es una aplicación de backend basada en **Spring Boot** que utiliza **Hibernate** para la gestión de datos en una base de datos MySQL.

## 📌 Tecnologías Utilizadas
- **Java**
- **Spring Boot**
- **Hibernate**
- **MySQL**
- **Maven**
- **Spring Data JPA**

## ⚙️ Configuración de la Base de Datos

La conexión a MySQL está definida en `hibernate.cfg.xml`:

```xml
<hibernate-configuration>
    <session-factory name="ejemplospring">
        <property name="hibernate.connection.driver_class">com.mysql.jdbc.Driver</property>
        <property name="hibernate.connection.url">jdbc:mysql://localhost/ejemplo</property>
        <property name="hibernate.connection.username">phpmyadmin</property>
        <property name="hibernate.connection.password">mysqlpasswd</property>
        <property name="hibernate.dialect">org.hibernate.dialect.MySQLDialect</property>
    </session-factory>
</hibernate-configuration>
```

## Clonar el repositorio

```bash
git clone https://github.com/elarreglador/AD_UD05_01SpringEjemplo.git
```

## Configurar la base de datos

Acceder a src/main/resources/application.properties o hibernate.cfg.xml y modificar las credenciales de MySQL si es necesario.

## Compilar y ejecutar

```bash
mvn clean install
mvn spring-boot:run
```

Estructura del Proyecto

```
src/main/java/com/pedro/backend/mvc/
  |
  L SpringEjemploApplication.java  			# Main
  |
  L model/controllers				
  |   L DepartamentosRestControllers.java	# Controlador de departamentos
  |   L EmpleadosRestControllers.java		# Controlador de empleados
  |
  L model/dao       
  |   L IDepartamentosDAO.java				# Interfaz DAO departamentos
  |   L IEmpleadosDAO.java					# Interfaz DAO empleados
  |
  L model/entity		
  |   L Departamentos.java					# DAO departamentos
  |   L Empleados.java  					# DAO empleados
  |
  L model/services  	
      L DepartamentosServiceImpl.java		# Servicios de departamentos
      L EmpleadosServiceImpl.java  			# Servicios de empleados
      L IDepartamentosService.java  		# Interfaz servicios departamentos
      L IEmpleadosService.java  			# Interfaz servicios empleados
```

## Resumen del flujo

1 - El controlador recibe las solicitudes HTTP

2 - El controlador delega la logica a la interfaz de servicio que delega en el servicio que interactua con el DAO

3 - El servicio devuelve los datos al controlador que los envia al cliente en formato JSON

## Endpoints API REST

Ejemplo de algunos endpoints disponibles en los controladores:

GET /empleados - Obtiene todos los empleados.

GET /empleados/{id} - Obtiene un empleado por ID.

POST /empleados - Crea un nuevo empleado.

## Postman

Para verificar funcionamiento he usado postman, en el directorio PostmanExport hay una exportacion de los metodos HTTP, se pueden importar y verificar el funcinamiento de la app.