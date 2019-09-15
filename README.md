# Solución Desafío 1- Oscar Quezada

Decidí realizar la opción 3 del desafío.
Se utilizó spring-boot, maven y swagger para el desarrollo.

# API

La app solo tiene un servicio rest con el path /api/v1/periods (GET)

### /api/v1/periods

El servicio llama al generador de datos, revisando que fechas faltan entregando el resultado.

# Configuración

Para especificar donde está el generador de datos, se debe ir al archivo de propiedades "application.yml" en la propiedad custom->backendService.

La aplicación está configurada para trabajar en el puerto 8081, para cambiarlo se debe ir al archivo "application.yml" en la propiedad server->port

# Compilar y ejecutar el proyecto

Para copilar el proyecto se requiere Java y Maven instalado.
Ingresar al directorio _solution_ ejecutar el siguiente comando _maven_

```bash
mvn package
```

Luego de compilar el proyecto ingresar al directorio _target_ ejecutar el siguiente comando _java_

```bash
java -jar .\solution-0.0.1-SNAPSHOT.jar
```

_Nota_:
Debe estar disponible el puerto _8081_ en el PC donde se ejecute esta API

# Entradas y salidas

El dato de entrada lo da el generador de la aplicación de previred.
La salida es como la que se muestra a continuación

```json
{
  "id": 1,
  "fechaCreacion": "2011-05-01",
  "fechaFin": "2011-10-01",
  "fechas": ["2011-05-01", "2011-06-01", "2011-09-01"],
  "fechasFaltantes": ["2011-07-01", "2011-08-01", "2011-10-01"]
}
```

# Swagger

Swagger está en el path /api/v1/swagger-ui.html
