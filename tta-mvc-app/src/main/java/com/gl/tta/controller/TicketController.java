package com.gl.tta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gl.tta.model.Ticket;
import com.gl.tta.service.TicketService;

@Controller
//@RestController
@RequestMapping("/tickets")

public class TicketController {

	@Autowired
	private TicketService ticketService;

	public TicketController(TicketService ticketService) {
		this.ticketService = ticketService;
	}

	@GetMapping("/list")
	public String listTickets(Model model) {
		List<Ticket> tck = this.ticketService.viewAllTickets();
		model.addAttribute("tickets", tck);
		return "tickets/ticket-list";
	}

	@GetMapping("/search")
	public String home(Model model, String keyword) {
		List<Ticket> tck = this.ticketService.searchTickets(keyword);
		model.addAttribute("tickets", tck);
		model.addAttribute("keyword", keyword);
		return "tickets/ticket-list";
	}

	@PostMapping("/save")
	public String saveTicket(@ModelAttribute("ticket") Ticket tck) {
		this.ticketService.saveATicket(tck);
		return "redirect:/tickets/list";
	}

	@GetMapping("/add")
	public String showFormForAdd(Model model) {
		// create model attribute to bind form data
		Ticket tck = new Ticket();

		model.addAttribute("TASK", "Create");
		model.addAttribute("ticket", tck);

		return "tickets/ticket-form";
	}

	@PostMapping("/delete")
	public String deleteEmployee(@RequestParam("id") int id) {
		this.ticketService.deleteTicketById(id);
		return "redirect:/tickets/list";
	}

	@PostMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("id") int id, Model model) {

		// get the ticket from the service
		Ticket tck = ticketService.findTicketById(id);

		// set ticket as a model attribute to pre-populate the form
		model.addAttribute("TASK", "Update");
		model.addAttribute("ticket", tck);

		return "tickets/ticket-form";
	}

	@PostMapping("/showFormForView")
	public String showFormForView(@RequestParam("id") int id, Model model) {

		// get the ticket from the service
		Ticket tck = ticketService.findTicketById(id);

		// set ticket as a model attribute to pre-populate the form
		model.addAttribute("TASK", "View");
		model.addAttribute("ticket", tck);

		return "tickets/ticket-form";
	}

}
