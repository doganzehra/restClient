package com.bilgeadam.restClient.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
public class Ogretmen {

	private Long ID;

	private String NAME;

	private Boolean IS_GICIK = false;

	@JsonBackReference
	private Set<Ders> dersler = new HashSet<>();

	public Ogretmen(String nAME, Boolean iS_GICIK) {
		NAME = nAME;
		IS_GICIK = iS_GICIK;
	}
}
