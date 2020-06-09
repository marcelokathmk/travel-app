package pt.com.travelApp.skypicker.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FlightDTOData {

	@JsonProperty("price")
	private BigDecimal price;
	
	@JsonProperty("bags_price")
	private FlightDTOBagPrice bagsPrice;

	public FlightDTOData() {
		this.bagsPrice = new FlightDTOBagPrice();
	}
	
	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public FlightDTOBagPrice getBagsPrice() {
		return bagsPrice;
	}

	public void setBagsPrice(FlightDTOBagPrice bagsPrice) {
		this.bagsPrice = bagsPrice;
	}
}
