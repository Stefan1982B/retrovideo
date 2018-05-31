package be.vdab.retrovideo.entities;

public class Genres {
	private int id;
	private String naam;
	
	Genres(int id, String naam) {
		this.id = id;
		this.naam = naam;
	}
	
	Genres() {
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}
	
	

}
