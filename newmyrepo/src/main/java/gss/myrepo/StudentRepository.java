package gss.myrepo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import gss.myrepo.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {
	List<Student> findByNume(String nume);
	Optional<Student> findById(Integer id);
}
