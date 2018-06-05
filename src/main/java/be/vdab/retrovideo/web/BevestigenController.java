package be.vdab.retrovideo.web;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.retrovideo.entities.Film;
import be.vdab.retrovideo.entities.Reservatie;
import be.vdab.retrovideo.services.FilmsService;
import be.vdab.retrovideo.services.KlantenService;
import be.vdab.retrovideo.services.ReservatiesService;

@Controller
@RequestMapping("klant")
class BevestigenController {

	private final Mandje mandje;
	private final KlantenService klantenService;
	private final ReservatiesService reservatiesService;
	private final FilmsService filmsService;

	BevestigenController(Mandje mandje, KlantenService klantenService, ReservatiesService reservatiesService,
			FilmsService filmsService) {
		this.mandje = mandje;
		this.klantenService = klantenService;
		this.reservatiesService = reservatiesService;
		this.filmsService = filmsService;
	}

	private final static String BEVESTIGEN_VIEW = "bevestigen";

	@GetMapping("{id}")
	ModelAndView bevestigReservatie(@PathVariable int id) {
		ModelAndView modelAndView = new ModelAndView(BEVESTIGEN_VIEW, "mandje", mandje.getFilmIds());
		modelAndView.addObject("klant", klantenService.read(id));
		return modelAndView;
	}

	private final static String BEVESTIGD_VIEW = "bevestigd";

	@GetMapping("{klantId}/bevestigd")
	ModelAndView bevestigdview(@PathVariable int klantId) {
		ModelAndView modelAndView = new ModelAndView(BEVESTIGD_VIEW);
		List<String> filmTitels = new ArrayList<>();
		for (int filmId : mandje.getFilmIds()) {
			Reservatie reservatie = new Reservatie(klantId, filmId, LocalDateTime.now());
			Optional<Film> film = filmsService.read(filmId);
			if (film.get().getGereserveerd() >= film.get().getVoorraad()) {
				filmTitels.add(film.get().getTitel());
			}
		}
		modelAndView.addObject("filmTitels", filmTitels);
		return modelAndView;
	}

	private final static String REDIRECT_URL_NA_BEVESTIGING = "redirect:/klant/{klantId}/bevestigd";

	@PostMapping("{klantId}/bevestigd")
	ModelAndView bevestigd(@PathVariable int klantId) {
		ModelAndView modelAndView = new ModelAndView(REDIRECT_URL_NA_BEVESTIGING);
		List<String> filmTitels = new ArrayList<>();
		for (int filmId : mandje.getFilmIds()) {
			Reservatie reservatie = new Reservatie(klantId, filmId, LocalDateTime.now());
			Optional<Film> film = filmsService.read(filmId);
			if (film.get().getGereserveerd() >= film.get().getVoorraad()) {
				filmTitels.add(film.get().getTitel());
			} else {
				reservatiesService.updateReservatiesEnFilms(reservatie, film.get());
			}
		}
		modelAndView.addObject("filmTitels", filmTitels);
		return modelAndView;
	}
}
