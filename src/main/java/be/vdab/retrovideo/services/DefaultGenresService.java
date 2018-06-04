package be.vdab.retrovideo.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import be.vdab.retrovideo.entities.Genre;
import be.vdab.retrovideo.repositories.GenresRepository;

@Service
@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
class DefaultGenresService implements GenresService {

	private final GenresRepository genresRepository;

	DefaultGenresService(GenresRepository genresRepository) {
		this.genresRepository = genresRepository;
	}

	@Override
	public List<Genre> findUniekeGenres() {
		return genresRepository.findUniekeGenres();
	}

}
