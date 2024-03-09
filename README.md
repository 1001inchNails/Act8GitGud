# **Actividad 8: GIT**
### *Contornos 1ºCS DAW 23/24*  
*Enunciado:*
>Actividad Biblioteca:
Hacer biblioteca con usuarios y libros que simule el alquiler de libros por parte de los usuarios.
Un usuario tiene atributos de: nombre, apellido, teléfono, email y libros pendientes de devolver.
Un libro tiene atributos de: título, autor y isbn.
Debe mostrar un menú que permita las opciones de: acceder a un usuario, ver libros disponibles, ver libros pendientes de devolver(por el usuario), pedir un libro y devolver un libro.
Todo esto se debe subir a un repositorio del cual me compartiréis el enlace.  

**Funcionamiento básico:**
El programa se divide en cuatro clases:
-**Libro:** establece la estructura para los objetos tipo Libro.
-**Usuario:** establece la estructura para los objetos tipo Usuario.
-**Biblioteca:** organiza el menú y realiza las llamadas a la clase Modelo.
-**Modelo:** se encarga de realizar las inicializaciones de los datos y de llevar a cabo las búsquedas y cambios que se soliciten.

# **Anotaciones de interés**

### Método getInstance()
Este método es usado para asegurar la instanciación única de la clase Modelo, ya que según las necesidades de la aplicación la biblioteca es una entidad singular. De esta manera se obtiene un ente central que controla todas las instancias de las demás clases y se ocupa de sus operaciones, facilitando el mantenimiento y las posibles ampliaciones de contenido.

### ConcurrentModificationException
Durante la realización de la actividad ha aparecido esta excepción, la cual es muy común al usar Collections.
El problema aparece al intentar modificar un ArrayList dentro de un **for each**, puesto que los dos funcionan mediante [iteradores](https://www.w3schools.com/java/java_iterator.asp).
La solución es tan fácil como cambiar el **for each** por un **for** normal, el cuál no usa iterador, eliminando así el conflicto.
