package br.com.cvchotelbackend.form;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2279903114750615709L;
	
	private Integer cityCode;
	private Integer hotelId;
	private LocalDate checkIn;
	private LocalDate checkOut;
	private Integer numberAdults;
	private Integer numberChildren;
}
