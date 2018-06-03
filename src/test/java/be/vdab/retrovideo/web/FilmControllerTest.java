package be.vdab.retrovideo.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.retrovideo.services.FilmsService;


public class FilmControllerTest {

	@Mock
	private Mandje mandje;
	@Mock
	private FilmsService dummyFilmsService;
	
	private FilmController controller;

	@Before
	public void before() {
		controller = new FilmController(dummyFilmsService, mandje);
	}

	@Test   
	public void ShowFilmWerktSamenMetFilmDotJsp() {    
		ModelAndView modelAndView = controller.showFilm(1);    
		    assertEquals("film", modelAndView.getViewName());   } 
	
	@Test  
	public void ShowFilmGeeftFilmsDoor() {   
		ModelAndView modelAndView = controller.showFilm(1);     
		assertTrue(modelAndView.getModel().containsKey("film"));   }
	
	@Test  
	public void VoegFilmToeAanMandjeWerktSamenMetMandjeDotJsp() { 
		ModelAndView modelAndView = controller.voegFilmToeAanMandje(1);  
		assertEquals("mandje", modelAndView.getViewName());  
		}   
	
	@Test   
	public void VoegFilmToeAanMandjeGeeftFilmsDoor() { 
		ModelAndView modelAndView = controller.voegFilmToeAanMandje(1);  
		assertTrue(modelAndView.getModel().containsKey("films"));  
		}  
	
	
	@Test   
	public void onbestaandeGenre() {  
		ModelAndView modelAndView = controller.voegFilmToeAanMandje(-1);   
		assertFalse(modelAndView.getModel().containsKey("genreFilms"));  
		}

}
