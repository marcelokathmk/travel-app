package pt.com.travelApp.component;

import java.util.concurrent.TimeUnit;

import org.springframework.cache.Cache;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.guava.GuavaCache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.cache.CacheBuilder;

@Configuration
@EnableCaching
public class CacheConfiguration {

	public final static String CACHE_FLIGHTS_INFO = "flightsInfo";
	
	@Bean
	public Cache cacheFlightsInfo() {
		return new GuavaCache(CACHE_FLIGHTS_INFO, CacheBuilder.newBuilder().expireAfterWrite(60, TimeUnit.SECONDS).build());
	}

}
