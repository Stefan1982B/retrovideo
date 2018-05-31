package be.vdab.retrovideo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.retrovideo.services.FilmsService;
import be.vdab.retrovideo.services.GenresService;

@Controller
@RequestMapping("/")

class WelkomController {

	private GenresService genresService;
	private FilmsService filmsService;

	WelkomController(GenresService genresService) {
		this.genresService = genresService;
		this.filmsService = filmsService;
	}

	private final static String WELKOM = "welkom";

	@GetMapping
	ModelAndView welkom() {
		return new ModelAndView(WELKOM, "genres", genresService.findUniekeGenres());
	}

	//private final static String GENREFILMS = "genrefilms";
	
	@GetMapping(params = "id")
	ModelAndView films(int id) {
		return new ModelAndView(WELKOM, "genreFilms", filmsService.findByGenre(id));

	}
}
