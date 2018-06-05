package be.vdab.retrovideo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.retrovideo.services.KlantenService;

@Controller
@RequestMapping("klant")
class BevestigenController {
	
	private final Mandje mandje;
	private final KlantenService klantenService;

	BevestigenController(Mandje mandje, KlantenService klantenService) {
		this.mandje = mandje;
		this.klantenService = klantenService;
	}
	
	private final static String BEVESTIGEN_VIEW = "bevestigen";

	@GetMapping("{id}")
	ModelAndView bevestigReservatie(@PathVariable int id) {
		ModelAndView modelAndView = new ModelAndView(BEVESTIGEN_VIEW, "mandje", mandje.getFilmIds());
		modelAndView.addObject("klant", klantenService.read(id));
		return modelAndView;
	}
	
	
	private final static String REDIRECT_URL_NA_BEVESTIGING = "redirect:/klant/{id}/bevestigd";
	@PostMapping
	String bevestigd() {
	return REDIRECT_URL_NA_BEVESTIGING;
	}
}
