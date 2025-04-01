import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Materia pdp = new Materia();
        Materia dds = new Materia();
        dds.agregarCorrelativa(pdp);

         Set<Materia> aprobadas = Set.of();

         Alumno alumno = new Alumno(aprobadas);

         Inscripcion inscripcion = new Inscripcion(alumno, Set.of(dds));

         System.out.println("Inscripcion: " + inscripcion.aprobada());
    }
}