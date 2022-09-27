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

public class DersOgrenci {

	private Long ID;

	private Ders ders;

	private Ogrenci ogrenci;

	private Integer DEVAMSIZLIK;

	private Integer NOTE;

	public DersOgrenci(Ders ders, Ogrenci ogrenci, Integer dEVAMSIZLIK, Integer nOTE) {
		this.ders = ders;
		this.ogrenci = ogrenci;
		DEVAMSIZLIK = dEVAMSIZLIK;
		NOTE = nOTE;
	}
}
