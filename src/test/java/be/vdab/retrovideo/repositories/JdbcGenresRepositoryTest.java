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

@RunWith(SpringRunner.class)
@JdbcTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Import(JdbcGenresRepository.class)
@Sql("/insertGenre.sql")

public class JdbcGenresRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {

	private static final String GENRES = "genres";

	@Autowired
	private JdbcGenresRepository repository;

	@Test
	public void findUniekeGenresVolgensAlfabet() {
		List<String> genres = repository.findUniekeGenres();
		long aantalGenres = super.jdbcTemplate.queryForObject("select count(distinct naam) from genres", Long.class);
		assertEquals(aantalGenres, genres.size());
		String vorigeGenre = "";
		for (String genre : genres) {
			assertTrue(genre.toLowerCase().compareTo(vorigeGenre.toLowerCase()) > 0);
			vorigeGenre = genre;
		}

	}

}
