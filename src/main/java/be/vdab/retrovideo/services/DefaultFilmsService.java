package be.vdab.retrovideo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import be.vdab.retrovideo.entities.Film;
import be.vdab.retrovideo.entities.Genre;
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
	public List<Film> findByGenre(int genreId) {
		return filmsRepository.findByGenre(genreId);
	}

	@Override
	public Optional<Film> read(int id) {
		return filmsRepository.read(id);
	}

	@Override
	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED)
	public void update(Film film) {
		filmsRepository.update(film);
		
	}

}
