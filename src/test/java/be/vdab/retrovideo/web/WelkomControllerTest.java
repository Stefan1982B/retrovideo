package be.vdab.retrovideo.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.retrovideo.services.FilmsService;
import be.vdab.retrovideo.services.GenresService;


@RunWith(MockitoJUnitRunner.class) 
public class WelkomControllerTest {
	
	@Mock
	private GenresService dummyGenresService;
	@Mock
	private FilmsService dummyFilmsService;
	
	private WelkomController controller;

	@Before
	public void before() {
		controller = new WelkomController(dummyGenresService, dummyFilmsService);
	}

	@Test   
	public void WelkomWerktSamenMetWelkomDotJsp() {    
		ModelAndView modelAndView = controller.welkom();    
		    assertEquals("welkom", modelAndView.getViewName());   } 
	
	@Test  
	public void WelkomGeeftGenresDoor() {   
		ModelAndView modelAndView = controller.welkom();     
		assertTrue(modelAndView.getModel().containsKey("genres"));   }
	
	@Test  
	public void findFilmsByGenreWerktSamenMetWelkomDotJsp() { 
		ModelAndView modelAndView = controller.findFilmsByGenre(1);  
		assertEquals("welkom", modelAndView.getViewName());  
		}   
	
	@Test   
	public void findDilmsByGenreGeeftFilmsDoor() { 
		ModelAndView modelAndView = controller.findFilmsByGenre(1);  
		assertTrue(modelAndView.getModel().containsKey("genreFilms"));  
		}  
	
	
	@Test   
	public void onbestaandeGenre() {  
		ModelAndView modelAndView = controller.findFilmsByGenre(-1);   
		assertFalse(modelAndView.getModel().containsKey("genreFilms"));  
		}
	}

