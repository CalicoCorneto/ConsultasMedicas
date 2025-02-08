package com.mycompany.consultasmedicas;

import java.util.*;

public class ConsultasMedicas {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Doctor> doctores = new ArrayList<>();
    private static List<Paciente> pacientes = new ArrayList<>();
    private static List<Cita> citas = new ArrayList<>();
    private static Map<String, String> admins = new HashMap<>();

    public static void main(String[] args) {
        admins.put("Admin", "Admin123");
        admins.put("Javier", "123");

        if (!login()) {
            System.out.println("Sin acceso al programa");
            return;
        }

        int opcion;
        do {
            System.out.println("--------------------\nSistema de control de Citas");
            System.out.println("Seleccione una opcion: ");
            System.out.println("1: Agregar doctor");
            System.out.println("2: Agregar paciente");
            System.out.println("3: Crear cita");
            System.out.println("4: Ver citas");
            System.out.println("5: Salir");
            System.out.println("--------------------");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    agregarDoctor();
                    break;
                case 2:
                    agregarPaciente();
                    break;
                case 3:
                    crearCita();
                    break;
                case 4:
                    mostrarCitas();
                    break;
                case 5:
                    System.out.println("Hasta la proxima");
                    break;
                default:
                    System.out.println("Opcion no autorizada");
            }
        } while (opcion != 5);
    }

    private static boolean login() {
        System.out.print("Ingrese usuario: ");
        String usuario = scanner.nextLine();
        System.out.print("Ingrese contrasena: ");
        String contrasena = scanner.nextLine();
        return admins.containsKey(usuario) && admins.get(usuario).equals(contrasena);
    }

    private static void agregarDoctor() {
        System.out.print("Nombre del doctor: ");
        String nombre = scanner.nextLine();
        System.out.print("Especialidad: ");
        String especialidad = scanner.nextLine();
        Doctor doctor = new Doctor(UUID.randomUUID().toString(), nombre, especialidad);
        doctores.add(doctor);
        System.out.println("Doctor registrado exitosamente");
    }

    private static void agregarPaciente() {
        System.out.print("Nombre del paciente: ");
        String nombre = scanner.nextLine();
        Paciente paciente = new Paciente(UUID.randomUUID().toString(), nombre);
        pacientes.add(paciente);
        System.out.println("Paciente registrado exitosamente");
    }

    private static void crearCita() {
        if (doctores.isEmpty() || pacientes.isEmpty()) {
            System.out.println("Debe haber al menos un doctor y un paciente registrados");
            return;
        }

        System.out.println("Seleccione un doctor: ");
        for (int i = 0; i < doctores.size(); i++) {
            System.out.println((i + 1) + ". " + doctores.get(i).getNombre());
        }
        int doctorIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        System.out.println("Seleccione un paciente: ");
        for (int i = 0; i < pacientes.size(); i++) {
            System.out.println((i + 1) + ". " + pacientes.get(i).getNombre());
        }
        int pacienteIndex = scanner.nextInt() - 1;
        scanner.nextLine();
        
        System.out.print("Motivo de la cita: ");
        String motivo = scanner.nextLine();
        System.out.print("Ingrese fecha y hora de la cita (DD-MM-AAAA HH:MM): ");
        String fechaHora = scanner.nextLine();


        Cita cita = new Cita(UUID.randomUUID().toString(), fechaHora, motivo, doctores.get(doctorIndex), pacientes.get(pacienteIndex));
        citas.add(cita);
        System.out.println("Cita registrada exitosamente");
    }

    private static void mostrarCitas() {
        if (citas.isEmpty()) {
            System.out.println("No hay citas registradas");
            return;
        }
        for (Cita c : citas) {
            System.out.println("--------------------");
            System.out.println(c);
        }
    }
}

class Doctor {
    private String id, nombre, especialidad;

    public Doctor(String id, String nombre, String especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
    }
    public String getNombre() { return nombre; }
    public String toString() { return "Doctor: " + nombre + " (" + especialidad + ")"; }
}

class Paciente {
    private String id, nombre;

    public Paciente(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    public String getNombre() { return nombre; }
    public String toString() { return "Paciente: " + nombre; }
}

class Cita {
    private String id, fechaHora, motivo;
    private Doctor doctor;
    private Paciente paciente;

    public Cita(String id, String fechaHora, String motivo, Doctor doctor, Paciente paciente) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.motivo = motivo;
        this.doctor = doctor;
        this.paciente = paciente;
    }

    public String toString() {
        return "Cita: " + fechaHora + " - " + motivo + "\n  " + doctor + "\n  " + paciente;
    }
}