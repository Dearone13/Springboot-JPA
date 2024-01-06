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
			//studentRepository.save(mariagit);

			Student pedro = new Student("Pedro","Hernandez","pedro.her@unimi.edu",21);
			System.out.println("Agregando a maria y pedro");
			//Guardamos una lista de entidades y List of es una lista inmutable
			//studentRepository.saveAll(List.of(maria,pedro));

			//Numero de estudiantes
			System.out.println("NUmgit ero de estudinates");
			//Devuelve el numero total de registros de una tabla
			System.out.println(studentRepository.count());

		};

	}

}
