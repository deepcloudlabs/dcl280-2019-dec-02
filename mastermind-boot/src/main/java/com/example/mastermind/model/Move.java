package com.example.mastermind.model;

import java.io.Serializable;

/**
 * 
 * @author Binnur Kurt (binnur.kurt@gmail.com)
 *
 */
@SuppressWarnings("serial")
public class Move implements Serializable {
	private String guess;
	private String message;

	public Move(String guess, String message) {
		this.guess = guess;
		this.message = message;
	}

	public String getGuess() {
		return guess;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "Move [guess=" + guess + ", message=" + message + "]";
	}

}
