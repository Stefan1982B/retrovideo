package be.vdab.retrovideo.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

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

import be.vdab.retrovideo.entities.Genre;

@RunWith(SpringRunner.class)
@JdbcTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Import(JdbcGenresRepository.class)
@Sql("/insertGenre.sql")

public class JdbcGenresRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {


	@Autowired
	private JdbcGenresRepository repository;

	@Test
	public void findUniekeGenresVolgensId() {
		List<Genre> genres = repository.findUniekeGenres();
		long aantalGenres = super.jdbcTemplate.queryForObject("select count(distinct id) from genres", Long.class);
		assertEquals(aantalGenres, genres.size());
		int vorigeGenre = 0;
		for (Genre genre : genres) {
			assertTrue(genre.getId() > vorigeGenre);
			vorigeGenre = genre.getId();
		}

	}

}
