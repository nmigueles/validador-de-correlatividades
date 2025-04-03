import utn.nmigueles.Alumno;
import utn.nmigueles.Materia;
import org.junit.Before;

import java.util.*;

public abstract class BaseTest {
    // Materia a la que se puede inscribir con correlativas.
    protected Materia materiaConCorrelativas;
    // Materia a la que se puede inscribir sin correlativas.
    protected Materia materiaSinCorrelativas;
    // Todas las materias
    protected List<Materia> correlativas = new ArrayList<>();

    protected Alumno alumnoSinAprobadas;
    protected Alumno alumnoAlDia; // Que aprobo todo.

    @Before
    public void inicializar() {
        this.inicializarMaterias();
        this.inicializarAlumnos();
    }

    private void inicializarMaterias() {
        materiaConCorrelativas = new Materia();
        Materia materia1 = new Materia();
        Materia materia2 = new Materia();
        Materia materia3 = new Materia();

        materiaConCorrelativas.agregarCorrelativa(materia1);
        materiaConCorrelativas.agregarCorrelativa(materia2);
        materiaConCorrelativas.agregarCorrelativa(materia3);

        materiaSinCorrelativas = new Materia();

        Collections.addAll(this.correlativas, materia1, materia2, materia3);
    }

    private void inicializarAlumnos() {
        this.alumnoSinAprobadas = new Alumno(Set.of());
        this.alumnoAlDia = new Alumno(new HashSet<>(this.correlativas));
    }
}
