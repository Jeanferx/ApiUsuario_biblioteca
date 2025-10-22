---

## **README – ApiUsuario_biblioteca**

```markdown
# ApiUsuario_biblioteca

Microservicio encargado de la **gestión de usuarios** de la biblioteca.  
Permite el registro, autenticación y administración de los usuarios del sistema.

---

## Tecnologías

- Java 17
- Spring Boot 3.x
- Spring Security (si aplicas autenticación)
- JPA / Hibernate
- MySQL
- Swagger

---

## Funcionalidades principales

- Registro de usuarios (lectores, administradores, bibliotecarios)  
- Actualización de datos personales  
- Asignación de roles  
- Eliminación lógica o permanente  
- Consulta por ID o correo electrónico  

---

## Endpoints

| Método | Endpoint | Descripción |
|--------|-----------|-------------|
| GET | `/api/usuarios` | Lista todos los usuarios |
| GET | `/api/usuarios/{id}` | Consulta usuario por ID |
| POST | `/api/usuarios` | Registra nuevo usuario |
| PUT | `/api/usuarios/{id}` | Actualiza datos |
| DELETE | `/api/usuarios/{id}` | Elimina usuario |

---

## Ejecución

```bash
git clone https://github.com/Jeanferx/ApiUsuario_biblioteca.git
