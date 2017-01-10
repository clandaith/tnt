package com.dev801.tnt.data;

public class WarbandUnitJSON {
	private Integer id;
	private Integer unitTypeId;
	private String title;
	private Integer defense;
	private Integer wounds;
	private Integer move;
	private Integer melee;
	private Integer ranged;
	private Integer strength;
	private Integer mettle;
	private String typeName;
	private Integer baseCost;

	public WarbandUnitJSON(WarbandUnit warbandUnit) {
		this.id = warbandUnit.getId();
		this.unitTypeId = warbandUnit.getUnitTypeId();
		this.title = warbandUnit.getTitle();
		this.defense = warbandUnit.getDefense();
		this.wounds = warbandUnit.getWounds();
		this.move = warbandUnit.getMove();
		this.melee = warbandUnit.getMelee();
		this.ranged = warbandUnit.getRanged();
		this.strength = warbandUnit.getStrength();
		this.mettle = warbandUnit.getMettle();
		this.typeName = warbandUnit.getTypeName();
		this.baseCost = warbandUnit.getBaseCost();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUnitTypeId() {
		return unitTypeId;
	}

	public void setUnitTypeId(Integer unitTypeId) {
		this.unitTypeId = unitTypeId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Integer getBaseCost() {
		return baseCost;
	}

	public void setBaseCost(Integer baseCost) {
		this.baseCost = baseCost;
	}
}
