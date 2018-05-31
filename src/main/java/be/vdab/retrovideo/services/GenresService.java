package be.vdab.retrovideo.services;

import java.util.List;

import be.vdab.retrovideo.entities.Genres;

public interface GenresService {
	List<Genres> findUniekeGenres();
}
