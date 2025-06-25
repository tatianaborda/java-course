public class Tarea extends Actividad {
    private int prioridad;

    public Tarea(String nombre, int prioridad) {
        super(nombre);
        this.prioridad = prioridad;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    @Override
    public void ejecutar() {
        System.out.println("Tarea: " + getNombre() + " (Prioridad: " + prioridad + ")");
    }
}
