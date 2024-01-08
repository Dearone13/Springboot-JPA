package groupid.artifactid;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Long> {
    //En Spring Data JPA, la anotación @Query se utiliza para definir consultas
    // JPQL o SQL personalizadas en los métodos de los repositorios. Esto permite tener mayor flexibilidad
    // y control sobre la ejecución de consultas en la base de datos.

    //*SELECT s: Especifica que se desea recuperar todos los atributos de la entidad Student y almacenarlos en la variable s.
    //*FROM Student: Indica la entidad desde la cual se recuperarán los datos, en este caso la entidad Studen
    //*WHERE: Introduce una cláusula condicional que filtra los resultados de la consulta.
    //*s.email: Se refiere al atributo email del objeto s de tipo Student.
    //*= ?1: Establece una condición de igualdad (=) entre el atributo email del objeto s y un parámetro identificado por el número 1.
    //Este parámetro debe ser proporcionado dinámicamente al momento de ejecutar la consulta.

    @Query("SELECT s FROM Student s WHERE s.email = ?1")

    //Optional: Es una clase contenedora de Java que representa un valor que puede estar presente o ausente.
    //<Student>: Indica que el valor que posiblemente contiene es de tipo Student, es decir, un objeto que representa a un estudiante.
    //findStudentByEmail: Es el nombre del método.
    //(String email): Es el parámetro que recibe el método, siendo email una variable de tipo String que
    //representa el correo electrónico del estudiante a buscar.

    Optional<Student> finStudentByEmail(String email);
    //Selecionar en la variable s de la tabla Studetn donde first_name sea igual al dato ingresado y edad sea mayor o
    //igual
    @Query("SELECT s FROM Student s WHERE s.firstName =?1 AND s.age >= ?2")
    List<Student> selectStudentWhereFirstNameAndAgeGreaterOrEqual(String firstName, Integer age );


    @Query(
            value = "SELECT * FROM student WHERE first_name = :firstName AND age >= :age",
            //Usara sintaxis nativa SQL
            nativeQuery = true)
    List<Student> selectStudentWhereFirstNameAndAgeGreaterOrEqualNative(
            //Asocia nombres explicitos de las consultas JPQL a una consulta nativa
            @Param("firstName") String firstName,
            @Param("age") Integer age);
    @Transactional
    //Delimita los limites de una transacción: Asegurar integridad y consistencia
    @Modifying
    //Señala metodos de operación: (INSERT,DELETE,CREATE)
    //Actualiza el estado de la entidad adminsitrada: Debe ser actulizado en el contexto de la persistencia
    @Query("DELETE FROM Student u WHERE u.id = ?1")
    int deleteStudentById(Long id);

}
