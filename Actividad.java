public abstract class Actividad {
    private String nombre;

    public Actividad(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract void ejecutar();
}
