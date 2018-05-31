package be.vdab.retrovideo.repositories;

import java.util.Collections;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import be.vdab.retrovideo.entities.Films;

@Repository
class JdbcFilmsRepository implements FilmsRepository {

	private final NamedParameterJdbcTemplate template;

	JdbcFilmsRepository(NamedParameterJdbcTemplate template) {
		this.template = template;
	}

	private final RowMapper<Films> FilmsRowMapper = (resultSet, rowNum) -> new Films(resultSet.getInt("id"),
			resultSet.getInt("genreid"), resultSet.getString("titel"), resultSet.getInt("voorraad"),
			resultSet.getInt("gereserveerd"), resultSet.getBigDecimal("prijs"));

	private static final String SELECT_BY_ID = "select id, genreid, titel, voorraad, gereserveerd, prijs from films where genreid =:genreid order by titel";

	@Override
	public List<Films> findByGenre(int genreId) {
		return template.query(SELECT_BY_ID, Collections.singletonMap("genreid", genreId), FilmsRowMapper);
	}

}
