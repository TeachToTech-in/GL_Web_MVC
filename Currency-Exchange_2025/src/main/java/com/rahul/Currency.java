package com.rahul;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Currency {
	@Id
	private int id;
	@Column(name="from_Currency")
	private String from;
	@Column(name="to_Currency")
	private String to;
	private int rate;

	public Currency() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Currency(int id, String from, String to, int rate) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.rate = rate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

}
