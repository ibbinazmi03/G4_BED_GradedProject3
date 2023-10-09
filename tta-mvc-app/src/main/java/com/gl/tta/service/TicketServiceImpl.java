package com.gl.tta.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.tta.model.Ticket;
import com.gl.tta.repository.TicketRepostory;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketRepostory ticketRepo;

	@Override
	public List<Ticket> viewAllTickets() {
		// TODO Auto-generated method stub
		return this.ticketRepo.findAll();
	}

	@Override
	public List<Ticket> searchTickets(String keyword) {
		// TODO Auto-generated method stub
		return this.ticketRepo.findByTitleIgnoreCaseContainingOrShortDescriptionIgnoreCaseContaining(keyword, keyword);
	}

	@Override
	public Ticket saveATicket(Ticket tck) {
		// TODO Auto-generated method stub
		long millis = System.currentTimeMillis();
		Date date = new Date(millis);
		tck.setCreateDate(date);
		return this.ticketRepo.save(tck);
	}

	@Override
	public Ticket findTicketById(long id) {
		// TODO Auto-generated method stub
		return this.ticketRepo.findById(id).orElseThrow(null);
	}

	@Override
	public Ticket updateTicketById(long id, Ticket tck) {
		// TODO Auto-generated method stub
		Optional<Ticket> findById = this.ticketRepo.findById(id);
		if (findById.isPresent()) {
			Ticket tck2 = findById.get();
			tck2.setTitle(tck.getTitle());
			tck2.setShortDescription(tck.getShortDescription());
			tck2.setContent(tck.getShortDescription());
			this.ticketRepo.save(tck2);
		}

		return tck;
	}

	@Override
	public void deleteTicketById(long id) {
		// TODO Auto-generated method stub
		this.ticketRepo.deleteById(id);
	}

}
