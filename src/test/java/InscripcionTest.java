import org.junit.Assert;
import org.junit.Test;
import utn.nmigueles.Alumno;
import utn.nmigueles.Inscripcion;
import utn.nmigueles.Materia;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InscripcionTest extends BaseTest {
    @Test
    public void testInscripcionAMateriasSinCorrelativas() {
        Inscripcion inscripcion = new Inscripcion(this.alumnoSinAprobadas, Set.of(this.materiaSinCorrelativas, new Materia(), new Materia()));
        Assert.assertTrue(inscripcion.aprobada());
    }

    @Test
    public void testInscripcionAMateriasConCorrelativasDondeElAlumnoNoAproboNinguna() {
        Inscripcion inscripcion = new Inscripcion(this.alumnoSinAprobadas, Set.of(this.materiaSinCorrelativas, this.materiaConCorrelativas));
        Assert.assertFalse(inscripcion.aprobada());
    }

    @Test
    public void testInscripcionAMateriasConCorrelativasDondeElAlumnoAproboSoloAlgunasCorrelativas() {
        List<Materia> todasMenosUna = new ArrayList<>(this.correlativas);
        todasMenosUna.remove(0);
        Alumno alumno = new Alumno(new HashSet<>(todasMenosUna));
        Inscripcion inscripcion = new Inscripcion(alumno, Set.of(this.materiaConCorrelativas));
        Assert.assertFalse(inscripcion.aprobada());
    }

    @Test
    public void testInscripcionAMateriasConCorrelativasDondeElAlumnoAproboTodasLasCorrelativas() {
        Inscripcion inscripcion = new Inscripcion(this.alumnoAlDia, Set.of(this.materiaSinCorrelativas, this.materiaConCorrelativas));
        Assert.assertTrue(inscripcion.aprobada());
    }

    @Test
    public void testInscripcionAMateriasConCorrelativasDondeElAlumnoCumpleConSoloLasCorrelativasDeUnaDeLasMaterias() {
        Materia materiaConOtrasCorrelativas = new Materia();
        materiaConOtrasCorrelativas.agregarCorrelativa(new Materia());

        Inscripcion inscripcion = new Inscripcion(this.alumnoAlDia, Set.of(materiaConOtrasCorrelativas, this.materiaConCorrelativas));
        Assert.assertFalse(inscripcion.aprobada());
    }
}
