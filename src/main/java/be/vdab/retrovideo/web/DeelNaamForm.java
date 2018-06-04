package be.vdab.retrovideo.web;

import javax.validation.constraints.NotBlank;

class DeelNaamForm {
	@NotBlank
	private String deelNaam;

	public String getDeelNaam() {
		return deelNaam;
	}

	public void setDeelNaam(String deelNaam) {
		this.deelNaam = deelNaam;
	}
}
