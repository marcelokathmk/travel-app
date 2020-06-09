package pt.com.travelApp.skypicker.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FlightDTOBagPrice {

	@JsonProperty("1")
	private BigDecimal oneBagPrice = BigDecimal.ZERO;
	
	@JsonProperty("2")
	private BigDecimal twoBagsPrice = BigDecimal.ZERO;

	public BigDecimal getOneBagPrice() {
		return oneBagPrice;
	}

	public void setOneBagPrice(BigDecimal oneBagPrice) {
		this.oneBagPrice = oneBagPrice;
	}

	public BigDecimal getTwoBagsPrice() {
		return twoBagsPrice;
	}

	public void setTwoBagsPrice(BigDecimal twoBagsPrice) {
		this.twoBagsPrice = twoBagsPrice;
	}
}
