package be.vdab.retrovideo.web;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.retrovideo.entities.Reservatie;
import be.vdab.retrovideo.services.KlantenService;
import be.vdab.retrovideo.services.ReservatiesService;

@Controller
@RequestMapping("klant")
class BevestigenController {
	
	private final Mandje mandje;
	private final KlantenService klantenService;
	private final ReservatiesService reservatiesService;

	BevestigenController(Mandje mandje, KlantenService klantenService, ReservatiesService reservatiesService) {
		this.mandje = mandje;
		this.klantenService = klantenService;
		this.reservatiesService = reservatiesService;
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
		return modelAndView;
	}
	
	private final static String REDIRECT_URL_NA_BEVESTIGING = "redirect:/klant/{klantId}/bevestigd";
	private static final String REDIRECT_URL_BIJ_MISLUKTE_RESERVATIE =   "reservatiemislukt"; 
	@PostMapping("{klantId}/bevestigd")
	ModelAndView bevestigd(@PathVariable int klantId) {
		for(int filmId : mandje.getFilmIds()) {
			Reservatie reservatie = new Reservatie(klantId, filmId, LocalDateTime.now());
			reservatiesService.create(reservatie);
		}

	return new ModelAndView(REDIRECT_URL_NA_BEVESTIGING);
	}
}
