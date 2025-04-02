package utn.nmigueles;

import java.util.Set;

public class Inscripcion {
    private final Alumno alumno;
    private final Set<Materia> materias;

    public Inscripcion(Alumno alumno, Set<Materia> materias) {
        this.alumno = alumno;
        this.materias = materias;
    }

    public boolean aprobada() {
        return materias.stream().allMatch(materia -> materia.cumpleCorrelativas(alumno));
    }
}
