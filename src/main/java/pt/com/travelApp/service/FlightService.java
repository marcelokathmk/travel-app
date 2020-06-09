package pt.com.travelApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt.com.travelApp.dto.FlightAvgDTO;
import pt.com.travelApp.dto.FlightBagsPriceDTO;
import pt.com.travelApp.skypicker.SkyPickerClient;
import pt.com.travelApp.skypicker.dto.FlightDTO;

@Service
public class FlightService {

	@Autowired
	private SkyPickerClient skyPickerClient;
	
	public FlightAvgDTO getFlightsAveragePrices(String flyFrom, String flyTo, String dateFrom, String dateTo, String currency, String airlines) {
		FlightDTO flightInfo = skyPickerClient.getFlightInformations(flyFrom, flyTo, dateFrom, dateTo, currency, airlines);
		
		FlightAvgDTO response = new FlightAvgDTO();
		response.setDestinationFrom(flyFrom);
		response.setDestinationTO(flyTo);
		response.setCurrency(currency);
		response.setPriceAverage(flightInfo.getPriceAverage());
		response.setBagsPrice(new FlightBagsPriceDTO(flightInfo.getPriceBag1Average(), flightInfo.getPriceBag2Average()));
		
		return response;
	}
}
