package br.com.cvchotelbackend.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HotelResponseDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1388118571979102513L;
	private Integer id;
	private String cityName;
	private List<RoomResponseDTO> rooms;
}
