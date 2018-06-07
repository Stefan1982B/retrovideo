package be.vdab.retrovideo.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.retrovideo.entities.Film;
import be.vdab.retrovideo.entities.Genre;
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
		List<Film> films = new ArrayList<>();
		films.add(new Film(1, 1, "Test", 10, 6, BigDecimal.valueOf(5)));
		when(dummyFilmsService.findByGenre(1)).thenReturn(films);
		List<Genre> genres = new ArrayList<>();
		genres.add(new Genre(1, "Test"));
		when(dummyGenresService.findUniekeGenres()).thenReturn(genres);
		controller = new WelkomController(dummyGenresService, dummyFilmsService);
	}

	@Test
	public void WelkomWerktSamenMetWelkomDotJsp() {
		ModelAndView modelAndView = controller.welkom();
		assertEquals("welkom", modelAndView.getViewName());
	}

	@Test
	public void WelkomGeeftGenresDoor() {
		ModelAndView modelAndView = controller.welkom();
		assertTrue(modelAndView.getModel().containsKey("genres"));
	}

	@Test
	public void findFilmsByGenreWerktSamenMetWelkomDotJsp() {
		ModelAndView modelAndView = controller.findFilmsByGenre(1);
		assertEquals("welkom", modelAndView.getViewName());
	}

	@Test
	public void findFilmsByGenreGeeftFilmsDoor() {
		ModelAndView modelAndView = controller.findFilmsByGenre(1);
		assertTrue(modelAndView.getModel().containsKey("genreFilms"));
	}
}
