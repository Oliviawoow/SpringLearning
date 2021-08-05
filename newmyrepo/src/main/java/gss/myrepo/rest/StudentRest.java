package gss.myrepo.rest;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gss.myrepo.dto.StudentDto;
import gss.myrepo.service.StudentService;

@RestController
@RequestMapping("/students")
@Transactional
public class StudentRest {

	@Autowired
	private StudentService studentService;

	@GetMapping("/{id}")
	public ResponseEntity<StudentDto> get(@PathVariable Integer id) {
		final StudentDto byId = studentService.getById(id);
		if (byId == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.ok(byId);
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentDto> save(@RequestBody StudentDto student) {
		if (student.getId() != null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		return ResponseEntity.created(null).body(studentService.save(student));
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentDto> update(@RequestBody StudentDto student) {
		if (student.getId() == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		return ResponseEntity.ok(studentService.update(student));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable Integer id) {
		final StudentDto byId = studentService.getById(id);
		if (byId == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		studentService.delete(id);
		return ResponseEntity.ok().build();
	}

}
