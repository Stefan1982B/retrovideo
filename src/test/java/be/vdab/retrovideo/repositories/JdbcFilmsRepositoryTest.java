package be.vdab.retrovideo.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
	public void test() {
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
}
