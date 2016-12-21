package com.dev801.tnt.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "equipment_view")
public class Equipment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String item;
	private Integer cost;
	private Integer rarity_id;
	private String rarity_level_name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	public Integer getRarity_id() {
		return rarity_id;
	}

	public void setRarity_id(Integer rarity_id) {
		this.rarity_id = rarity_id;
	}

	public String getRarity_level_name() {
		return rarity_level_name;
	}

	public void setRarity_level_name(String rarity_level_name) {
		this.rarity_level_name = rarity_level_name;
	}
}
