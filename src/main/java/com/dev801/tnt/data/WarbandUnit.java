package com.dev801.tnt.data;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "warband_unit_types_view")
public class WarbandUnit implements Serializable {
	private static final long serialVersionUID = -2615961201055030198L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "warband_type_id")
	private WarbandType warbandType;

	@Column(name = "unit_type_id")
	private Integer unitTypeId;

	private String title;
	private Integer defense;
	private Integer wounds;
	private Integer move;
	private Integer melee;
	private Integer ranged;
	private Integer strength;
	private Integer mettle;

	@Column(name = "type_name")
	private String typeName;

	@Column(name = "base_cost")
	private Integer baseCost;

	@OneToMany(mappedBy = "warbandUnit")
	private Set<TntCharacter> tntCharacters;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public WarbandType getWarbandType() {
		return warbandType;
	}

	public void setWarbandType(WarbandType warbandType) {
		this.warbandType = warbandType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getUnitTypeId() {
		return unitTypeId;
	}

	public void setUnitTypeId(Integer unitTypeId) {
		this.unitTypeId = unitTypeId;
	}

	public Integer getDefense() {
		return defense;
	}

	public void setDefense(Integer defense) {
		this.defense = defense;
	}

	public Integer getWounds() {
		return wounds;
	}

	public void setWounds(Integer wounds) {
		this.wounds = wounds;
	}

	public Integer getMove() {
		return move;
	}

	public void setMove(Integer move) {
		this.move = move;
	}

	public Integer getMelee() {
		return melee;
	}

	public void setMelee(Integer melee) {
		this.melee = melee;
	}

	public Integer getRanged() {
		return ranged;
	}

	public void setRanged(Integer ranged) {
		this.ranged = ranged;
	}

	public Integer getStrength() {
		return strength;
	}

	public void setStrength(Integer strength) {
		this.strength = strength;
	}

	public Integer getMettle() {
		return mettle;
	}

	public void setMettle(Integer mettle) {
		this.mettle = mettle;
	}

	public Integer getBaseCost() {
		return baseCost;
	}

	public void setBaseCost(Integer baseCost) {
		this.baseCost = baseCost;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

}
