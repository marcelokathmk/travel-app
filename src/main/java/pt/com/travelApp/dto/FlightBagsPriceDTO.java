package pt.com.travelApp.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class FlightBagsPriceDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private BigDecimal bag1Average;
	
	private BigDecimal bag2Average;
	
	public FlightBagsPriceDTO(BigDecimal bag1Average, BigDecimal bag2Average) {
		super();
		this.bag1Average = bag1Average;
		this.bag2Average = bag2Average;
	}

	public BigDecimal getBag1Average() {
		return bag1Average;
	}

	public void setBag1Average(BigDecimal bag1Average) {
		this.bag1Average = bag1Average;
	}

	public BigDecimal getBag2Average() {
		return bag2Average;
	}

	public void setBag2Average(BigDecimal bag2Average) {
		this.bag2Average = bag2Average;
	}
}