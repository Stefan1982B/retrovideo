package be.vdab.retrovideo.services;

import java.util.List;
import java.util.Optional;

import be.vdab.retrovideo.entities.Film;
import be.vdab.retrovideo.entities.Genre;

public interface FilmsService {
	List<Film> findByGenre(int genreId);
	Optional<Film> read(int id); 
	void update(Film film); 
}
