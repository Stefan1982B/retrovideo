package be.vdab.retrovideo.repositories;

import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import be.vdab.retrovideo.entities.Genres;

@Repository
class JdbcGenresRepository implements GenresRepository {

	private final NamedParameterJdbcTemplate template;

	JdbcGenresRepository(NamedParameterJdbcTemplate template) { 
		this.template = template;   }
	
	private final RowMapper<Genres> GenreRowMapper = (resultSet, rowNum) -> new Genres(resultSet.getInt("id"), resultSet.getString("naam")); 
	
	private static final String SELECT_UNIEKE_GENRES =   "select distinct id, naam from genres order by id"; 

	@Override
	public List<Genres> findUniekeGenres() {
		  return template.query(SELECT_UNIEKE_GENRES, GenreRowMapper);
	}

}
