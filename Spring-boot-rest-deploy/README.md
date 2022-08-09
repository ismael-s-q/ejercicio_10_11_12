1. Esto es una configuracion para el archivo application.properties y sirve para guardar los laptops creados en un disco extraible

spring.jpa.show-sql=true
spring.datasource.url=jdbc:h2:file:C:/data/sample (aquí va la ruta de tu proyecto)
spring.datasource.username=sa
spring.datasource.password=
spring.datasource.driverClassName=org.h2.Driver
#spring.jpa.hibernate.ddl-auto=creat
spring.jpa.hibernate.ddl-auto=update
spring.sql.init.mode=always
spring.jpa.defer-datasource-initialization=true


2. Proveedores cloud

* Heroku : backend (java, spring, postgreSql...)
* Netlify : frontend, (react , angular, ....)
* Vercel : frontend, (react , angular, ...)
