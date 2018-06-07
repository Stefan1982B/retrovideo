package be.vdab.retrovideo.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.retrovideo.entities.Klant;
import be.vdab.retrovideo.services.KlantenService;

@Controller
@RequestMapping("/klant")
class KlantController {
	
	private final KlantenService klantenService;
	
	KlantController(KlantenService klantenService){
		this.klantenService = klantenService;
	}
	
	private final static String KLANT_VIEW = "klant";

	@GetMapping()
	ModelAndView zoekKlant() {
		return new ModelAndView(KLANT_VIEW).addObject(new DeelNaamForm());
	}
	
	@GetMapping(params = "deelNaam")
	ModelAndView zoekOpDeelNaam(@Valid DeelNaamForm deelNaamForm, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView(KLANT_VIEW);
		if(bindingResult.hasErrors()) {
			return modelAndView;
		}
		List<Klant> klanten = klantenService.findByFamilienaamBevat(deelNaamForm.getDeelNaam());
		if(klanten.isEmpty()) {
			bindingResult.reject("geenKlanten");
		}
		else {
			modelAndView.addObject("klanten", klanten);
		}
		return modelAndView;
	}
}
