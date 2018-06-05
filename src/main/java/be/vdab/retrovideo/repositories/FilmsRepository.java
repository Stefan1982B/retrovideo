package be.vdab.retrovideo.repositories;

import java.util.List;
import java.util.Optional;

import be.vdab.retrovideo.entities.Film;

public interface FilmsRepository {
	List<Film> findByGenre(int genreId);
	Optional<Film> read(int id);
	void update(Film film); 
}
