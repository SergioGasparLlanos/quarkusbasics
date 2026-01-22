# Quarkus Productos API

Este proyecto es una API REST construida con **Quarkus** y **Java 17**. Implementa un CRUD de productos siguiendo las mejores prácticas de arquitectura por capas, utilizando el patrón Repository y DTOs para la transferencia de datos.

## 🚀 Tecnologías Utilizadas

* **Java 17**
* **Quarkus**: Framework Java nativo de Kubernetes.
* **Hibernate ORM con Panache**: Implementación del patrón Repository.
* **H2 Database**: Base de datos en memoria (ideal para desarrollo y pruebas).
* **RESTEasy Reactive Jackson**: Para endpoints REST rápidos y manejo de JSON.

## 🏗️ Arquitectura del Proyecto

El flujo de datos sigue una estructura desacoplada:



1. **DTO (Record)**: Objeto inmutable para la entrada de datos (sin ID).
2. **Resource (Controller)**: Define los endpoints y gestiona el protocolo HTTP.
3. **Service**: Capa de lógica de negocio y gestión de transacciones.
4. **Repository**: Abstracción de la base de datos mediante Panache.
5. **Entity**: Modelo persistente que representa la tabla en H2.

---

## 🛠️ Ejecución en Modo Desarrollo

Para iniciar la aplicación con **Hot-Reload** (los cambios se aplican al guardar), ejecuta el siguiente comando en la raíz del proyecto:

```bash
./mvnw quarkus:dev
```

## 📑 Consumo de Endpoints

Puedes probar la API utilizando `curl`, Postman o cualquier cliente REST.

### 1. Insertar un nuevo Producto
Utiliza este endpoint para registrar un producto en la base de datos H2. La validación requiere que el nombre no esté vacío y el precio sea positivo.

- **URL:** `POST http://localhost:8080/productos`
- **Headers:** `Content-Type: application/json`
- **Cuerpo del JSON:**
```json
{
  "nombre": "Monitor UltraWide 34\"",
  "precio": 450.99
}
```


### 2. Consultar un producto por el id
Utiliza este endpoint para consultar un producto por el id.

- **URL:** `GET http://localhost:8080/productos/1`
- **Headers:** `Content-Type: application/json`
- **Cuerpo del JSON:** Sin cuerpo

### 3. Consultar todos los productos
Utiliza este endpoint para consultar todos los productos

- **URL:** `POST http://localhost:8080/productos`
- **Headers:** `Content-Type: application/json`
- **Cuerpo del JSON:** Sin cuerpo