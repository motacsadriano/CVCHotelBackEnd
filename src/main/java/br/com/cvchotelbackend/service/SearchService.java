package br.com.cvchotelbackend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cvchotelbackend.broker.domain.Hotel;
import br.com.cvchotelbackend.broker.service.HotelBrokerService;
import br.com.cvchotelbackend.dto.HotelResponseDTO;
import br.com.cvchotelbackend.form.SearchForm;
import br.com.cvchotelbackend.util.MapperResponse;

@Service
public class SearchService {

	@Autowired
	private HotelBrokerService hotelBrokerService;
	
	private Hotel[] getListHotelsFromBroker(Integer cityCode) {
		return hotelBrokerService.getHotelByCityCode(cityCode);
	}
	
	private Hotel getHotelFromBroker(Integer cityCode, Integer hotelCode) {
		return hotelBrokerService.getHotelById(cityCode, hotelCode);
	}
	
	public Hotel[] serchHotels(Integer cityCode) {
		return this.getListHotelsFromBroker(cityCode);
	}
	
	public HotelResponseDTO getHotelFinalPrice(SearchForm searchForm) {
		
		Hotel hotel = this.getHotelFromBroker(searchForm.getCityCode(), searchForm.getHotelId());
		HotelResponseDTO dto = new HotelResponseDTO();
		
		dto.setCityName(hotel.getCityName());
		dto.setId(hotel.getId());
		
		dto.setRooms(MapperResponse.getListRoomsDTO(searchForm, hotel));
		
		return dto;
	}
	
	public List<HotelResponseDTO> getListHotels(SearchForm searchForm) {
		List<HotelResponseDTO> list = new ArrayList<>();
		
		Hotel[] hotels = this.getListHotelsFromBroker(searchForm.getCityCode());
		
		for (Hotel hotel : hotels) {
			HotelResponseDTO dto = new HotelResponseDTO();
			
			dto.setCityName(hotel.getCityName());
			dto.setId(hotel.getId());
			
			dto.setRooms(MapperResponse.getListRoomsDTO(searchForm, hotel));
			
			list.add(dto);
		}
		
		return list;
	}
}