import java.util.Set;

public class Alumno {
    private final Set<Materia> aprobadas;

    public Alumno(Set<Materia> aprobadas) {
        this.aprobadas = aprobadas;
    }

    public boolean aprobo(Materia materia) {
        return aprobadas.contains(materia);
    }
}
