package be.vdab.retrovideo.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.retrovideo.entities.Film;
import be.vdab.retrovideo.entities.Klant;
import be.vdab.retrovideo.services.KlantenService;

@RunWith(MockitoJUnitRunner.class)
public class KlantControllerTest {

	private KlantController controller;

	@Mock
	private KlantenService dummyKlantenService;

	@Mock
	private BindingResult bindingResult;

	@Before
	public void before() {
		List<Klant> klanten = new ArrayList<>();
		klanten.add(new Klant(1, "Schuddinck", "Stefan", "VlamingStraat", "8000", "Wevelgem"));
		when(dummyKlantenService.findByFamilienaamBevat("Sc")).thenReturn(klanten);
		controller = new KlantController(dummyKlantenService);
	}

	@Test
	public void zoekKlantWerktSamenMetKlantDotJsp() {
		ModelAndView modelAndView = controller.zoekKlant();
		assertEquals("klant", modelAndView.getViewName());
	}

	@Test
	public void zoekKlantGeeftdeelNaamFormDoor() {
		ModelAndView modelAndView = controller.zoekKlant();
		assertTrue(modelAndView.getModel().containsKey("deelNaamForm"));
	}

	@Test
	public void deelNaamWerktSamenMetKlantDotJsp() {
		DeelNaamForm deelNaamForm = new DeelNaamForm();
		deelNaamForm.setDeelNaam("Sc");
		ModelAndView modelAndView = controller.zoekOpDeelNaam(deelNaamForm, bindingResult);
		assertEquals("klant", modelAndView.getViewName());
	}

	@Test
	public void deelNaamGeeftKlantenDoor() {
		DeelNaamForm deelNaamForm = new DeelNaamForm();
		deelNaamForm.setDeelNaam("Sc");
		ModelAndView modelAndView = controller.zoekOpDeelNaam(deelNaamForm, bindingResult);
		assertTrue(modelAndView.getModel().containsKey("klanten"));
	}
}
