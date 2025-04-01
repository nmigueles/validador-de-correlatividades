import java.util.ArrayList;
import java.util.List;

public class Materia {
    private final List<Materia> correlativas;

    public Materia() {
        this.correlativas = new ArrayList<>();
    }

    public void agregarCorrelativa(Materia materia) {
        this.correlativas.add(materia);
    }

    public boolean cumpleCorrelativas(Alumno alumno) {
        return correlativas.stream().allMatch(alumno::aprobo);
    }
}
