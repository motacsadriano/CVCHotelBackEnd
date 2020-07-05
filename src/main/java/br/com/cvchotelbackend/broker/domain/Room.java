package br.com.cvchotelbackend.broker.domain;

import java.io.Serializable;
import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Room implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5486954242366329427L;
	private Integer roomID;
	private String categoryName;
	private HashMap<String, Float> price;
	
	@Override
	public String toString() {
		return "Room [roomId=" + roomID + ", categoryNamey=" + categoryName + ", price=" + price + "]";
	}
}
