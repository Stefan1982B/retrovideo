package be.vdab.retrovideo.entities;

public class Genres {
	private int id;
	private String naam;
	
	public Genres(int id, String naam) {
		this.id = id;
		this.naam = naam;
	}
	
	public Genres() {
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
