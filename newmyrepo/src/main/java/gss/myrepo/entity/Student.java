package gss.myrepo.entity;

import java.io.Serializable;
import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student implements Serializable {
	private static final long serialVersionUID = -9159100269051482774L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nume")
	private String nume;

	@Column(name = "prenume")
	private String prenume;

	@Column(name = "zi_nastere")
	private OffsetDateTime zi_nastere;
	
	public Student() {}
	
	public Student(String nume, String prenume) {
		this.nume = nume;
		this.prenume = prenume;
//		this.zi_nastere = zi_nastere;
	}

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

}
