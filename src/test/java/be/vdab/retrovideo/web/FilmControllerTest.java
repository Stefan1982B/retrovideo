package be.vdab.retrovideo.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.when;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.retrovideo.entities.Film;
import be.vdab.retrovideo.services.FilmsService;

@RunWith(MockitoJUnitRunner.class) 
public class FilmControllerTest {

	@Mock
	private Mandje dummyMandje;
	@Mock
	private FilmsService dummyFilmsService;
	
	private FilmController controller;

	@Before
	public void before() {
		when(dummyFilmsService.read(1)).thenReturn(Optional.of(new Film(1,1,"Test",10,6,BigDecimal.valueOf(5))));
		controller = new FilmController(dummyFilmsService, dummyMandje);
	}

	@Test   
	public void ToonFilmWerktSamenMetFilmDotJsp() {    
		ModelAndView modelAndView = controller.toonFilm(1);    
		    assertEquals("film", modelAndView.getViewName());   } 
	
	@Test  
	public void ToonFilmGeeftFilmDoor() {   
		ModelAndView modelAndView = controller.toonFilm(1);     
		assertTrue(modelAndView.getModel().containsKey("film"));   }
	
	@Test  
	public void VoegFilmToeAanMandjeWerktSamenMetMandjeDotJsp() { 
		ModelAndView modelAndView = controller.voegFilmToeAanMandje(1);  
		assertEquals("redirect:/mandje", modelAndView.getViewName());  
		}   	 
	
	@Test   
	public void onbestaandeFilm() {  
		ModelAndView modelAndView = controller.voegFilmToeAanMandje(-1);   
		assertFalse(modelAndView.getModel().containsKey("filmId"));  
		}

}
