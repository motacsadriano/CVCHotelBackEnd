package br.com.cvchotelbackend.broker.domain;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Hotel implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private Integer cityCode;
	private String cityName;
	private List<Room> rooms;
	
	@Override
	public String toString() {
		return "Hotel [id=" + id + ", name=" + name + ", cityCode=" + cityCode + ", cityName=" + cityName + ", rooms="
				+ rooms + "]";
	}
}
