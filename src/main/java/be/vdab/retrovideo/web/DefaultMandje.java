package be.vdab.retrovideo.web;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;


@Component
@SessionScope
class DefaultMandje implements Serializable, Mandje {

	  private static final long serialVersionUID = 1L; 
	  private final List<Integer> filmIds = new ArrayList<>();
	
	@Override
	public void addFilmId(int filmId) {
		filmIds.add(filmId);
		
	}

	@Override
	public List<Integer> getFilmIds() {
		return filmIds;
	}

	@Override
	public void verwijder(int[] ids) {
		Arrays.stream(ids).forEach(id -> filmIds.remove(Integer.valueOf(id)));
		
	}

	@Override
	public BigDecimal berekenTotalePrijs(List<BigDecimal> filmPrijzen) {
		return filmPrijzen.stream()
		.reduce((vorigeSom, getal) ->vorigeSom.add(getal)).orElse(BigDecimal.ZERO);
	}
	
}
