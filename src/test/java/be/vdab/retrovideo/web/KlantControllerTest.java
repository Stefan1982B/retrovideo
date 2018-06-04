package be.vdab.retrovideo.web;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

public class KlantControllerTest {
	
	private KlantController controller;
	
	@Before
	public void before() {
		controller = new KlantController();
	}

	@Test   
	public void KlantWerktSamenMetKlantDotJsp() {    
		ModelAndView modelAndView = controller.zoekKlant();    
		    assertEquals("klant", modelAndView.getViewName());   } 
	
	@Test  
	public void KlantGeeftVoorbeeldDoor() {   
		ModelAndView modelAndView = controller.zoekKlant();     
		assertTrue(modelAndView.getModel().containsKey("klant"));   }

}
