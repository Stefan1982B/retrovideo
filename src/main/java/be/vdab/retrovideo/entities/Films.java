package be.vdab.retrovideo.entities;

import java.math.BigDecimal;

import org.springframework.format.annotation.NumberFormat;

public class Films {
	private int id;
	private int genreId;
	private String titel;
	private int voorraad;
	private int gereserveerd;
	@NumberFormat(pattern = "0.00")
	private BigDecimal prijs;
	
	
	
	Films(int id, int genreId, String titel, int voorraad, int gereserveerd, BigDecimal prijs) {
		this.id = id;
		this.genreId = genreId;
		this.titel = titel;
		this.voorraad = voorraad;
		this.gereserveerd = gereserveerd;
		this.prijs = prijs;
	}
	
	
	Films() {
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGenreId() {
		return genreId;
	}
	public void setGenreId(int genreId) {
		this.genreId = genreId;
	}
	public String getTitel() {
		return titel;
	}
	public void setTitel(String titel) {
		this.titel = titel;
	}
	public int getVoorraad() {
		return voorraad;
	}
	public void setVoorraad(int voorraad) {
		this.voorraad = voorraad;
	}
	public int getGereserveerd() {
		return gereserveerd;
	}
	public void setGereserveerd(int gereserveerd) {
		this.gereserveerd = gereserveerd;
	}
	public BigDecimal getPrijs() {
		return prijs;
	}
	public void setPrijs(BigDecimal prijs) {
		this.prijs = prijs;
	}
	
	

}
