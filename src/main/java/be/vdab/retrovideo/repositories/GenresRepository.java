package be.vdab.retrovideo.repositories;

import java.util.List;

import be.vdab.retrovideo.entities.Genres;

public interface GenresRepository {
	List<Genres> findUniekeGenres();
}
