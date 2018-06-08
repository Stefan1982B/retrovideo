package be.vdab.retrovideo.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.retrovideo.entities.Film;
import be.vdab.retrovideo.entities.TotalePrijs;
import be.vdab.retrovideo.services.FilmsService;

@RunWith(MockitoJUnitRunner.class)
public class MandjeControllerTest {

	@Mock
	private Mandje dummyMandje;

	@Mock
	private FilmsService dummyFilmsService;

	private MandjeController controller;

	@Before
	public void before() {
		controller = new MandjeController(dummyMandje, dummyFilmsService);
	}

	@Test
	public void ToonMandjeWerktSamenMetMandjeDotJsp() {
		ModelAndView modelAndView = controller.toonMandje();
		assertEquals("mandje", modelAndView.getViewName());
	}

	@Test
	public void ToonMandjeGeeftFilmsDoor() {
		ModelAndView modelAndView = controller.toonMandje();
		assertTrue(modelAndView.getModel().containsKey("filmsInMandje"));
	}

	@Test
	public void VerwijderIdWerktSamenMetRedirectMandjeDotJsp() {
		int[] verwijderIds = { 1 };
		ModelAndView modelAndView = controller.verwijderId(verwijderIds);
		assertEquals("redirect:/mandje", modelAndView.getViewName());
	}

	@Test
	public void VerwijderIdGeeftFilmsDoor() {
		ModelAndView modelAndView = controller.toonMandje();
		assertTrue(modelAndView.getModel().containsKey("filmsInMandje"));
	}

	@Test
	public void VerwijderZonderIdWerktSamenMetRedirectMandjeDotJsp() {
		ModelAndView modelAndView = controller.VerwijderZonderId();
		assertEquals("redirect:/mandje", modelAndView.getViewName());
	}
	
	@Test
	public void ToonMandjeIgvDubbeleFilmWerktSamenMetMandjeDotJsp() {
		ModelAndView modelAndView = controller.toonMandjeIgvDubbeleFilm(1);
		assertEquals("mandje", modelAndView.getViewName());
	}

	@Test
	public void ToonMandjeIgvDubbeleFilmGeeftFilmsDoor() {
		ModelAndView modelAndView = controller.toonMandjeIgvDubbeleFilm(1);
		assertTrue(modelAndView.getModel().containsKey("filmsInMandje"));
	}
}
