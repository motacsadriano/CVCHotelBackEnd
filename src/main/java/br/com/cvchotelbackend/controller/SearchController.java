package br.com.cvchotelbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.cvchotelbackend.dto.HotelResponseDTO;
import br.com.cvchotelbackend.form.SearchForm;
import br.com.cvchotelbackend.service.SearchService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/v1/cvchotelbacken/hotels")
public class SearchController {

	@Autowired
	private SearchService service;
	
	@ApiOperation(
				value = "List of Hotels per City Code",
				notes = "It will return All Hotels avaliable in the list per City Code informed in the Request param"
			)
	@GetMapping
	public ResponseEntity<?> searchHotelByCity(@RequestParam Integer cityCode) {
		return ResponseEntity.ok(service.serchHotels(cityCode));
		
	}
	
	@ApiOperation(
				value = "Return List of Hotels or the Hotel details",
				notes = "At the Payload, if you just send City Code, CheckIn and CheckOut Dates, Number of Adults and the Number Children, "
						+ "it will return All the Avaliable Hotels per City Code with their expected Price."
						+ " If you send all the fields and the Hotel ID, it will return the total price for this specific Hotel selected."
						+ " Example without Hotel id = {\"checkIn\": \"2017-05-20\",\"checkOut\": \"2017-05-25\",\"cityCode\": 1032,\"numberAdults\": 2,\"numberChildren\": 1}"
						+ " Example with Hotel ID = {\"checkIn\": \"2017-05-20\",\"checkOut\":\"2017-05-25\",\"cityCode\": 9626,\"numberAdults\": 2,\"numberChildren\": 1,\"hotelId\": 6}")
	@PostMapping
	public ResponseEntity<?> getListHotels(@RequestBody SearchForm searchForm ) {
	
		if (searchForm.getHotelId() !=null) {
			HotelResponseDTO dto = service.getHotelFinalPrice(searchForm);
			return ResponseEntity.ok(dto);	

		} else {
			List<HotelResponseDTO> list = service.getListHotels(searchForm);
			return ResponseEntity.ok(list);
		}
	}

	
//	@GetMapping("/hotels")
//	public ResponseEntity<?> getResponse(	@RequestParam Integer cityCode,
//											@RequestParam LocalDate checkIn,
//											@RequestParam LocalDate checkOut,
//											@RequestParam Integer numberAdults,
//											@RequestParam Integer numberChildren,
//											@RequestParam Integer hotelId	) {
//	
//		SearchForm searchForm = new SearchForm();
//		searchForm.setCityCode(cityCode);
//		searchForm.setCheckIn(checkIn);
//		searchForm.setCheckOut(checkOut);
//		searchForm.setNumberAdults(numberAdults);
//		searchForm.setNumberChildren(numberChildren);
//		
//		if (hotelId!=null) {
//			searchForm.setHotelId(hotelId);
//		
//			List<HotelResponseDTO> list = service.getListHotels(searchForm);
//			
//			return ResponseEntity.ok(list);
//		} else {
//			HotelResponseDTO dto = service.getHotelFinalPrice(searchForm);
//			
//			return ResponseEntity.ok(dto);	
//		}
//		
//		
//		
//	}
}
