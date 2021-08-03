package gss.myrepo.entity;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "samples")
public class Sample implements Serializable {
	private static final long serialVersionUID = -9159100269051482774L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	@Column(name = "text_option")
	private String textOption;

	@Column(name = "text_like")
	private String textLike;

	@Column(name = "date_value")
	private OffsetDateTime dateValue;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getTextLike() {
		return textLike;
	}

	public void setTextLike(String textLike) {
		this.textLike = textLike;
	}

	public String getTextOption() {
		return textOption;
	}

	public void setTextOption(String textOption) {
		this.textOption = textOption;
	}

	public OffsetDateTime getDateValue() {
		return dateValue;
	}

	public void setDateValue(OffsetDateTime dateValue) {
		this.dateValue = dateValue;
	}

}
