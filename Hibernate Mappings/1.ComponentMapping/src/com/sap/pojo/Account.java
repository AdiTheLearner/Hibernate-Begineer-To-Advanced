package com.sap.pojo;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
@Entity
@Embeddable
public class Account {
	@Column(name="ACCOUNTNO")
	private int accountNo;
	@Column(name="ACCOUNTNAME")
	private String accountName;
	@Column(name="BALANCE")
	private float accountBalance;

	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public float getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(float accountBalance) {
		this.accountBalance = accountBalance;
	}

}
