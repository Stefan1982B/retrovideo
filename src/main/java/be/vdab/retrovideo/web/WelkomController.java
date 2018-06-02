package be.vdab.retrovideo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.retrovideo.services.FilmsService;
import be.vdab.retrovideo.services.GenresService;

@Controller
@RequestMapping("/")

class WelkomController {

	private final GenresService genresService;
	private final FilmsService filmsService;

	WelkomController(GenresService genresService, FilmsService filmsService) {
		this.genresService = genresService;
		this.filmsService = filmsService;
	}

	private final static String WELKOM_VIEW = "welkom";

	@GetMapping
	ModelAndView welkom() {
		return new ModelAndView(WELKOM_VIEW, "genres", genresService.findUniekeGenres());
	}

	@GetMapping("{genreId}")
	ModelAndView findFilmsByGenre(@PathVariable int genreId) {
		return new ModelAndView(WELKOM_VIEW, "genres", genresService.findUniekeGenres()).addObject("genreFilms",
				filmsService.findByGenre(genreId));
	}
}
