package utn.nmigueles;

import java.util.HashSet;
import java.util.Set;

public class Materia {
    private final Set<Materia> correlativas = new HashSet<>();

    public void agregarCorrelativa(Materia materia) {
        this.correlativas.add(materia);
    }

    public boolean cumpleCorrelativas(Alumno alumno) {
        return correlativas.stream().allMatch(alumno::aproboMateria);
    }
}
