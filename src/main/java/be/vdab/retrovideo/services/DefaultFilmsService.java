package be.vdab.retrovideo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import be.vdab.retrovideo.entities.Films;
import be.vdab.retrovideo.entities.Genres;
import be.vdab.retrovideo.repositories.FilmsRepository;
import be.vdab.retrovideo.repositories.GenresRepository;

@Service
@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
class DefaultFilmsService implements FilmsService {
	
	
	private final FilmsRepository filmsRepository;

	DefaultFilmsService(FilmsRepository filmsRepository) {
		this.filmsRepository = filmsRepository;
	}

	@Override
	public List<Films> findByGenre(int genreId) {
		return filmsRepository.findByGenre(genreId);
	}

	@Override
	public Optional<Films> read(int id) {
		return filmsRepository.read(id);
	}

}
