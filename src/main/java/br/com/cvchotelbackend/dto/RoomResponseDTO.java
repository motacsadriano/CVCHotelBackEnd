package br.com.cvchotelbackend.dto;

import java.io.Serializable;
import java.util.HashMap;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomResponseDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer roomID;
	private String categoryName;
	private Float totalPrice;
	private HashMap<String,Float> priceDetail;
}
