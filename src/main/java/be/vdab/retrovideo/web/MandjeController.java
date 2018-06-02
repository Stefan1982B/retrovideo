package be.vdab.retrovideo.web;


import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.retrovideo.entities.Films;
import be.vdab.retrovideo.services.FilmsService;

@Controller
@RequestMapping("/mandje")
class MandjeController {

	private final Mandje mandje;
	private final FilmsService filmsService;

	MandjeController(Mandje mandje, FilmsService filmsService) {
		this.mandje = mandje;
		this.filmsService = filmsService;
	}

	private List<Films> maakFilmsVanFilmsIds(List<Integer> filmIds) {
		List<Films> films = new ArrayList<>(filmIds.size());
		for (int id : filmIds) {
			filmsService.read(id).ifPresent(film -> films.add(film));
		}
		return films;
	}
			
	private final static String MANDJE_VIEW = "mandje";

	@GetMapping()
	ModelAndView toonMandje() {
		return new ModelAndView(MANDJE_VIEW)
				.addObject("filmsInMandje", maakFilmsVanFilmsIds(mandje.getFilmIds()))
				.addObject("totalePrijs", maakFilmsVanFilmsIds(mandje.getFilmIds()).stream()
			.map(film -> film.getPrijs())
			.reduce((x,y) ->x.add(y))); 
	}
	
	

	
	

}
