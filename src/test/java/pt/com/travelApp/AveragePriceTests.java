package pt.com.travelApp;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import pt.com.travelApp.skypicker.dto.FlightDTO;
import pt.com.travelApp.skypicker.dto.FlightDTOBagPrice;
import pt.com.travelApp.skypicker.dto.FlightDTOData;

@SpringBootTest
public class AveragePriceTests {

	@Test
	public void testAveragePricesTest() {
		FlightDTO dto = new FlightDTO();
		
		List<FlightDTOData> data = new ArrayList<>();
		
		FlightDTOData data1 = new FlightDTOData();
		data1.setPrice(new BigDecimal(250.99));
		data.add(data1);
		
		FlightDTOData data2 = new FlightDTOData();
		data2.setPrice(new BigDecimal(345.50));
		data.add(data2);
		
		FlightDTOData data3 = new FlightDTOData();
		data3.setPrice(new BigDecimal(299.45));
		data.add(data3);
		
		dto.setData(data);
		
		assertThat(dto.getPriceAverage()).isEqualByComparingTo(new BigDecimal(298.65).setScale(2, RoundingMode.HALF_UP));
	}
	
	@Test
	public void testAveragePricesWithOneBagTest() {
		FlightDTO dto = new FlightDTO();
		
		List<FlightDTOData> data = new ArrayList<>();
		
		FlightDTOData data1 = new FlightDTOData();
		FlightDTOBagPrice bagPrice1 = new FlightDTOBagPrice();
		bagPrice1.setOneBagPrice(new BigDecimal(55.99));
		data1.setBagsPrice(bagPrice1);

		data.add(data1);
		
		FlightDTOData data2 = new FlightDTOData();
		FlightDTOBagPrice bagPrice2 = new FlightDTOBagPrice();
		bagPrice2.setOneBagPrice(new BigDecimal(69.99));
		data2.setBagsPrice(bagPrice2);
		data.add(data2);
		
		FlightDTOData data3 = new FlightDTOData();
		FlightDTOBagPrice bagPrice3 = new FlightDTOBagPrice();
		bagPrice3.setOneBagPrice(new BigDecimal(59.99));
		data3.setBagsPrice(bagPrice3);
		data.add(data3);
		
		dto.setData(data);
		
		assertThat(dto.getPriceBag1Average()).isEqualByComparingTo(new BigDecimal(61.99).setScale(2, RoundingMode.HALF_UP));
	}
	
	@Test
	public void testAveragePricesWithTwoBagsTest() {
		FlightDTO dto = new FlightDTO();
		
		List<FlightDTOData> data = new ArrayList<>();
		
		FlightDTOData data1 = new FlightDTOData();
		FlightDTOBagPrice bagPrice1 = new FlightDTOBagPrice();
		bagPrice1.setTwoBagsPrice(new BigDecimal(120.99));
		data1.setBagsPrice(bagPrice1);

		data.add(data1);
		
		FlightDTOData data2 = new FlightDTOData();
		FlightDTOBagPrice bagPrice2 = new FlightDTOBagPrice();
		bagPrice2.setTwoBagsPrice(new BigDecimal(169.99));
		data2.setBagsPrice(bagPrice2);
		data.add(data2);
		
		FlightDTOData data3 = new FlightDTOData();
		FlightDTOBagPrice bagPrice3 = new FlightDTOBagPrice();
		bagPrice3.setTwoBagsPrice(new BigDecimal(149.99));
		data3.setBagsPrice(bagPrice3);
		data.add(data3);
		
		dto.setData(data);
		
		assertThat(dto.getPriceBag2Average()).isEqualByComparingTo(new BigDecimal(146.99).setScale(2, RoundingMode.HALF_UP));
	}
}
