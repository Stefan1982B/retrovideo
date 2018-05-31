package be.vdab.retrovideo.repositories;

import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
class JdbcGenresRepository implements GenresRepository {

	private final NamedParameterJdbcTemplate template;

	JdbcGenresRepository(NamedParameterJdbcTemplate template) { 
		this.template = template;   }
	
	private final RowMapper<String> prijzenRowMapper = (resultSet, rowNum) -> resultSet.getString("naam"); 
	
	private static final String SELECT_UNIEKE_GENRES =   "select distinct naam from genres order by naam"; 

	@Override
	public List<String> findUniekeGenres() {
		  return template.query(SELECT_UNIEKE_GENRES, prijzenRowMapper);
	}

}
