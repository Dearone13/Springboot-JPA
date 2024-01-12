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
	CommandLineRunner commandLineRunner(StudentRepository studentRepository, StudentIdCardRespository studentIdCardRespository) {
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
			String email = String.format("%s.%s@dearone.edu", firstName, lastName);
			//Se crea objeto student
			Student student = new Student(firstName, lastName, email, faker.number().numberBetween(17, 55));
			System.out.println("Student: " + student.toString());
			//faker.number().numberBetween(17,55) -> Generea un numero aletorio entre 17 y 55
			//Creamos StudentIdCard
			StudentIdCard studentIdCard = new StudentIdCard("123456789", student);
			//Guardamos la entidad en la base de datos
			System.out.println("Guardamos estudiante");
			studentIdCardRespository.save(studentIdCard);
			//Encontrar y imprimir por id 1 tipo Long
			System.out.println("Encontramos estudiante de id 1");
			studentIdCardRespository.findById(1L).ifPresent(System.out::println);
			//Encontrar y imprimir por id 1 tipo Long
			System.out.println("Encontramos estudiante de id 1 2.0");
			studentIdCardRespository.findById(1L).ifPresent(System.out::println);
			//Borrar por ID 1 tipo long
			//studentIdCardRespository.deleteById(1L);


		};


	}
	private void generateRandomStudents(StudentRepository studentRepository) {
		Faker faker = new Faker();
		for (int i = 0; i < 20; i++) {
			String firstName = faker.name().firstName();
			String lastName = faker.name().lastName();
			String email = String.format("%s.%s@amigoscode.edu", firstName, lastName);
			Student student = new Student(
					firstName,
					lastName,
					email,
					faker.number().numberBetween(17, 55));
			studentRepository.save(student);
		}


	}
}
