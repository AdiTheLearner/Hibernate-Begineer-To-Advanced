package com.sap.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "CreditCard")
@PrimaryKeyJoinColumn(name="txId")
public class CreditCard extends Payment {

	@Column(name = "cardNo")
	private int cardNo;
	@Column(name = "exprDate")
	private String exprDate;


	public int getCardNo() {
		return cardNo;
	}

	public void setCardNo(int cardNo) {
		this.cardNo = cardNo;
	}

	public String getExprDate() {
		return exprDate;
	}

	public void setExprDate(String exprDate) {
		this.exprDate = exprDate;
	}
}
