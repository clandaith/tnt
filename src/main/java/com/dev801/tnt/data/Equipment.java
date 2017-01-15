package com.dev801.tnt.data;

import javax.persistence.Column;
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

	@Column(name = "rarity_level_name")
	private String rarityLevelName;

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

	public String getRarityLevelName() {
		return rarityLevelName;
	}

	public void setRarityLevelName(String rarityLevelName) {
		this.rarityLevelName = rarityLevelName;
	}
}
