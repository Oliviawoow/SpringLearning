package gss.myrepo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import gss.myrepo.entity.Student;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class MyrepoApplication {
	

	  private static final Logger log = 
			  LoggerFactory.getLogger(MyrepoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MyrepoApplication.class, args);
	}
	
//	@Bean
//	public CommandLineRunner demo(StudentRepository repository) {
//		return (args)-> {
//			repository.save(new Student("Diana", "Maria"));
//			repository.save(new Student("Mihai", "Robert"));
//			
//			log.info("Students found:");
//			for (Student student : repository.findAll()) {
//				log.info(student.toString());s
//			}
//			log.info("");
//			
//			Student student = repository.findById();
//			log.info("Students found:");
//			log.info(student.toString());
//			log.info("");
//		}
//	}

}
