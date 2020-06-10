package pt.com.travelApp.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import pt.com.travelApp.dto.FlightAvgDTO;
import pt.com.travelApp.service.FlightService;
import pt.com.travelApp.service.RequestLogService;
import pt.com.travelApp.util.JsonHelper;

@RestController
@RequestMapping(value = "/flight")
@Api(tags = {"Flights"})
public class FlightController extends BaseController{

	private static final Logger logger = LoggerFactory.getLogger(FlightController.class);
	
	@Autowired
	private RequestLogService requestLogService;
	
	@Autowired
	private FlightService flightService;
	
	/**
	 * This function returns a calculation of the price average of the total flights, and prices of the bags. 
	 * Should be filtered by destination and dates(from/to). 
	 * Besides that, can be filtered by currency (default EUR) and airlines (separeted by coma ,).
	 * 
	 * @param request
	 * @param flyFrom - ID of the departure location. Might be airport codes, city IDs, two letter country codes, metropolitan codes and radiuses as well as subdivision, region, autonomous_territory, continent and specials. Example: LIS.
	 * @param flyTo - ID of the arrival destination. It accepts the same value in the same format as the flyFrom parameter. Example: OPO.
	 * @param dateFrom - Date to search flights from this value. Date should be in the format "dd/mm/YYYY" and value be higher than current date value. Example: 08/09/2020.
	 * @param dateTo - Date to search flights upto this value. Date should be in the format "dd/mm/YYYY" and value be higher than date_from param value. Example: 10/09/2020.
	 * @param currency - Value to change the currency in the response. Optional parameter (default EUR). Example: GBP.
	 * @param airlines - A list of airlines (IATA codes) separated by ‘,’ (commas) that should be included in the search. Example: FR,TP.
	 * @return
	 */
	@GetMapping(value = "/avg")
	@ApiOperation(value = "This function returns a calculation of the price average of the total flights, and prices of the bags. Should be filtered by destination and dates(from/to). Besides that, can be filtered by currency (default EUR) and airlines (separeted by coma ,).")
	public ResponseEntity<FlightAvgDTO> avg(
			HttpServletRequest request,
			@ApiParam(value = "ID of the departure location. Might be airport codes, city IDs, two letter country codes, metropolitan codes and radiuses as well as subdivision, region, autonomous_territory, continent and specials. Example: LIS.")							
			@RequestParam(name = "fly_from") String flyFrom,
			@ApiParam(value = "ID of the arrival destination. It accepts the same value in the same format as the flyFrom parameter. Example: OPO.")
			@RequestParam(name = "fly_to") String flyTo,
			@ApiParam(value = "Date to search flights from this value. Date should be in the format \"dd/mm/YYYY\" and value be higher than current date value. Example: 08/09/2020.")
			@RequestParam(name = "date_from") String dateFrom,
			@ApiParam(value = "Date to search flights upto this value. Date should be in the format \"dd/mm/YYYY\" and value be higher than date_from param value. Example: 10/09/2020.")
			@RequestParam(name = "date_to") String dateTo,
			@ApiParam(value = "Value to change the currency in the response. Optional parameter (default EUR). Example: GBP.")
			@RequestParam(name = "curr", required = false, defaultValue = "EUR") String currency,
			@ApiParam(value = "A list of airlines (IATA codes) separated by ‘,’ (commas) that should be included in the search. Optional parameter. Example: FR,TP.")
			@RequestParam(name = "airlines", required = false) String airlines){
		
		logger.info("Receiving new request on /flight/avg. {}", getUrlRequest(request));
		
		FlightAvgDTO flightInfo = flightService.getFlightsAveragePrices(flyFrom, flyTo, dateFrom, dateTo, currency, airlines);
		
		requestLogService.save(getUrlRequest(request), JsonHelper.getJsonValueFromObject(flightInfo));
		
		return ResponseEntity.ok().body(flightInfo);
	}
}
