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
/src
  /main
    /java/com/ad/backend/mvc
      /model/entity     # Clases de entidades (Departamentos, Empleados)
      /model/dao       # Interfaces de acceso a datos
      /model/services  # Lógica de negocio
    /resources
      application.properties  # Configuración de la aplicación
  /test  # Pruebas unitarias
```

## Endpoints API REST

Ejemplo de algunos endpoints disponibles:

GET /empleados - Obtiene todos los empleados.

GET /empleados/{id} - Obtiene un empleado por ID.

POST /empleados - Crea un nuevo empleado.