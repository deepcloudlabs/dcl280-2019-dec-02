package com.example.mastermind.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 
 * @author Binnur Kurt (binnur.kurt@gmail.com)
 *
 */
@SuppressWarnings("serial")
@Component
@Scope("session")
public class Game implements Serializable {
	private String secret;
	private String guess; // setter+getter
	private int level; // setter+getter
	private int tries; // getter
	private List<Move> history; // getter
	private Random random = new Random();

	public Game() {
		history = new ArrayList<>();
	}

	@PostConstruct
	public void init() {
		history.clear();
		tries = 0;
		secret = createSecret();
	}

	public GameStatus play() {
		if (guess.equals(secret)) {
			level++;
			if (level > 8)
				return GameStatus.WIN;
			init();
			return GameStatus.PLAYING;
		}
		String message = evaluateGuess();
		tries++;
		if (tries > (level * 3 + 10))
			return GameStatus.GAME_OVER;
		history.add(new Move(guess, message));
		return GameStatus.PLAYING;
	}

	private String evaluateGuess() {
		int perfectMatch = 0, partialMatch = 0;
		for (int i = 0; i < secret.length(); ++i) {
			char s = secret.charAt(i);
			for (int j = 0; j < guess.length(); ++j) {
				char g = guess.charAt(j);
				if (s == g) {
					if (i == j)
						perfectMatch++;
					else
						partialMatch++;
				}
			}
		}
		String message = "";
		if (perfectMatch == 0 && partialMatch == 0)
			message = "No match!";
		else {
			if (partialMatch > 0)
				message = "-" + partialMatch;
			if (perfectMatch > 0)
				message += "+" + perfectMatch;
		}
		return message;
	}

	private String createSecret() {
		Set<Integer> number = new LinkedHashSet<>();
		number.add(createDigit(1, 9));
		while (number.size() < level) {
			number.add(createDigit(0, 9));
		}
		String numberString = "";
		for (int n : number)
			numberString += n;
		return numberString;
	}

	private int createDigit(int min, int max) {
		return random.nextInt(max - min + 1) + min;
	}

	public String getGuess() {
		return guess;
	}

	public void setGuess(String guess) {
		this.guess = guess;
	}

	public int getTries() {
		return tries;
	}

	public List<Move> getHistory() {
		return history;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

}
