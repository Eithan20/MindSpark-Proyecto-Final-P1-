# MindSpark — Sistema de Estudio con Flashcards (Java)

MindSpark es una aplicación de escritorio desarrollada en **Java** que ayuda a estudiantes a **organizar apuntes** y **optimizar el aprendizaje** mediante **flashcards** y técnicas de **repaso**. Ofrece un entorno inmersivo sin distracciones, una estructura jerárquica para el contenido y una herramienta para **generar flashcards automáticamente** a partir de textos largos.

---

## ✨ Características principales

### 🔐 Autenticación de usuarios
- Registro e inicio de sesión (Login)
- Validación de credenciales
- Gestión segura de sesión

### 🗂️ Gestión de contenido
- Administración de **Asignaturas**
- Administración de **Temas** dentro de cada asignatura
- Operaciones CRUD: **Crear, Editar y Eliminar**

### 🧠 Sistema de Flashcards
- Visualizador de estudio con navegación fluida
- Renderizado **HTML** para una lectura más cómoda
- **Generación inteligente de tarjetas:** algoritmo que analiza un texto largo y lo divide en múltiples tarjetas legibles automáticamente

### 🖥️ Interfaz inmersiva
- UI moderna con **Java Swing**
- Modo **pantalla completa (Kiosco)** para maximizar la concentración

### ⚙️ Configuración
- Cambio de contraseña
- Cierre de sesión y administración básica del perfil

---

## 🧰 Tecnologías utilizadas

- **Lenguaje:** Java (JDK 17+)
- **UI:** Java Swing (AWT/Swing) con personalización de componentes
- **Base de datos:** MySQL (InnoDB)
- **Conectividad:** JDBC (`mysql-connector-j`)
- **Arquitectura:** MVC (Modelo–Vista–Controlador) + DAO
- **IDE:** NetBeans

---

## ✅ Requisitos previos

1. **JDK 17** o superior  
2. **MySQL** (XAMPP, WAMP o MySQL Server)
3. Driver **mysql-connector-j** agregado al proyecto

---

## 🚀 Instalación y ejecución

### 1) Base de datos
1. Abre tu gestor SQL (HeidiSQL / MySQL Workbench).
2. Ejecuta el script:  
   `db/script_mindspark.sql`
3. Se creará la base de datos **`proyecto_final`** junto con sus tablas.

### 2) Configuración de conexión
Si tu MySQL usa contraseña, edita el archivo:

`src/com/basededatos/Conexion.java`

y coloca tus credenciales locales.

### 3) Ejecutar el proyecto
1. Abre el proyecto en **NetBeans**
2. Ejecuta **Clean and Build**
3. Corre `VentanaPrincipal.java`

---

## 👥 Equipo de desarrollo

|       Rol       |          Miembro     |
|---              |          ---|
| **Líder de equipo** | Sabrina Vargas |
| **Programador principal** | Eithan Pérez |
| **QA (Control de calidad)** | Wilmer Hernández |
| **Diseñador UI/UX** | Fausto Junior |
| **Administrador de BD** | Leonardo De Jesús |

---

## 📌 Notas
- El código incluye comentarios internos que documentan la lógica de métodos, consultas SQL y el manejo de la interfaz.
- Proyecto de uso académico.

---

© 2025 MindSpark. Uso académico
