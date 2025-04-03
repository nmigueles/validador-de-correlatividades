package utn.nmigueles;

import java.util.Set;

public class Alumno {
    private final Set<Materia> aprobadas;

    public Alumno(Set<Materia> aprobadas) {
        this.aprobadas = aprobadas;
    }

    public boolean aproboMateria(Materia materia) {
        return aprobadas.contains(materia);
    }
}
