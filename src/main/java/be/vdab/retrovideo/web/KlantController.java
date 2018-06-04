package be.vdab.retrovideo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.retrovideo.entities.Klant;

@Controller
@RequestMapping("/klant")
class KlantController {
	
	private final static String KLANT_VIEW = "klant";

	@GetMapping()
	ModelAndView zoekKlant() {
		return new ModelAndView(KLANT_VIEW).addObject(new DeelNaamForm());
	}
}
