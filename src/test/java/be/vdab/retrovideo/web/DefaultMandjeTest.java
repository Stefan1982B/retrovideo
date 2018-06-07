package be.vdab.retrovideo.web;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import be.vdab.retrovideo.entities.TotalePrijs;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class DefaultMandjeTest {

	private DefaultMandje defaultMandje;

	@Before
	public void before() {
		defaultMandje = new DefaultMandje();
	}

	@Test
	public void berekenTotalePrijsGeeftTotalePrijs() {
		List<BigDecimal> prijzen = new ArrayList<>();
		prijzen.add(BigDecimal.valueOf(6));
		prijzen.add(BigDecimal.valueOf(4));
		assertEquals(new TotalePrijs(BigDecimal.valueOf(10)).getWaarde(),
				(defaultMandje.berekenTotalePrijs(prijzen)).getWaarde());
	}
}
