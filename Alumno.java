public class Alumno {
    private String nombre;
    private int[] calificaciones;

    public Alumno(String nombre, int[] calificaciones) {
        if (calificaciones.length != 5) {
            throw new IllegalArgumentException("Las calificaciones deben ser un arreglo de cinco valores numéricos.");
        }
        this.nombre = nombre;
        this.calificaciones = calificaciones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int[] getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(int[] calificaciones) {
        if (calificaciones.length != 5) {
            throw new IllegalArgumentException("Las calificaciones deben ser un arreglo de cinco valores numéricos.");
        }
        this.calificaciones = calificaciones;
    }

    // Método para calcular el promedio
    public double calcularPromedio() {
        int suma = 0;
        for (int calificacion : calificaciones) {
            suma += calificacion;
        }
        return (double) suma / calificaciones.length;
    }

    // Método para obtener la calificación final
    public char obtenerCalificacionFinal(double promedio) {
        if (promedio <= 50) {
            return 'F';
        } else if (promedio <= 60) {
            return 'E';
        } else if (promedio <= 70) {
            return 'D';
        } else if (promedio <= 80) {
            return 'C';
        } else if (promedio <= 90) {
            return 'B';
        } else {
            return 'A';
        }
    }

    // Método para imprimir los resultados
    public void imprimirResultados(String nombre, double promedio, char calificacionFinal) {
        System.out.println("Nombre del estudiante: " + nombre);
        for (int i = 0; i < calificaciones.length; i++) {
            System.out.println("Calificación " + (i + 1) + ": " + calificaciones[i]);
        }
        System.out.println("Promedio: " + promedio);
        System.out.println("Calificación: " + calificacionFinal);
    }

    public static void main(String[] args) {
        try {
            int[] calificaciones = {90, 85, 88, 92, 87};
            Alumno alumno = new Alumno("Juan Pérez", calificaciones);

            double promedio = alumno.calcularPromedio();
            char calificacionFinal = alumno.obtenerCalificacionFinal(promedio);

            alumno.imprimirResultados(alumno.getNombre(), promedio, calificacionFinal);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}