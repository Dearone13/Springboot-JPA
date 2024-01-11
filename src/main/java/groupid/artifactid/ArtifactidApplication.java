package groupid.artifactid;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.github.javafaker.Faker;

import java.util.List;

@SpringBootApplication
public class ArtifactidApplication {

	public static void main(String[] args) {

		SpringApplication.run(ArtifactidApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(StudentRepository studentRepository, StudentIdCardRespository studentIdCardRespository){
		return args -> {
			//Para utlizar faker necesitamos agregarlo a dependencias
			//Es el nombre de una biblioteca de código abierto que se utiliza para generar datos falsos o ficticios de forma rápida y sencilla.
			Faker faker = new Faker();
			//Generamos Primer Nombre
			String firstName = faker.name().firstName();
			//Generamos apellido
			String lastName = faker.name().lastName();
			//Generamos email
			//Format: Metodo estatico der java que permite formatear una cadena de texto
			//"%s" Significa el uso de variable, que en este caso son 2.
			String email = String.format("%s.%s@dearone.edu",firstName,lastName);
			//Se crea objeto student
			Student student = new Student(firstName,lastName,email,faker.number().numberBetween(17,55));
			//faker.number().numberBetween(17,55) -> Generea un numero aletorio entre 17 y 55
			//Creamos StudentIdCard



		};

	}

}
