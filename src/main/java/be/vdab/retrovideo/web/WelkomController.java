package be.vdab.retrovideo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.retrovideo.services.GenresService;

@Controller
@RequestMapping("/")

class WelkomController {
	
	private GenresService genresService;
	
	WelkomController(GenresService genresService){
		this.genresService = genresService;
	}

	@GetMapping
	ModelAndView welkom() {
		return new ModelAndView("welkom","genres", genresService.findUniekeGenres());
	}
	
}
