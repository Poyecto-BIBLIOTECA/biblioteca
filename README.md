📚 Sistema de Gestión de Biblioteca

Sistema de gestión de inventario para bibliotecas con interfaz de terminal, desarrollado en Java con conexión a base de datos MySQL.

## 🎯 Objetivo
Modernizar la gestión de inventario de una biblioteca permitiendo:
- Registro y seguimiento de libros
- Búsquedas avanzadas
- Actualizaciones en tiempo real
- Información detallada de cada ejemplar

## ⚙️ Características Principales
### Funcionalidades Básicas
- **CRUD Completo** de libros
- Visualización de inventario
- Búsquedas por:
    - ISBN
    - Título
    - Autor
    - Género literario

### 🔧 Estructura Técnica
- **Arquitectura MVC**
- Conexión segura a MySQL usando JDBC
- Validación de datos en capa de repositorio
- Manejo de excepciones SQL con try-with-resources
- Uso de PreparedStatements para prevenir SQL injection

## 📦 Estructura del Proyecto
```plaintext
src/
├── main/
│   ├── java/org/biblioteca/
│   │   ├── config/          # Configuración de BD (DBManager)
│   │   ├── controller/      # Lógica de negocio (BookController)
│   │   ├── model/           # Entidades de datos (Book)
│   │   ├── repository/      # Acceso a datos (BookRepository)
│   │   ├── view/            # Interfaz de usuario (BookView)
│   │   └── Main.java        # Punto de entrada
│   └── resources/
└── test/                    # Pruebas unitarias (JUnit 5)
🛠 Requisitos Técnicos
Java JDK 21+

MySQL Server 8.0+

Intellij IDEA (recomendado)

Driver MySQL Connector/J 8.0+

🚀 Instalación
Clonar repositorio:

bash
git clone https://github.com/tu-usuario/biblioteca-java.git
Importar proyecto en Intellij como proyecto Maven

Crear base de datos:

sql
CREATE DATABASE library;
USE library;

CREATE TABLE book (
    idbook INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    author VARCHAR(100) NOT NULL,
    description VARCHAR(200),
    isbn VARCHAR(20) UNIQUE NOT NULL,
    genre VARCHAR(50)
);
Configurar credenciales en DBManager.java:

java
private static final String URL = "jdbc:mysql://localhost:3306/library";
private static final String USER = "tu_usuario";
private static final String PASSWORD = "tu_contraseña";
Ejecutar aplicación desde Main.java

🖥️ Uso
bash
Menú principal:
1. Ver listado de libros
2. Añadir libro
3. Editar libro
4. Eliminar libro
5. Salir

Ingrese opción: 1

🧪 Testing
Ejecutar pruebas unitarias con JUnit 5:

bash
mvn test
Cobertura actual:

BookController: 85%

BookRepository: 70%

Equipo de Desarrollo:

Paola Pinilla - Product owner and Developer
Bruna Sonda - Scrum master and Developer
Sofia Santos - Developer
Mariya Byehan - Developer


