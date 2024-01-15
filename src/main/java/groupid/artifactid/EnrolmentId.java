package groupid.artifactid;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

//@Embeddable --> Permite definir una clave primaria compuesta en una entidad
@Embeddable
//Formato que permite alamcenar en archivos o bases de datos
// Conversión de objetos bits en una base de datos
public class EnrolmentId  implements Serializable {
    @Column(name = "student_id")
    private Long studentId;
    @Column(name = "course_id")
    private Long courseId;

    public EnrolmentId(Long studentId, Long courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }

    public EnrolmentId() {
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }
    //Sirve para definir si los dos atributos de la clase EnrolmentId son iguales

    @Override
    //Define un metodo de tipo boleano que da un como parametro tipo Object llamado o
    public boolean equals(Object o) {
        //Verifica si los dos objetos son de la misma referencia de memoria si es asi devuelve
        //true
        if(this == o) return true;
        //Verifica si o es nulo o no es de la misma clase que el objeto actual
        //Devuelve false
        if(o == null || getClass() != o.getClass()) return false;
        //Hace un castin seguro de el objeto o a la clase EnrolmentId
        EnrolmentId that = (EnrolmentId)  o;
        //Compara los valores de los atributos studentId y courseId
        return Objects.equals(studentId,that.studentId) &&Objects.equals(courseId ,that.courseId);

    }
    //En el caso concreto del método hashCode que has presentado,
    // este código hash se genera a partir de los atributos studentId y courseId,
    // que probablemente conforman la clave primaria de la clase EnrolmentId.

    //Esto asegura que inscripciones únicas tengan códigos hash únicos,
    // permitiendo un almacenamiento y búsqueda eficiente en colecciones.
    @Override
    public int hashCode(){
        //Calcula un codigo hash entre los codigos hash de studentId y courseId
        //Genera Codigo unicos
        return Objects.hash(studentId,courseId);
    }
}
