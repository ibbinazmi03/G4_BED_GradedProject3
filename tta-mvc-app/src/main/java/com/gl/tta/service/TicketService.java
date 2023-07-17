package com.gl.tta.service;

import java.util.List;

import com.gl.tta.model.Ticket;

public interface TicketService {

	public List<Ticket> viewAllTickets();

	public List<Ticket> searchTickets(String keyword);

	public Ticket saveATicket(Ticket tck);

	public Ticket findTicketById(long id);

	public Ticket updateTicketById(long id, Ticket tck);

	public void deleteTicketById(long id);

}
