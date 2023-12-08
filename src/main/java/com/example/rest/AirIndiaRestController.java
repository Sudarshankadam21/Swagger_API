package com.example.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.request.PassengerInfo;
import com.example.response.TicketInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api("This is Air India Distributed Component")
public class AirIndiaRestController {
	
	@ApiOperation("This is used to book Flight Ticket")
	@PostMapping(
			value="/bookFlightTicket",
			consumes= {
					"application/json",
					"application/xml"
			},
			produces= {
					 "application/json",
					 "application/xml"
			}
	)
	public ResponseEntity<TicketInfo> bookTicket(@RequestBody PassengerInfo pinfo) {
		// logic to book ticket

		// send ticket info
		TicketInfo ticket = new TicketInfo();
		ticket.setName(pinfo.getFname() + "" + pinfo.getLname());
		ticket.setFrom(pinfo.getFrom());
		ticket.setTo(pinfo.getTo());
		ticket.setTicketStatus("CONFIRM");
		ticket.setTicketPrice("4500.00 INR");
		ticket.setJourneyDate(pinfo.getJourneyDate());

		return new ResponseEntity<>(ticket, HttpStatus.CREATED);

	}

}
