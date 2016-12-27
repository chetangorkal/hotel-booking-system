package com.hname.exception;

public class RoomsNotAvailableException extends Exception {

	private static final long serialVersionUID = 1L;

	public RoomsNotAvailableException() {
		super("Requested amount of rooms are not available in the hotel. Please try in other hotel(s).");
	}
}
