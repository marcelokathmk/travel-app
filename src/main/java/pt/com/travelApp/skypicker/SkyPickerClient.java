package pt.com.travelApp.skypicker;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import pt.com.travelApp.exception.SkyPickerClientException;
import pt.com.travelApp.skypicker.dto.FlightDTO;
import reactor.core.publisher.Mono;

@Component
public class SkyPickerClient {

	@Value("${skipicker.baseurl}")
	private String baseUrl;
	
	protected WebClient getClient() {
		return WebClient.create(baseUrl);
	}
	
	public FlightDTO getFlightInformations(String flyFrom, String flyTo, String dateFrom, String dateTo, String currency, String airlines) {
		try {
			StringBuilder url = new StringBuilder("/flights?");
			url.append("fly_from=").append(flyFrom);
			url.append("&fly_to=").append(flyTo);
			url.append("&partner=picky");
			url.append("&date_from=").append(dateFrom);
			url.append("&date_to=").append(dateTo);
			url.append("&curr=").append(currency);
			
			if	(airlines != null) {
				url.append("&select_airlines=").append(airlines);
			}
			
			Mono<FlightDTO> response = getClient().get().uri(url.toString()).retrieve().bodyToMono(FlightDTO.class);
			return response.block(Duration.ofSeconds(5));
		} catch (WebClientResponseException e) {
			throw new SkyPickerClientException(e.getMessage(), e);
		}
	}
}
