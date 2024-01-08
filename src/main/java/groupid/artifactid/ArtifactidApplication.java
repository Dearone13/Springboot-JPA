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
			Student maria = new Student(
					"Maria",
					"Gonzales",
					"maria.gonzales@dearone.edu",
					21
			);
			Student maria2 = new Student(
					"Maria",
					"Pedraita",
					"maria.pedraita@dearone.edu",
					25
					);

			Student pedro = new Student(
					"Pedro",
					"Hernandez",
					"pedro.her@unimi.edu",
					21
			);
			System.out.println("Agregando a maria, maria2 y pedro");
			//Guardamos una lista de entidades y List of es una lista inmutable
			studentRepository.saveAll(List.of(maria,maria2,pedro));

			//Encuentra estudiante por email
			System.out.println("Encontrando estudiante por email");
			studentRepository.finStudentByEmail("pedro.her@unimi.edu").ifPresentOrElse(System.out::println, ()-> System.out.println("Estudiante con email pedro.her@unimi.edu no encontrado"));
			//Encuentra estudiante  por Nombre y edad sea mayor o igual
			System.out.println("Encuentra estudinate por nombre y edad");
			studentRepository.selectStudentWhereFirstNameAndAgeGreaterOrEqual("Maria",21).forEach(System.out::println);
			System.out.println("Encuentra estudinate por nombre y edad de forma nativa");
			studentRepository.selectStudentWhereFirstNameAndAgeGreaterOrEqualNative("Maria",21).forEach(System.out::println);
			System.out.println("Borrando Maria2");
			System.out.println(studentRepository.deleteStudentById(2L));

		};

	}

}
