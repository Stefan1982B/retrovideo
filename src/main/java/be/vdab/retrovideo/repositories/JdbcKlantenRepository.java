package be.vdab.retrovideo.repositories;

import java.util.Collections;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import be.vdab.retrovideo.entities.Klant;

@Repository
class JdbcKlantenRepository implements KlantenRepository {

	private final NamedParameterJdbcTemplate template;

	JdbcKlantenRepository(NamedParameterJdbcTemplate template) {
		this.template = template;
	}
			
	private static final String SELECT_BY_NAAM_BEVAT = "select id, familienaam, voornaam, straatNummer, postcode, gemeente from klanten where familienaam like :zoals order by familienaam";

	private final RowMapper<Klant> klantRowMapper = (resultSet, rowNum) -> new Klant(resultSet.getInt("id"), resultSet.getString("familienaam"), resultSet.getString("voornaam"), resultSet.getString("straatNummer"), resultSet.getString("postcode"),  resultSet.getString("gemeente"));
	
	@Override
	public List<Klant> findByFamilienaamBevat(String deelNaam) {
	    return template.query(SELECT_BY_NAAM_BEVAT, Collections.singletonMap("zoals", '%' + deelNaam + '%'), klantRowMapper);   } 

}
