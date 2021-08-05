package gss.myrepo.dto;

import java.time.OffsetDateTime;

public class StudentDto {
	private Integer id;
	private String nume;
	private String prenume;
	private OffsetDateTime zi_nastere;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getPrenume() {
		return prenume;
	}

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}

	public OffsetDateTime getZi_nastere() {
		return zi_nastere;
	}

	public void setZi_nastere(OffsetDateTime zi_nastere) {
		this.zi_nastere = zi_nastere;
	}

	@Override
	public String toString() {
		return "SampleDto [id=" + id + ", nume=" + nume + ", zi de nastere=" + zi_nastere + "]";
	}
}
