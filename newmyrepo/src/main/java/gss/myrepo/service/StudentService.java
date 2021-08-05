package gss.myrepo.service;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gss.myrepo.StudentRepository;
import gss.myrepo.dto.StudentDto;
import gss.myrepo.entity.Student;

@Service
@Transactional
public class StudentService {

//	@Autowired
//	private EntityManager entityManager;
	@Autowired
	private StudentRepository repository;

	public StudentDto save(StudentDto student) {

		final Student entity = new Student();

		entity.setZi_nastere(student.getZi_nastere());
		entity.setNume(student.getNume());
		entity.setPrenume(student.getPrenume());
		repository.save(entity);

		student.setId(entity.getId());

		return student;
	}

	public StudentDto getById(Integer id) {
		Optional<Student> entity = repository.findById(id);
		if (entity == null) {
			return null;
		}
		StudentDto dto = new StudentDto();
		dto.setId(entity.get().getId());
		dto.setZi_nastere(entity.get().getZi_nastere());
		dto.setNume(entity.get().getNume());
		dto.setPrenume(entity.get().getPrenume());
		return dto;
	}

	public StudentDto update(StudentDto student) {
		Student entity = repository.findById(student.getId()).get();
		entity.setZi_nastere(student.getZi_nastere());
		entity.setNume(student.getNume());
		entity.setPrenume(student.getPrenume());
		repository.save(entity);

		student.setId(entity.getId());

		return student;
	}

	public void delete(Integer id) {

		Student entity = repository.findById(id).get();
		repository.delete(entity);
	}

}
