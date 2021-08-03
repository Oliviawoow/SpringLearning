package gss.myrepo.dto;

import java.time.OffsetDateTime;
import java.util.UUID;

public class SampleDto {
	private UUID id;
	private String textLike;
	private String textOption;
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

	@Override
	public String toString() {
		return "SampleDto [id=" + id + ", textLike=" + textLike + ", dateValue=" + dateValue + "]";
	}
}
