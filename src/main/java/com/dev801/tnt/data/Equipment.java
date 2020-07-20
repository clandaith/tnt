package com.dev801.tnt.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "equipment_view")
public class Equipment implements Serializable {
	private static final long serialVersionUID = 7170132495636854470L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String item;
	private Integer cost;

	@Column(name = "rarity_id")
	private Integer rarityId;

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

	public Integer getRarityId() {
		return rarityId;
	}

	public void setRarityId(Integer rarityId) {
		this.rarityId = rarityId;
	}

	public String getRarityLevelName() {
		return rarityLevelName;
	}

	public void setRarityLevelName(String rarityLevelName) {
		this.rarityLevelName = rarityLevelName;
	}
}
