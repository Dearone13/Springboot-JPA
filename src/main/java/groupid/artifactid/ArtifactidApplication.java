package groupid.artifactid;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.github.javafaker.Faker;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
			System.out.println("Student: "+student.toString());
			//faker.number().numberBetween(17,55) -> Generea un numero aletorio entre 17 y 55
			System.out.println("Agregando libros");
			student.addBook(new Book("Codigo Limpio", LocalDateTime.now().minusDays(4)));
			//Agrega la fecha de 4 dias atras a partir del actual
			student.addBook(new Book("El imperio final",LocalDateTime.now()));
			//Agrega fecha actual
			student.addBook(new Book("Spring boot JPA",LocalDateTime.now().minusYears(1)));
			//Agrega un año menos a partir del actual
			//Creamos StudentIdCard
			System.out.println("Creando tarjeta de estudiante");
			StudentIdCard studentIdCard = new StudentIdCard("123456789",student);
			System.out.println("Actulizando estudinate de la tarjeta");
			//Actualizamos StudentIdCard
			studentIdCardRespository.save(studentIdCard);
			student.setStudentIdCard(studentIdCard);
			//Guardamos student en base de datos
			System.out.println("Guardando estudinate");
			studentRepository.save(student);
			System.out.println("Mostrar libros prestrados al estudiante de id 1");
			studentRepository.findById(1L).ifPresent(s ->{
				System.out.println("Buscar libro lento");
				List<Book> books = student.getBooks();
				books.forEach(book -> {
					System.out.println(s.getFirstName()+" prestado "+book.getBookName());
				});
			});




		};

	}

}
