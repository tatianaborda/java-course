import java.util.Scanner;

public class GestorDeTareas {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        int totalPrioridad = 0;
        Actividad ultimaTarea = null;

        do {
            mostrarMenu();
            opcion = leerOpcion(sc);
            Resultado resultado = ejecutarOpcion(opcion, sc, totalPrioridad, ultimaTarea);
            totalPrioridad = resultado.totalPrioridad;
            ultimaTarea = resultado.tarea;
        } while (opcion != 3);

        sc.close();
    }

    public static void mostrarMenu() {
        System.out.println("\n=== Gestor de Tareas ===");
        System.out.println("1. Agregar tarea");
        System.out.println("2. Ver última tarea");
        System.out.println("3. Salir");
    }

    public static int leerOpcion(Scanner sc) {
        System.out.print("Elige una opción: ");
        return sc.nextInt();
    }

    public static Resultado ejecutarOpcion(int opcion, Scanner sc, int totalPrioridad, Actividad tarea) {
        sc.nextLine(); // limpiar buffer

        switch (opcion) {
            case 1:
                return agregarTarea(sc, totalPrioridad);
            case 2:
                if (tarea != null) {
                    tarea.ejecutar(); // polimorfismo
                } else {
                    System.out.println("Aún no hay tareas registradas.");
                }
                break;
            case 3:
                System.out.println("Hasta luego!");
                break;
            default:
                System.out.println("Opción inválida. Intentá de nuevo.");
        }

        return new Resultado(totalPrioridad, tarea);
    }

    public static Resultado agregarTarea(Scanner sc, int totalPrioridad) {
        System.out.print("Nombre de la tarea: ");
        String nombre = sc.nextLine();

        System.out.print("Prioridad (1 a 5): ");
        int prioridad = sc.nextInt();
        sc.nextLine();

        if (prioridad >= 1 && prioridad <= 5) {
            totalPrioridad += prioridad;
            Tarea nueva = new Tarea(nombre, prioridad);
            System.out.println("Tarea agregada.");
            System.out.println("Total acumulado de prioridades: " + totalPrioridad);
            return new Resultado(totalPrioridad, nueva);
        } else {
            System.out.println("Prioridad no válida.");
            return new Resultado(totalPrioridad, null);
        }
    }

    // Clase auxiliar para retornar múltiples valores
    public static class Resultado {
        int totalPrioridad;
        Actividad tarea;

        public Resultado(int totalPrioridad, Actividad tarea) {
            this.totalPrioridad = totalPrioridad;
            this.tarea = tarea;
        }
    }
}
