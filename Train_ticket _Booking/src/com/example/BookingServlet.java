package com.example;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BookingServlet")
public class BookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BookingServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/*
	 * protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
	 * IOException { // Retrieve parameters from the request String from = request.getParameter("from"); String to =
	 * request.getParameter("to"); String trainName = request.getParameter("train"); String clas =
	 * request.getParameter("class"); String date = request.getParameter("date");
	 * 
	 * ArrayList<Passenger> passengers = new ArrayList<>(); for (int i = 1; ; i++) { String passengerName =
	 * request.getParameter("passengerName" + i); if (passengerName == null) { break; } String passengerAge =
	 * request.getParameter("passengerAge" + i); String passengerGender = request.getParameter("passengerGender" + i);
	 * String passengerBerth = request.getParameter("passengerBerth" + i);
	 * 
	 * Passenger passenger = new Passenger(); passenger.setName(passengerName); passenger.setAge(passengerAge);
	 * passenger.setGender(passengerGender); passenger.setBerth(passengerBerth);
	 * 
	 * passengers.add(passenger); }
	 * 
	 * // Prepare a response message StringBuilder responseMessage = new StringBuilder();
	 * responseMessage.append("Parameters received by the servlet:\n");
	 * responseMessage.append("From: ").append(from).append("\n");
	 * responseMessage.append("To: ").append(to).append("\n");
	 * responseMessage.append("Train: ").append(trainName).append("\n");
	 * responseMessage.append("Class: ").append(clas).append("\n");
	 * responseMessage.append("Date: ").append(date).append("\n");
	 * 
	 * for (int i = 0; i < passengers.size(); i++) { Passenger passenger = passengers.get(i);
	 * responseMessage.append("Passenger ").append(i + 1).append(":\n");
	 * responseMessage.append("Name: ").append(passenger.getName()).append("\n");
	 * responseMessage.append("Age: ").append(passenger.getAge()).append("\n");
	 * responseMessage.append("Gender: ").append(passenger.getGender()).append("\n");
	 * responseMessage.append("Berth: ").append(passenger.getBerth()).append("\n"); }
	 * 
	 * // Print the response message in the servlet page response.setContentType("text/plain");
	 * response.setCharacterEncoding("UTF-8"); PrintWriter out = response.getWriter();
	 * out.write(responseMessage.toString()); }
	 */
	/*
	 * 
	 * protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
	 * IOException { // TODO Auto-generated method stub String from = request.getParameter("from"); String to =
	 * request.getParameter("to"); String trainName = request.getParameter("train"); String clas =
	 * request.getParameter("class"); String d = request.getParameter("date"); String name[] =
	 * request.getParameterValues("passengerName"); String age[] = request.getParameterValues("passengerAge"); String
	 * gender[] = request.getParameterValues("passengerGender"); String berth[] =
	 * request.getParameterValues("passengerBerth"); ArrayList<Passenger> pl = new ArrayList<>(); for (int i = 0; i <
	 * name.length; i++) { Passenger p = new Passenger(name[i], gender[i], age[i], berth[i]); pl.add(p); } Ticket t =
	 * new Ticket(from, to, trainName, clas, d, pl); BookingDAL bd = new BookingDAL(); double cost = bd.calfare(t);
	 * String pnr = bd.getpnr();
	 * 
	 * request.setAttribute("cost", cost); request.setAttribute("ticket", t); request.setAttribute("pnr", pnr);
	 * 
	 * // Redirect to confirmation.jsp after successful booking RequestDispatcher dispatcher =
	 * request.getRequestDispatcher("confirmation.jsp"); dispatcher.forward(request, response); }
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Retrieve parameters from the request
		String from = request.getParameter("from");
		String to = request.getParameter("to");
		String trainName = request.getParameter("train");
		String clas = request.getParameter("trainClass");
		String d = request.getParameter("date");
		String name[] = request.getParameterValues("passengername");
		String age[] = request.getParameterValues("passengerage");
		String gender[] = request.getParameterValues("passengergender");
		String berth[] = request.getParameterValues("passengerberth");
		ArrayList<Passenger> pl = new ArrayList<>();
		for (int i = 0; i < name.length; i++) {
			Passenger p = new Passenger(name[i], gender[i], age[i], berth[i]);
			pl.add(p);
		}
		Ticket t = new Ticket(from, to, trainName, clas, d, pl);
		BookingDAL bd = new BookingDAL();
		double cost = bd.calfare(t);
		String pnr = bd.getpnr();

		request.setAttribute("cost", cost);
		request.setAttribute("ticket", t);
		request.setAttribute("pnr", pnr);

		// Redirect to confirmation.jsp after successful booking
		RequestDispatcher dispatcher = request.getRequestDispatcher("confirmation.jsp");
		dispatcher.forward(request, response);
	}
}
