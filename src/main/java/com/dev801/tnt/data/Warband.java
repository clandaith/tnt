package com.dev801.tnt.data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "warband")
public class Warband {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "warband_name")
	private String warbandName;

	private String background;

	@OneToMany(mappedBy = "warband")
	private List<TntCharacter> tntCharacters;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getWarbandName() {
		return warbandName;
	}

	public void setWarbandName(String warbandName) {
		this.warbandName = warbandName;
	}

	public String getBackground() {
		return background;
	}

	public void setBackground(String background) {
		this.background = background;
	}

	public List<TntCharacter> getTntCharacters() {
		return tntCharacters;
	}

	public void setTntCharacters(List<TntCharacter> tntCharacters) {
		this.tntCharacters = tntCharacters;
	}

	public void addTntCharacter(TntCharacter tntCharacter) {
		if (this.tntCharacters == null) {
			this.tntCharacters = new ArrayList<TntCharacter>();
		}

		this.tntCharacters.add(tntCharacter);
	}
}
