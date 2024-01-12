package groupid.artifactid;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
//Permite definir una clave primaria compuesta en una entidad
@Embeddable
public class Enrolment implements Serializable {
    private Long studentId;
    private Long courseId;

}
