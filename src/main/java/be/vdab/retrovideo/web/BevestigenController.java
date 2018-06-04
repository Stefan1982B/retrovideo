package be.vdab.retrovideo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("klant{klantId}")
class BevestigenController {
	
	private final static String BEVESTIGEN_VIEW = "bevestigen";

	@GetMapping()
	ModelAndView bevestigReservatie() {
		return new ModelAndView(BEVESTIGEN_VIEW);
	}

}
