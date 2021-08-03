package gss.myrepo.rest;

import java.util.UUID;

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

import gss.myrepo.dto.SampleDto;
import gss.myrepo.service.SampleService;

@RestController
@RequestMapping("/samples")
@Transactional
public class SmapleRest {

	@Autowired
	private SampleService sampleService;

	@GetMapping("/{id}")
	public ResponseEntity<SampleDto> get(@PathVariable UUID id) {
		final SampleDto byId = sampleService.getById(id);
		if (byId == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.ok(byId);
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SampleDto> save(@RequestBody SampleDto sample) {
		if (sample.getId() != null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		return ResponseEntity.created(null).body(sampleService.save(sample));
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SampleDto> update(@RequestBody SampleDto sample) {
		if (sample.getId() == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		return ResponseEntity.ok(sampleService.update(sample));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable UUID id) {
		final SampleDto byId = sampleService.getById(id);
		if (byId == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		sampleService.delete(id);
		return ResponseEntity.ok().build();
	}

}
