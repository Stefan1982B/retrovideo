package be.vdab.retrovideo.repositories;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import be.vdab.retrovideo.entities.Film;
import be.vdab.retrovideo.exceptions.FilmNietGevondenException;

@Repository
class JdbcFilmsRepository implements FilmsRepository {

	private final NamedParameterJdbcTemplate template;

	JdbcFilmsRepository(NamedParameterJdbcTemplate template) {
		this.template = template;
	}

	private final RowMapper<Film> filmsRowMapper = (resultSet, rowNum) -> new Film(resultSet.getInt("id"),
			resultSet.getInt("genreid"), resultSet.getString("titel"), resultSet.getInt("voorraad"),
			resultSet.getInt("gereserveerd"), resultSet.getBigDecimal("prijs"));

	private static final String SELECT_BY_ID = "select id, genreid, titel, voorraad, gereserveerd, prijs from films where genreid =:genreid order by titel";

	@Override
	public List<Film> findByGenre(int genreId) {
		return template.query(SELECT_BY_ID, Collections.singletonMap("genreid", genreId), filmsRowMapper);
	}

	private static final String READ = "select id, genreid, titel, voorraad, gereserveerd, prijs from films where id= :id"; 
	
	@Override
	public Optional<Film> read(int id) {
		try {
			return Optional.of(template.queryForObject(READ, Collections.singletonMap("id", id), filmsRowMapper));
		} catch (IncorrectResultSizeDataAccessException ex) {
			return Optional.empty();
		}
	}
	
	private static final String UPDATE_FILM = "update film set gereserveerd = :gereserveerd";
	
	@Override
	public void update(Film film) {
		  Map<String, Object> parameters = new HashMap<>();
		  parameters.put("gereserveerd", film.getGereserveerd()+1);  
		  if (template.update(UPDATE_FILM, parameters) == 0) {  
			  throw new FilmNietGevondenException();  
			  } 
		  } 	
	}


