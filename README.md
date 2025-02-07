#Consultorio médico

##Definición del programa

En este prorgama se cumple el funcionamiento mediante el ingreso por medio de administrador para la creación de consultas médicas. En este proyecto podemos :

- Ingresar como administradores. 
- Agregar doctores nuevos. 
- Agregar pacientes nuevos. 
- Crear consultas médicas. 
- Registrar fecha y hora de la conulta médica. 
- Visualizar todas las consultas registradas.

##Instalación y ejecución del programa

Para realizar correctamente el uso del programa se tendrá que descargar del repositorio el archivo correspondiente llamado .java, después se tendrá que inciar el programa como cualquier otro.

##Uso del programa

Para inciar el programa es necesario validar las licencias como administrador:

- Usuario: **Admin**
- Contraseña: **Admin123**

Después de verificar las licencias de administrador se le expandirá un menú donde se muestran las opciones:

- Agregar doctor.
- Agregar paciente.
- Crear cita.
- Ver citas.
- Salir.

En estas opciones se puede escoger del número 1 al 5 secuencialmente permitiendo introducir en:

- Doctor el Nombre y Especialidad.
- Paciente el Nombre.
- Crear cita el Doctor, Paciente, Motivo y Fecha y hora
- Ver citas muestra la Fecha y hora, Motivo, Doctor y Paciente

**Nota:** Al crear la cita se tiene que contar con al menos un doctor y un paciente dados de alta, en caso de no ser así, se mostrará un mensaje de **Debe haber al menos un doctor y un paciente registrados.**

###Descripción detallada

Clase **ConsultasMedicas** es la clase principal de la aplicación, encargada de gestionar el flujo del programa y almacenar listas de doctores, pacientes y citas, y manejar el acceso de los administradores:

**Variables**

- Scanner: Objeto Scanner para leer entrada del usuario.
- Doctores: Lista de objetos Doctor registrados en el sistema.
- Pacientes: Lista de objetos Paciente registrados en el sistema.
- Citas: Lista de objetos Cita registradas en el sistema.
- Admins: Mapa que almacena usuarios y contraseñas de administradores.

**Métodos**

- main(String[] args): Inicializa administradores y ejecuta el login, mostrando el menú de opciones y gestiona la interacción del usuario.
- login(): Solicita credenciales al usuario y valida si es un administrador autorizado.
- agregarDoctor(): Solicita nombre y especialidad para registrar un nuevo doctor.
- agregarPaciente(): Solicita el nombre para registrar un nuevo paciente.
- crearCita(): Permite la creación de una cita utilizando un doctor y un paciente, asignandole una fecha y un motivo
- mostrarCitas(): Muestra la lista de citas registradas.

Clase **Doctor** Se encarga de representar un doctor en el sistema.

**Variables**

- nombre: Nombre del doctor.
- especialidad: Especialidad del doctor.

**Métodos**

- Doctor(String id, String nombre, String especialidad): Es el constructor que inicia los atributos del doctor.
- getNombre(): Devuelve el nombre del doctor.
- toString(): Hace una representación en cadena del doctor, incluyendo su nombre y especialidad.

Clase **Paciente** Se encarga de representa un paciente en el sistema.

**Variables**

- nombre: Nombre del paciente.

**Métodos**

- Paciente(String id, String nombre): Constructor que inicializa los atributos del paciente.
- getNombre(): Devuelve el nombre del paciente.
- toString(): Hace una representación en cadena del paciente con su nombre.

Clase **Cita** Se encarga de representa un paciente en el sistema.

**Variables**

- fechaHora: Fecha y hora en que se hará la cita.
- motivo: Motivo de la consulta.
- doctor: Objeto Doctor asociado a la cita.
- paciente: Objeto Paciente asociado a la cita.

**Métodos**

- Cita(String id, String fechaHora, String motivo, Doctor doctor, Paciente paciente): Constructor que inicializa los atributos de la cita.
- toString(): Retorna una representación en cadena de la cita, mostrando la fecha, motivo, doctor y paciente.

### Diagrama de flujo

![Image](https://github.com/user-attachments/assets/bef4ca0c-15dc-4b1c-844b-289edc6f5490)

##Créditos

Luis Moran

##Licencia

Este proyecto esta licenciado bajo MIT
