package pt.com.travelApp.service;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import pt.com.travelApp.component.CacheConfiguration;
import pt.com.travelApp.dto.FlightAvgDTO;
import pt.com.travelApp.dto.FlightBagsPriceDTO;
import pt.com.travelApp.skypicker.SkyPickerClient;
import pt.com.travelApp.skypicker.dto.FlightDTO;
import pt.com.travelApp.util.DateUtils;

@Service
public class FlightService {

	private static final Logger logger = LoggerFactory.getLogger(FlightService.class);
	
	@Autowired
	private SkyPickerClient skyPickerClient;
	
	@Cacheable(CacheConfiguration.CACHE_FLIGHTS_INFO)
	public FlightAvgDTO getFlightsAveragePrices(String flyFrom, String flyTo, String dateFrom, String dateTo, String currency, String airlines) {
		logger.info("Init process to get Flight Informations from Skypicker API.");
		
		LocalDate localDateFrom = DateUtils.fromStringToLocalDate(dateFrom);
		LocalDate localDateTo = DateUtils.fromStringToLocalDate(dateTo);
		
		FlightDTO flightInfo = skyPickerClient.getFlightInformations(flyFrom, flyTo, dateFrom, dateTo, currency, airlines);
		
		FlightAvgDTO response = new FlightAvgDTO();
		response.setDestinationFrom(flyFrom);
		response.setDestinationTO(flyTo);
		response.setCurrency(currency);
		response.setPriceAverage(flightInfo.getPriceAverage());
		response.setBagsPrice(new FlightBagsPriceDTO(flightInfo.getPriceBag1Average(), flightInfo.getPriceBag2Average()));
		response.setDateFrom(localDateFrom);
		response.setDateTo(localDateTo);
		
		logger.info("Finished process to get Flight Informations from Skypicker API.");
		return response;
	}
}
