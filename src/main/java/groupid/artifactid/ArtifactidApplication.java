package groupid.artifactid;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ArtifactidApplication {

	public static void main(String[] args) {

		SpringApplication.run(ArtifactidApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(StudentRepository studentRepository){
		return args -> {
			//Creo a ambos estudiantes
			Student maria = new Student("Maria","Gonzales","maria.gonzales@dearone.edu",21);
			//studentRepository.save(maria);

			Student pedro = new Student("Pedro","Hernandez","pedro.her@unimi.edu",21);
			System.out.println("Agregando a maria y pedro");
			//Guardamos una lista de entidades y List of es una lista inmutable
			//studentRepository.saveAll(List.of(maria,pedro));

			//Numero de estudiantes
			System.out.println("NUmero de estudinates");
			//Devuelve el numero total de registros de una tabla
			System.out.println(studentRepository.count());

			//Se utiliza en lambda para referenciar al metodo
			//3L ----> NUmero ID tipo long
			//ifPresentOrElse es un método introducido en Java 9 en la interfaz Optional.
			//Toma dos argumentos: un consumidor (Consumer) que se ejecutará si el valor
			// está presente y un Runnable que se ejecutará si el valor no está presente.
			//() -> Es una expersión lambda si el estudinate no esta presente
			studentRepository.findById(3L).ifPresentOrElse(System.out::println,()-> System.out.println("Estudinate con id 3 no encontrado"));
			studentRepository.findById(4L).ifPresentOrElse(System.out::println,()-> System.out.println("Estudinate con id 4 no encontrado"));


			//Selecciona a todos los estudiantes
			System.out.println("Selecciona a todos los estudiantes");
			List<Student> students = studentRepository.findAll();
			//Arroga solo objetos y referencia
			students.forEach(System.out::println);
			//Imprime información
			System.out.println("Imprime información");
			for (Student stu: students) {
				System.out.println(stu.toString());
			}
			System.out.println("Borrar a maria");
			//Elimina al objeto por id de tipo long
			studentRepository.deleteById(3L);

			System.out.println("Cantidad actual");
			System.out.println(studentRepository.count());
		};

	}

}
