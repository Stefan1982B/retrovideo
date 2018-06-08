package be.vdab.retrovideo.web;

import javax.validation.constraints.NotEmpty;

class DeelNaamForm {
	@NotEmpty
	private String deelNaam;

	public String getDeelNaam() {
		return deelNaam;
	}

	public void setDeelNaam(String deelNaam) {
		this.deelNaam = deelNaam;
	}
}
