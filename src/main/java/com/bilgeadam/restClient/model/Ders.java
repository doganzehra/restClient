package com.bilgeadam.restClient.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Ders {

	private Long ID;

	private Ogretmen ogretmen;

	private Konu konu;

	public Ders(Ogretmen ogretmen, Konu konu) {
		this.ogretmen = ogretmen;
		this.konu = konu;
	}
}
