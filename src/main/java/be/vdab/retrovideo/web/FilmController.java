package be.vdab.retrovideo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.retrovideo.services.FilmsService;

@Controller
@RequestMapping("film")
class FilmController {

	private final FilmsService filmsService;
	private final Mandje mandje;

	FilmController(FilmsService filmsService, Mandje mandje) {
		this.filmsService = filmsService;
		this.mandje = mandje;
	}

	private final static String FILM_VIEW = "film";

	@GetMapping("{id}")
	ModelAndView toonFilm(@PathVariable int id) {
		ModelAndView modelAndView = new ModelAndView(FILM_VIEW);
		filmsService.read(id).ifPresent(film -> modelAndView.addObject(film));
		return modelAndView;
	}


	private static final String REDIRECT_NA_TOEVOEGEN = "redirect:/mandje";

	@PostMapping("{id}")
	ModelAndView voegFilmToeAanMandje(@PathVariable int id) {
		mandje.addFilmId(id);
		return new ModelAndView(REDIRECT_NA_TOEVOEGEN);
	}
}
