package pt.com.travelApp.skypicker.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FlightDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("search_id")
	private String searchId;
	
	@JsonProperty("data")
	private List<FlightDTOData> data;

	public String getSearchId() {
		return searchId;
	}

	public void setSearchId(String searchId) {
		this.searchId = searchId;
	}

	public List<FlightDTOData> getData() {
		return data;
	}

	public void setData(List<FlightDTOData> data) {
		this.data = data;
	}
	
	public BigDecimal getPriceAverage() {
		if	(this.data == null) {
			return BigDecimal.ZERO;
		}
		Double priceAverage = this.data.stream().map(f -> f.getPrice()).mapToDouble(BigDecimal::doubleValue).average().orElse(0.0);
		return BigDecimal.valueOf(priceAverage).setScale(2, RoundingMode.HALF_UP);
	}
	
	public BigDecimal getPriceBag1Average() {
		if	(this.data == null) {
			return BigDecimal.ZERO;
		}	
		Double bag1priceAverage = this.data.stream().map(f -> f.getBagsPrice().getOneBagPrice()).mapToDouble(BigDecimal::doubleValue).average().orElse(0.0);
		return BigDecimal.valueOf(bag1priceAverage).setScale(2, RoundingMode.HALF_UP);
	}
	
	public BigDecimal getPriceBag2Average() {
		if	(this.data == null) {
			return BigDecimal.ZERO;
		}
		Double bag2priceAverage = this.data.stream().map(f -> f.getBagsPrice().getTwoBagsPrice()).mapToDouble(BigDecimal::doubleValue).average().orElse(0.0);
		return BigDecimal.valueOf(bag2priceAverage).setScale(2, RoundingMode.HALF_UP);
	}
}
