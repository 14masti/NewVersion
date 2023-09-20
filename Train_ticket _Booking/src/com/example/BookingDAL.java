package com.example;

import java.sql.Timestamp;

public class BookingDAL {
	public double calfare(Ticket t) {
		int nop = t.getPl().size();
		double x = 100.0; // Replace with the actual fare per passenger
		double fare = nop * x;
		return fare;
	}

	public String getpnr() {
		Timestamp t = new Timestamp(System.currentTimeMillis());
		long p = t.getTime();
		String pnr = String.valueOf(p);
		return pnr;
	}

}
