package be.vdab.retrovideo.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;

import be.vdab.retrovideo.entities.Film;
import be.vdab.retrovideo.exceptions.FilmNietGevondenException;

@RunWith(SpringRunner.class)
@JdbcTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Import(JdbcFilmsRepository.class)
@Sql("/insertFilm.sql")

public class JdbcFilmsRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {

	private static final String FILMS = "films";

	@Autowired
	private JdbcFilmsRepository repository;

	@Test
	public void findByGenre() {
		List<Film> films = repository.findByGenre(1);
		String vorigeFilm = "";
		for (Film film : films) {
			assertTrue(vorigeFilm.compareTo(film.getTitel()) <= 0);
			vorigeFilm = film.getTitel();
		}
		assertEquals(super.countRowsInTableWhere(FILMS, "genreid = 1"), films.size());
	}

	private int idVanTestFilm() {
		return super.jdbcTemplate.queryForObject("select id from films where titel='test'", int.class);
	}

	@Test
	public void read() {
		assertEquals("test", repository.read(idVanTestFilm()).get().getTitel());
	}

	@Test
	public void readOnbestaandeFilm() {
		assertFalse(repository.read(-1).isPresent());
	}

	@Test
	public void update() {
		int id = idVanTestFilm();
		Film film = new Film(id, 1, "test", 10, 6, BigDecimal.TEN);
		repository.update(film);
		assertEquals(7, repository.read(idVanTestFilm()).get().getGereserveerd());
	}

	@Test(expected = FilmNietGevondenException.class)
	public void updateOnbestaandeFilm() {
		int id = idVanTestFilm();
		Film film = new Film(id - 1, 2, "test", 10, 6, BigDecimal.TEN);
		repository.update(film);
	}
}
