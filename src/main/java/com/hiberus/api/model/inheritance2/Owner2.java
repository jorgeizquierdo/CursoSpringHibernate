package com.hiberus.api.model.inheritance2;

import javax.persistence.*;

@Entity(name="owner2")
@Table(name="owner_2")
@PrimaryKeyJoinColumn(name="person_id")
public class Owner2 extends Person2 {

	@Column(name="stocks")
	private Long stocks;
	
	@Column(name="partnership_stake")
	private Long partnershipStake;

	public Owner2() {
	}
	
	public Owner2(String firstname, String lastname, Long stocks, Long partnershipStake) {
		
		super(firstname, lastname);
		
		this.stocks = stocks;
		this.partnershipStake = partnershipStake;
	}

	public Long getStocks() {
		return stocks;
	}

	public void setStocks(Long stocks) {
		this.stocks = stocks;
	}

	public Long getPartnershipStake() {
		return partnershipStake;
	}

	public void setPartnershipStake(Long partnershipStake) {
		this.partnershipStake = partnershipStake;
	}
	
}
