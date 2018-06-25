package com.yudhi.hotelreservation.controller;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yudhi.hotelreservation.model.Reservation;
import com.yudhi.hotelreservation.model.ReservationRequest;

@RestController
@RequestMapping(ResourceURIConstants.ROOM_RESERVATION_V1)
public class ReservationController {

	// This method is to get the available rooms
	// ISO date format = YYYY/MM/DD

	@RequestMapping(path = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Reservation> getAvailableRooms(
			@RequestParam(value = "checkin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkin,
			@RequestParam(value = "checkout") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkout) {
		return new ResponseEntity<>(new Reservation(), HttpStatus.OK);
	}

	@RequestMapping(path="", method = RequestMethod.POST , produces = MediaType.APPLICATION_JSON_UTF8_VALUE , consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Reservation> makeReservation(@RequestBody ReservationRequest reservationRequest)
	{
		return new ResponseEntity<>(new Reservation(), HttpStatus.CREATED);
		}
}
