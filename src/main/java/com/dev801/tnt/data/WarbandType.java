package com.dev801.tnt.data;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "warband_types")
public class WarbandType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;

	@OneToMany(mappedBy = "warbandType")
	private Set<WarbandUnit> warbandUnits;

	@OneToMany(mappedBy = "warbandTypeId")
	private Set<Warband> warbands;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<WarbandUnit> getWarbandUnits() {
		return warbandUnits;
	}

	public void setWarbandUnits(Set<WarbandUnit> warbandUnits) {
		this.warbandUnits = warbandUnits;
	}

}
