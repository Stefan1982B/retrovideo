package be.vdab.retrovideo.services;

import java.util.List;
import java.util.Optional;

import be.vdab.retrovideo.entities.Films;
import be.vdab.retrovideo.entities.Genres;

public interface FilmsService {
	List<Films> findByGenre(int genreId);
	Optional<Films> read(int id); 
}
