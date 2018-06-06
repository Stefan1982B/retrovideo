package be.vdab.retrovideo.entities;

import java.math.BigDecimal;

import org.springframework.format.annotation.NumberFormat;

public class TotalePrijs {
	@NumberFormat(pattern = "€ 0.00")
	private final BigDecimal waarde;

	public TotalePrijs(BigDecimal waarde) {
		this.waarde = waarde;
	}

	public BigDecimal getWaarde() {
		return waarde;
	}
}
