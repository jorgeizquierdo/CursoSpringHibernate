package com.hiberus.api.model.inheritance3;

import javax.persistence.*;

@Entity(name="owner3")
@Table(name="owner_3")
@AttributeOverrides({
    @AttributeOverride(name="firstname", column=@Column(name="firstname")),
    @AttributeOverride(name="lastname", column=@Column(name="lastname"))
})
public class Owner3 extends Person3 {

	@Column(name="stocks")
	private Long stocks;
	
	@Column(name="partnership_stake")
	private Long partnershipStake;

	public Owner3() {
	}
	
	public Owner3(String firstname, String lastname, Long stocks, Long partnershipStake) {
		
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
