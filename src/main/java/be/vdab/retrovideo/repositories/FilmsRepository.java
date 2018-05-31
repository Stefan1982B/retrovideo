package be.vdab.retrovideo.repositories;

import java.util.List;

import be.vdab.retrovideo.entities.Films;

public interface FilmsRepository {
	List<Films> findByGenre(int genreId);
}
