package gss.myrepo.service;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gss.myrepo.dto.SampleDto;
import gss.myrepo.entity.Sample;

@Service
@Transactional
public class SampleService {

	@Autowired
	private EntityManager entityManager;

	public SampleDto save(SampleDto sample) {

		final Sample entity = new Sample();

		entity.setDateValue(sample.getDateValue());
		entity.setTextLike(sample.getTextLike());
		entity.setTextOption(sample.getTextOption());
		entityManager.persist(entity);

		sample.setId(entity.getId());

		return sample;
	}

	public SampleDto getById(UUID id) {
		Sample entity = entityManager.find(Sample.class, id);
		if (entity == null) {
			return null;
		}
		SampleDto dto = new SampleDto();
		dto.setId(entity.getId());
		dto.setDateValue(entity.getDateValue());
		dto.setTextLike(entity.getTextLike());
		dto.setTextOption(entity.getTextOption());
		return dto;
	}

	public SampleDto update(SampleDto sample) {
		Sample entity = entityManager.find(Sample.class, sample.getId());
		entity.setDateValue(sample.getDateValue());
		entity.setTextLike(sample.getTextLike());
		entity.setTextOption(sample.getTextOption());
		entityManager.persist(entity);

		sample.setId(entity.getId());

		return sample;
	}

	public void delete(UUID id) {

		Sample entity = entityManager.find(Sample.class, id);
		entityManager.remove(entity);
	}

}
