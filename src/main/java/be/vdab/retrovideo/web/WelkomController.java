package be.vdab.retrovideo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")

class WelkomController {

	@GetMapping
	ModelAndView welkom() {
		return new ModelAndView("welkom","boodschap", "boodschap");
	}
	
}
