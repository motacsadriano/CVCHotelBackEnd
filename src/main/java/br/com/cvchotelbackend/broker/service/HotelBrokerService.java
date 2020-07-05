package br.com.cvchotelbackend.broker.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.cvchotelbackend.broker.domain.Hotel;

@Service
public class HotelBrokerService {

	public Hotel[] getHotelByCityCode(Integer cityCode) {
		RestTemplate restTemplate = new RestTemplate();
		
		Hotel[] hotels = restTemplate.getForObject("https://cvcbackendhotel.herokuapp.com/hotels/avail/"+cityCode, Hotel[].class);
		
		return hotels;
	}
	
	public Hotel getHotelById(Integer cityCode, Integer hotelCode) {
		RestTemplate restTemplate = new RestTemplate();
		
		Hotel[] hotels = restTemplate.getForObject("https://cvcbackendhotel.herokuapp.com/hotels/"+hotelCode, Hotel[].class);
		int numberHotels = hotels.length;
		
		return hotels[numberHotels-1];
	}
}
