package br.com.cvchotelbackend.util;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import br.com.cvchotelbackend.broker.domain.Hotel;
import br.com.cvchotelbackend.broker.domain.Room;
import br.com.cvchotelbackend.dto.RoomResponseDTO;
import br.com.cvchotelbackend.form.SearchForm;

public class MapperResponse {

	public static List<RoomResponseDTO> getListRoomsDTO (SearchForm searchForm, Hotel hotel) {
		List<RoomResponseDTO> listRoomsDTO = new ArrayList<>();
		
		float pricePerDayAdult = 0;
		float pricePerDayChild = 0;
		float totalPrice = 0;
		float commissionAdult = 0;
		float commissionChildren = 0;
		float totalPricePerAdult = 0;
		float totalPricePerChild = 0;
		
		long numberOfDays = ChronoUnit.DAYS.between(searchForm.getCheckIn(), searchForm.getCheckOut());
		
		for (Room room : hotel.getRooms()) {
			RoomResponseDTO roomResponseDTO = new RoomResponseDTO();
			
			roomResponseDTO.setCategoryName(room.getCategoryName());
			roomResponseDTO.setRoomID(room.getRoomID());
			
			HashMap<String, Float> priceDetail = new HashMap<>();
			
			//Calculating Price per Adults
			pricePerDayAdult = numberOfDays * room.getPrice().get("adult");
			priceDetail.put("pricePerDayAdult", pricePerDayAdult);
			
			//Calculating Price per Child
			pricePerDayChild = numberOfDays * room.getPrice().get("child");
			priceDetail.put("pricePerDayChild", pricePerDayChild);
			
			roomResponseDTO.setPriceDetail(priceDetail);
			
			//Calculating Total Price per Adult
			totalPricePerAdult = searchForm.getNumberAdults()  * pricePerDayAdult;
			
			//Calculating Comission per Adult 
			commissionAdult = (float) (pricePerDayAdult / 0.7);
			
			//Calculating Total Price per Child
			totalPricePerChild = searchForm.getNumberChildren() * pricePerDayChild;
		
			//Calculating Comission per Child
			commissionChildren = (float) (totalPricePerChild / 0.7);
			
			//Calculating total Hotel Price + Comission
			totalPrice = (totalPricePerAdult + commissionAdult) + (totalPricePerChild + commissionChildren);
			roomResponseDTO.setTotalPrice(totalPrice);
			
			listRoomsDTO.add(roomResponseDTO);
		}
		
		return listRoomsDTO;
	}
}
