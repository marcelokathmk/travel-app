package pt.com.travelApp.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public class FlightAvgDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String destinationFrom;
	
	private String destinationTO;
	
	private String currency;
	
	private BigDecimal priceAverage;
	
	private FlightBagsPriceDTO bagsPrice;
	
	private LocalDate dateFrom;
	
	private LocalDate dateTo;

	public LocalDate getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(LocalDate dateFrom) {
		this.dateFrom = dateFrom;
	}

	public LocalDate getDateTo() {
		return dateTo;
	}

	public void setDateTo(LocalDate dateTo) {
		this.dateTo = dateTo;
	}

	public String getDestinationFrom() {
		return destinationFrom;
	}

	public void setDestinationFrom(String destinationFrom) {
		this.destinationFrom = destinationFrom;
	}

	public String getDestinationTO() {
		return destinationTO;
	}

	public void setDestinationTO(String destinationTO) {
		this.destinationTO = destinationTO;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public BigDecimal getPriceAverage() {
		return priceAverage;
	}

	public void setPriceAverage(BigDecimal priceAverage) {
		this.priceAverage = priceAverage;
	}

	public FlightBagsPriceDTO getBagsPrice() {
		return bagsPrice;
	}

	public void setBagsPrice(FlightBagsPriceDTO bagsPrice) {
		this.bagsPrice = bagsPrice;
	}
}