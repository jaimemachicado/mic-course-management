# Descripción

Microservicio que tiene endpoints para:

* Registrar un curso con o sin estudiantes
* Registrar un estudiante a un curso ya existente
* Obtener todos los cursos existentes
* Obtener un curso por identificador
* Actualizar la información de un curso

# Ejecución

Para su ejecución es necesario tener levantado el config server que se encuentra en:
[config-server](https://github.com/jaimemachicado/config-server)

También es necesario levantar el micro-servicio de gestión de estudiantes ya que se comunica,
haciendo uso de Feign con dicho servicio para registrar o actualizar la información de un
estudiante:
[mic-student-management](https://github.com/jaimemachicado/mic-student-management)

En la carpeta /postman se encuentra la colección con los diferentes endpoints que se pueden ejecutar
