package com.example;

import java.util.ArrayList;

public class Ticket {
	private String from;
	private String to;
	private String trainName;
	private String clas;
	private String d;
	private ArrayList<Passenger> pl;

	public Ticket(String from, String to, String trainName, String clas, String d, ArrayList<Passenger> pl) {
		super();
		this.from = from;
		this.to = to;
		this.trainName = trainName;
		this.clas = clas;
		this.d = d;
		this.pl = pl;
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

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public String getClas() {
		return clas;
	}

	public void setClas(String clas) {
		this.clas = clas;
	}

	public String getD() {
		return d;
	}

	public void setD(String d) {
		this.d = d;
	}

	public ArrayList<Passenger> getPl() {
		return pl;
	}

	public void setPl(ArrayList<Passenger> pl) {
		this.pl = pl;
	}

}
