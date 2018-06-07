package be.vdab.retrovideo.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import be.vdab.retrovideo.entities.Film;
import be.vdab.retrovideo.entities.Klant;
import be.vdab.retrovideo.exceptions.FilmNietGevondenException;
import be.vdab.retrovideo.services.FilmsService;
import be.vdab.retrovideo.services.KlantenService;
import be.vdab.retrovideo.services.ReservatiesService;

@RunWith(MockitoJUnitRunner.class)
public class RapportControllerTest {
	
	@Mock
	private Mandje dummyMandje;

	@Mock
	private FilmsService dummyFilmsService;
	
	@Mock
	private KlantenService dummyKlantenService;
	
	@Mock
	private ReservatiesService dummyReservatiesService;
	
	@Mock
	private RedirectAttributes redirectAttributes;

	private RapportController controller;

	@Before
	public void before() {
		controller = new RapportController(dummyMandje, dummyKlantenService, dummyReservatiesService, dummyFilmsService );
	}

	@Test
	public void bevestigReservatieWerktSamenMetBevestigenDotJsp() {
		ModelAndView modelAndView = controller.bevestigReservatie(1);
		assertEquals("bevestigen", modelAndView.getViewName());
	}

	@Test
	public void bevestigReservatieGeeftMandjeDoor() {
		ModelAndView modelAndView = controller.bevestigReservatie(1);
		assertTrue(modelAndView.getModel().containsKey("mandje"));
	}
	
	@Test
	public void bevestigReservatieGeeftKlantDoor() {
		ModelAndView modelAndView = controller.bevestigReservatie(1);
		assertTrue(modelAndView.getModel().containsKey("klant"));
	}
	
	@Test
	public void bevestigdViewWerktSamenMetBevestigdDotJsp() {
		ModelAndView modelAndView = controller.bevestigdview(1);
		assertEquals("bevestigd", modelAndView.getViewName());
	}
	
	@Test
	public void misluktViewWerktSamenMetBevestigdDotJsp() {
		ModelAndView modelAndView = controller.misluktview("mislukt");
		assertEquals("bevestigd", modelAndView.getViewName());
	}

	@Test
	public void bevestigdWerktSamenMetBevestigdDotJsp() {
		ModelAndView modelAndView = controller.bevestigd(1, redirectAttributes);
		assertEquals("redirect:/klant/{klantId}/bevestigd", modelAndView.getViewName());
	}
	
}
