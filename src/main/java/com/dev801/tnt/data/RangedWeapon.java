package com.dev801.tnt.data;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ranged_weapons_view")
public class RangedWeapon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String type;

	@Column(name = "max_range")
	private Integer maxRange;

	private Integer strength;

	@Column(name = "one_handed")
	private Boolean oneHanded;

	private Integer reliability;

	private Integer cost;

	@Column(name = "rarity_id")
	private Integer rarityId;

	@Column(name = "rarity_level_name")
	private String rarityLevelName;

	@Column(name = "catagory_id")
	private Integer catagoryId;

	@Column(name = "catagory_name")
	private String catagoryName;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "ranged_weapons_special_rules_link", joinColumns = @JoinColumn(name = "ranged_weapon_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "special_rule_id", referencedColumnName = "id"))
	private Set<SpecialRule> specialRules;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getMaxRange() {
		return maxRange;
	}

	public void setMaxRange(Integer maxRange) {
		this.maxRange = maxRange;
	}

	public Integer getStrength() {
		return strength;
	}

	public void setStrength(Integer strength) {
		this.strength = strength;
	}

	public Boolean getOneHanded() {
		return oneHanded;
	}

	public void setOneHanded(Boolean oneHanded) {
		this.oneHanded = oneHanded;
	}

	public Integer getReliability() {
		return reliability;
	}

	public void setReliability(Integer reliability) {
		this.reliability = reliability;
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

	public Set<SpecialRule> getSpecialRules() {
		return specialRules;
	}

	public void setSpecialRules(Set<SpecialRule> specialRules) {
		this.specialRules = specialRules;
	}

	public Integer getCatagoryId() {
		return catagoryId;
	}

	public void setCatagoryId(Integer catagoryId) {
		this.catagoryId = catagoryId;
	}

	public String getCatagoryName() {
		return catagoryName;
	}

	public void setCatagoryName(String catagoryName) {
		this.catagoryName = catagoryName;
	}
}
